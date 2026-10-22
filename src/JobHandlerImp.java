import project.server.JobHandlerApi;
import project.server.SubmitJobRequest;
import project.server.SubmitJobResponse;
import project.datastore.DataStoreApi;
import project.server.computation.ComputationApi;

public class JobHandlerImp implements JobHandlerApi {
    
    private DataStoreApi dataStore;
    private ComputationApi computeEngine;

    // Just this constructor for now for testing purposes
    public JobHandlerImp(DataStoreApi dataStore, ComputationApi computeEngine) {
        this.dataStore = dataStore;
        this.computeEngine = computeEngine;
    }

    public SubmitJobResponse runJob(SubmitJobRequest request) {
        return null;
    }

}
