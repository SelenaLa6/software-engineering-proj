package project.datastore;

import project.annotations.ProcessAPIPrototype;

public class DataStoreApiPrototype {
    
    @ProcessAPIPrototype 
    public void prototype(DataStoreApi dataStore) {

        // load data
        LoadDataRequest loadDataRequest = new LoadDataRequest() {};
        LoadDataResponse loadDataResponse = dataStore.loadData(loadDataRequest);

        // store data
        StoreDataRequest storeDataRequest = new StoreDataRequest() {};
        StoreDataResponse storeDataResponse = dataStore.storeData(storeDataRequest);

    }

}
