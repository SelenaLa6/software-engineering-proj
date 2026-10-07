import project.server.JobHandlerApi;
import project.server.SubmitJobRequest;
import project.server.SubmitJobResponse;
import project.datastore.DataStoreApi;
import project.server.computation.ComputationApi;

public class JobHandlerImp implements JobHandlerApi {
    
    private DataStoreApi dataStore;
    private ComputationApi computeEngine;

    public SubmitJobResponse runJob(SubmitJobRequest request) {
        return null;
    }

}
