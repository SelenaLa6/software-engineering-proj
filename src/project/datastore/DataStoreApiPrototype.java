package project.datastore;

import project.annotations.ProcessAPIPrototype;

public class DataStoreApiPrototype {
    
    @ProcessAPIPrototype 
    public void prototype(DataStoreApi dataStore) {

        // Client tries to load data.
        LoadDataRequest loadRequest = new LoadDataRequest() {};
        LoadDataResponse loadResponse = dataStore.load(loadRequest);

        // If the load was successful,
        if (loadResponse.getResponseCode().isSuccessful()) {

            // Let the client see the retrieved data.
            DataWrapper dataLoaded = loadResponse.getData();

        }

        // Client tries to store some data.
        StoreDataRequest storeRequest = new StoreDataRequest() {};
        StoreDataResponse storeResponse = dataStore.store(storeRequest);

        // Let the client know if the store was successful or not.
        System.out.println("Store result: " + storeResponse.getResponseCode());

    }

}