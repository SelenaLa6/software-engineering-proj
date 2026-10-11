import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import project.server.SubmitJobRequest;
import project.server.SubmitJobResponse;
import project.server.computation.ComputationApi;
import project.datastore.DataStoreApi;
public class TestJobHandlerImp {
    
    @Test
    public void jobHandlerSmokeTest() {

        // Mock dependency APIs
        DataStoreApi mockDataStore = mock(DataStoreApi.class);
        ComputationApi mockCompute = mock(ComputationApi.class);

        JobHandlerImp testJobHandler = new JobHandlerImp(mockDataStore, mockCompute);

        // User submits some job to run.
        SubmitJobRequest mockRequest = mock(SubmitJobRequest.class);

        // Job Handler should return a response.
        SubmitJobResponse response = testJobHandler.runJob(mockRequest);

        // Response should tell user if job succeeded or not.
        if (response.getResponseCode().successful)
            System.out.println("Job was successful.");
        else
            System.out.println("Job was unsuccessful.");
        System.out.println("Response code: " + response.getResponseCode());

    }
    
}
