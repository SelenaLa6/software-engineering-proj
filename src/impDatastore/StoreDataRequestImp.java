package impDatastore;
import java.util.Collection;

import impServer.FileLocation;
import project.datastore.StoreDataRequest;
import project.server.DataLocation;

public class StoreDataRequestImp implements StoreDataRequest{

    private DataLocation storeLocation;
    private Collection<String> dataToWrite;

    public StoreDataRequestImp(DataLocation storeLocation, Collection<String> dataToWrite) {
        this.storeLocation = storeLocation;
        this.dataToWrite = dataToWrite;
    }

    public StoreDataRequestImp(String pathname, Collection<String> dataToWrite) {
        this(new FileLocation(pathname), dataToWrite);
    }

    @Override
    public DataLocation getStoreLocation() {
        return storeLocation;
    }

    @Override
    public Collection<String> getData() {
        return dataToWrite;
    }
    
}
