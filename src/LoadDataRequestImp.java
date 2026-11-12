import project.datastore.LoadDataRequest;
import project.server.DataLocation;

public class LoadDataRequestImp implements LoadDataRequest {

    private DataLocation dataLocation;

    public LoadDataRequestImp(DataLocation dataLocation) {
        this.dataLocation = dataLocation;
    }

    public LoadDataRequestImp(String filename) {
        this(new FileLocation(filename));
    }

    @Override
    public DataLocation getLoadLocation() {
        return dataLocation;
    }
    
}
