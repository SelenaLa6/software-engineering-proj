import project.datastore.LoadDataRequest;
import project.server.DataLocation;

public class LoadDataRequestImp implements LoadDataRequest {

    private FileLocation fileLocation;

    public LoadDataRequestImp(FileLocation fileLocation) {
        this.fileLocation = fileLocation;
    }

    public LoadDataRequestImp(String pathname) {
        this(new FileLocation(pathname));
    }

    @Override
    public DataLocation getLoadLocation() {
        return fileLocation;
    }
    
}
