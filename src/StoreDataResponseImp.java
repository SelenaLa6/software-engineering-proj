import project.datastore.StoreDataResponse;
import project.datastore.StoreResponseCode;

public class StoreDataResponseImp implements StoreDataResponse {

    private StoreResponseCode responseCode;

    public StoreDataResponseImp(StoreResponseCode responseCode) {
        this.responseCode = responseCode;
    }

    @Override
    public StoreResponseCode getResponseCode() {
        return responseCode;
    }
    
}
