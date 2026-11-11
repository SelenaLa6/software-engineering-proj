package project.datastore;

import project.server.DataLocation;
import java.util.Collection;
public interface StoreDataRequest {
    
    DataLocation getStoreLocation();
    Collection<String> getData();

}
