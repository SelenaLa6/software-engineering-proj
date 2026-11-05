package project.datastore;

import project.server.OutputDataLocation;
import java.util.Collection;
public interface StoreDataRequest {
    
    OutputDataLocation getStoreLocation();
    Collection<String> getData();

}
