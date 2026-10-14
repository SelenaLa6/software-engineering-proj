package project.datastore;

import project.annotations.ProcessAPIPrototype;
import project.server.DataLocation;

public class DataStoreApiPrototype {
    
    @ProcessAPIPrototype 
    public void prototype(DataStoreApi dataStore) {

        // Client tries to load data.
        LoadDataRequest loadRequest = new LoadDataRequest() {
            @Override
            public DataLocation getLoadLocation() {
                // TODO Auto-generated method stub
                return null;
            }
        };
        LoadDataResponse loadResponse = dataStore.load(loadRequest);

        // If the load was successful,
        if (loadResponse.getResponseCode().successful) {

            // Let the client see the retrieved data.
            DataWrapper dataLoaded = loadResponse.getData();

        }

        // Client tries to store some data.
        StoreDataRequest storeRequest = new StoreDataRequest() {
            @Override
            public DataLocation getStoreLocation() {
                // TODO Auto-generated method stub
                return null;
            }
        };
        StoreDataResponse storeResponse = dataStore.store(storeRequest);

        // Let the client know if the store was successful or not.
        System.out.println("Store result: " + storeResponse.getResponseCode());

    }

}