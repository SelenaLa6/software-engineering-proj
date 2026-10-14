import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import project.datastore.LoadDataRequest;
import project.datastore.LoadDataResponse;
import project.datastore.StoreDataRequest;
import project.datastore.StoreDataResponse;
import project.server.InputDataLocation;
import project.server.OutputDataLocation;

public class TestDataStoreImp {
    
    @Test 
    public void dataStoreSmokeTest() {

        DataStoreImp testDataStore = new DataStoreImp();

        // Client asks to load some data.
        LoadDataRequest loadRequest = mock(LoadDataRequest.class);
        when(loadRequest.getLoadLocation())
            .thenReturn(mock(InputDataLocation.class));

        // Data Store should successfully load data.
        LoadDataResponse loadResponse = testDataStore.load(loadRequest);
        assertTrue(loadResponse.getResponseCode().successful);

        // Client asks to write some data.
        StoreDataRequest storeRequest = mock(StoreDataRequest.class);
        when(storeRequest.getStoreLocation())
            .thenReturn(mock(OutputDataLocation.class));

        // Data Store should successfully store data.
        StoreDataResponse storeResponse = testDataStore.store(storeRequest);
        assertTrue(storeResponse.getResponseCode().successful);
    }

}
