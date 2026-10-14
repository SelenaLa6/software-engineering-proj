package project.datastore;

import project.server.OutputDataLocation;

public interface StoreDataRequest {
    
    OutputDataLocation getStoreLocation();
    StoreDataWrapper getData();

}
