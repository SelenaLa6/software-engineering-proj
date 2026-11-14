package impserver;
import project.server.JobHandlerApi;
import project.server.JobResponseCode;
import project.server.SubmitJobRequest;
import project.server.SubmitJobResponse;

import java.util.Collection;
import java.util.List;

import impdatastore.LoadDataRequestImp;
import impdatastore.StoreDataRequestImp;
import impserver.impcompute.ComputeRequestImp;
import project.datastore.DataStoreApi;
import project.datastore.LoadDataRequest;
import project.datastore.LoadDataResponse;
import project.datastore.StoreDataRequest;
import project.datastore.StoreDataResponse;
import project.server.computation.ComputationApi;
import project.server.computation.ComputeRequest;
import project.server.computation.ComputeResponse;

public class JobHandlerImp implements JobHandlerApi {
    
    private DataStoreApi dataStore;
    private ComputationApi computeEngine;

    public JobHandlerImp(DataStoreApi dataStore, ComputationApi computeEngine) {
        this.dataStore = dataStore;
        this.computeEngine = computeEngine;
    }

    /*
    Only returns response code of SUCCESS if all steps of process were also successful.
    No response codes with more info yet, like if file didn't exist.
    */
    public SubmitJobResponse runJob(SubmitJobRequest request) {

        // Ask DataStore to load
        LoadDataRequest loadReq = new LoadDataRequestImp(request.getSource());
        LoadDataResponse loadResp = dataStore.load(loadReq);

        // If successfully loaded, try to pass to ComputeEngine
        if (loadResp.getResponseCode().successful) {

            List<String> delims = request.getDelimiters();

            /*
            Delimiters in List format must be in this order:
            0 - Field
            1 - Record
            2 - Open block
            3 - Close block
            Missing delimiters are treated as null.
            null delimiter is effectively an empty string.
            May want to change how delimiters are handled in SubmitJobRequest.
            */
            ComputeRequest computeReq = new ComputeRequestImp(
                loadResp.getData(),
                getDelimSafely(delims, 0),
                getDelimSafely(delims, 1),
                getDelimSafely(delims, 2),
                getDelimSafely(delims, 3)
            );

            ComputeResponse computeResp = computeEngine.compute(computeReq);

            // If successfully computed, ask DataStore to store
            if (computeResp.getResponseCode().successful) {

                Collection<String> output = computeResp.getOutput();

                StoreDataRequest storeReq = new StoreDataRequestImp(
                    request.getDestination(),
                    output);

                StoreDataResponse storeResp = dataStore.store(storeReq);

                // If successfully stored, job was run successfully
                if (storeResp.getResponseCode().successful) {
                    return new SubmitJobResponseImp(JobResponseCode.SUCCESS);
                }

            }

        }

        // Otherwise, job failed
        return new SubmitJobResponseImp(JobResponseCode.FAILURE);
    }

    /*
    Used to prevent IndexOutOfBoundsException when accessing delimiters
    from a List in order to construct a ComputeRequest.
    null is used to represent a missing delimiter.
    */
    private String getDelimSafely(List<String> delims, int i) {

        if (i < delims.size()) {
            return delims.get(i);
        } else {
            return null;
        }

    }

}
