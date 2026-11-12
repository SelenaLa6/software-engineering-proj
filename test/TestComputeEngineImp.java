import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.Collection;
import java.util.List;

import project.server.computation.ComputeRequest;
import project.server.computation.ComputeResponse;

public class TestComputeEngineImp {
    
    @Test 
    public void computeEngineSmokeTest() {

        ComputeEngineImp testComputeEngine = new ComputeEngineImp();

        // Client submits a request to compute something.
        ComputeRequest request = new ComputeRequestImp(
            List.of(12),
            ",",
            ";",
            null,
            null
        );
        
        ComputeResponse response = testComputeEngine.compute(request);

        assertTrue(response.getResponseCode().successful);
        assertEquals(1, response.getOutput().size());
        assertEquals("12,1;", response.getOutput().toArray()[0]);

    }

}
