import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import project.server.SubmitJobRequest;
import project.server.SubmitJobResponse;
import project.server.InputDataLocation;
import project.server.OutputDataLocation;
import project.server.computation.ComputationApi;
import project.datastore.DataStoreApi;
import project.datastore.LoadDataRequest;
import project.datastore.LoadDataResponse;
import project.datastore.StoreDataRequest;
import project.datastore.StoreDataResponse;
import project.server.computation.ComputeRequest;
import project.server.computation.ComputeResponse;
import project.datastore.LoadResponseCode;
import project.datastore.StoreResponseCode;
import project.server.computation.ComputeResponseCode;

public class TestJobHandlerImp {
    
    @Test
    public void jobHandlerSmokeTest() {

        // Mock dependency APIs
        DataStoreApi mockDataStore = mock(DataStoreApi.class);
        ComputationApi mockCompute = mock(ComputationApi.class);
        
        // Mock successful behavior for data store API
        LoadDataResponse mockLoadResponse = mock(LoadDataResponse.class);
        when(mockDataStore.load(any(LoadDataRequest.class)))
            .thenReturn(mockLoadResponse);
        when(mockLoadResponse.getResponseCode())
            .thenReturn(LoadResponseCode.SUCCESS);
        
        StoreDataResponse mockStoreResponse = mock(StoreDataResponse.class);
        when(mockDataStore.store(any(StoreDataRequest.class)))
            .thenReturn(mock(StoreDataResponse.class));
        when(mockStoreResponse.getResponseCode())
            .thenReturn(StoreResponseCode.SUCCESS);
        
        // Mock successful behavior for compute API
        ComputeResponse mockComputeResponse = mock(ComputeResponse.class);
        when(mockCompute.compute(any(ComputeRequest.class)))
            .thenReturn(mockComputeResponse);
        when(mockComputeResponse.getResponseCode())
            .thenReturn(ComputeResponseCode.SUCCESS);


        JobHandlerImp testJobHandler = new JobHandlerImp(mockDataStore, mockCompute);

        // User submits some job to run.
        SubmitJobRequest mockRequest = mock(SubmitJobRequest.class);
        when(mockRequest.getSource())
            .thenReturn(mock(InputDataLocation.class));
        when(mockRequest.getDestination())
            .thenReturn(mock(OutputDataLocation.class));
        when(mockRequest.getDelimiters())
            .thenReturn(new Character[] {',',';'});

        // Job Handler should return a response.
        SubmitJobResponse response = testJobHandler.runJob(mockRequest);

        // Response should be successful.
        assertTrue(response.getResponseCode().successful);

    }
    
}
