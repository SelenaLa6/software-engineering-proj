import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import project.server.SubmitJobRequest;

import java.util.ArrayList;
import java.util.List;

public class ComputeEngineIntegrationTest {
    
    @Test 
    public void ComputeEngineTest() {

        // Instantiate all 3 APIs
        InMemDataStore testDataStore = new InMemDataStore();
        ComputeEngineImp testComputeEngine = new ComputeEngineImp();
        JobHandlerImp testJobHandler = new JobHandlerImp(
            testDataStore, testComputeEngine);

        // Initial input
        InMemInputConfig input = new InMemInputConfig();
        input.inputList = List.of(1,10,25);

        // Output write location
        InMemOutputConfig output = new InMemOutputConfig();
        output.outputList = new ArrayList<String>();

        // Make a new SubmitJobRequest
        SubmitJobRequest request = new SubmitJobRequestImp(input, output);

        // Submit request to JobHandler
        testJobHandler.runJob(request);

        // Validate output
        assertEquals("1,1",output.outputList.get(0));
        assertEquals("10,1",output.outputList.get(1));
        assertEquals("25,7",output.outputList.get(2));

    }

}
