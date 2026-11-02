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
        InputData mockInput = mock(InputData.class);
        when(mockRequest.getInputData())
            .thenReturn(mockInput);
        // TODO: Mock behavior for mockInput when input format is finalized. Test input = 12, output = 1

        // Compute engine should successfully process the data.
        ComputeResponse response = testComputeEngine.compute(mockRequest);
        assertTrue(response.getResponseCode().successful);
        // TODO: Assert that output is 1 when output format is finalized.

    }

}
