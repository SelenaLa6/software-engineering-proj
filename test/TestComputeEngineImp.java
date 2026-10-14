import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import project.server.computation.InputData;

import project.server.computation.ComputeRequest;
import project.server.computation.ComputeResponse;

public class TestComputeEngineImp {
    
    @Test 
    public void computeEngineSmokeTest() {

        ComputeEngineImp testComputeEngine = new ComputeEngineImp();

        // Client submits a request to compute something.
        ComputeRequest mockRequest = mock(ComputeRequest.class);
        when(mockRequest.getInputData())
            .thenReturn(mock(InputData.class));

        // Compute engine should successfully process the data.
        ComputeResponse response = testComputeEngine.compute(mockRequest);
        assertTrue(response.getResponseCode().successful);

    }

}
