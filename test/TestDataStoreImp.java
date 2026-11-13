import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collection;
import java.util.List;

import project.datastore.LoadDataRequest;
import project.datastore.LoadDataResponse;
import project.datastore.StoreDataRequest;
import project.datastore.StoreDataResponse;
import project.server.DataLocation;

public class TestDataStoreImp {

    @Test
    public void loadSmokeTest() throws Exception {

        DataStoreImp dataStore = new DataStoreImp();

        // Create a test file for loading
        String loadFilename = "load-test-file.txt";
        File loadFile = new File(loadFilename);
        loadFile.deleteOnExit();

        // Initialize the load file with some input data
        FileWriter fl = new FileWriter(loadFile);
        fl.write("1 2 3");
        fl.close();

        // Client asks to load data from load file.
        FileLocation fileLocation = new FileLocation(loadFilename);
        LoadDataRequest loadRequest = new LoadDataRequestImp(fileLocation);

        // Data Store should successfully load data.
        LoadDataResponse loadResponse = dataStore.load(loadRequest);
        
        assertTrue(loadResponse.getResponseCode().successful);
        
        // Check that the data store actually loaded all the data
        Collection<Integer> loadedData = loadResponse.getData();
        assertEquals(3, loadedData.size());
        assertTrue(loadedData.containsAll(List.of(1, 2, 3)));

    }

    @Test
    public void storeSmokeTest() throws Exception {

        DataStoreImp dataStore = new DataStoreImp();

        // Create a test file for storing
        String storeFilename = "store-test-file.txt";
        File storeFile = new File(storeFilename);
        storeFile.deleteOnExit();

        // Client asks to write some data to some file.
        FileLocation fileLocation = new FileLocation(storeFilename);
        StoreDataRequest storeRequest = new StoreDataRequestImp(fileLocation, List.of("1,1;", "2,2;", "3,3;"));

        // Data Store should successfully store data.
        StoreDataResponse storeResponse = dataStore.store(storeRequest);

        assertTrue(storeResponse.getResponseCode().successful);

        // Check that the store file was correctly written to
        FileReader fr = new FileReader(storeFile);
        String storeStr = fr.readAllAsString();
        fr.close();
        
        assertEquals("1,1;2,2;3,3;", storeStr);

    }

}
