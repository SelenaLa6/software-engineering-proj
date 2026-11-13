import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;

import project.server.computation.ComputationApi;
import project.server.computation.ComputeRequest;
import project.server.computation.ComputeResponse;

public class TestEdgeCaseDelim {
    
    @Test 
    public void percentSignDelimTest() {

        ComputationApi testComputeEngine = new ComputeEngineImp();

        // Client submits a request to compute something.
        ComputeRequest request = new ComputeRequestImp(
            List.of(12),
            ",",
            "%",
            null,
            null
        );
        
        ComputeResponse response = testComputeEngine.compute(request);

        assertTrue(response.getResponseCode().successful);
        assertEquals(1, response.getOutput().size());
        assertEquals("12,1%", response.getOutput().toArray()[0]);

    }

}
