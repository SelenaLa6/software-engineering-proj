package project.datastore;

import project.annotations.ProcessAPIPrototype;
import project.server.InputDataLocation;
import project.server.OutputDataLocation;
import java.util.Collection;

public class DataStoreApiPrototype {
    
    @ProcessAPIPrototype 
    public void prototype(DataStoreApi dataStore) {

        // Client tries to load data.
        LoadDataRequest loadRequest = new LoadDataRequest() {
            @Override
            public InputDataLocation getLoadLocation() {
                // TODO Auto-generated method stub
                return null;
            }
        };
        LoadDataResponse loadResponse = dataStore.load(loadRequest);

        // If the load was successful,
        if (loadResponse.getResponseCode().successful) {

            // Let the client see the retrieved data.
            Collection<Integer> dataLoaded = loadResponse.getData();

        }

        // Client tries to store some data.
        StoreDataRequest storeRequest = new StoreDataRequest() {
            @Override
            public OutputDataLocation getStoreLocation() {
                // TODO Auto-generated method stub
                return null;
            }
            @Override
            public Collection<String> getData() {
                // TODO Auto-generated method stub
                return null;
            }
        };
        StoreDataResponse storeResponse = dataStore.store(storeRequest);

        // Let the client know if the store was successful or not.
        System.out.println("Store result: " + storeResponse.getResponseCode());

    }

}