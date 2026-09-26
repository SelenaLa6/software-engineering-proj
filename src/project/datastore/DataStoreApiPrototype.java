package project.datastore;

import project.annotations.ProcessAPIPrototype;

public class DataStoreApiPrototype {
    
    @ProcessAPIPrototype 
    public void prototype(DataStoreApi dataStore) {

        // Client tries to load some data.
        LoadDataResponse loadDataResponse = dataStore.load(new LoadDataRequest() {});

        // Was the load successful?
        if (loadDataResponse.isSuccessful()) {

            // Retrieve the requested data.
            Integer[] dataLoaded = loadDataResponse.getData();

        }

        // Client tries to store some data.
        StoreDataResponse storeDataResponse = dataStore.store(new StoreDataRequest() {});

    }

}
