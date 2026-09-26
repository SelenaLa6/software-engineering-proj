package project.datastore;

import project.annotations.ProcessAPI;

@ProcessAPI 
public interface DataStoreApi {

    LoadDataResponse loadData(LoadDataRequest loadRequest);
    StoreDataResponse storeData(StoreDataRequest storeRequest);
    
}
