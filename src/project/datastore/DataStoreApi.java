package project.datastore;

import project.annotations.ProcessAPI;

@ProcessAPI 
public interface DataStoreApi {

    LoadDataResponse load(LoadDataRequest loadRequest);
    StoreDataResponse store(StoreDataRequest storeRequest);
    
}
