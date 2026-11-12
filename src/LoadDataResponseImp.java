import java.util.Collection;

import project.datastore.LoadDataResponse;
import project.datastore.LoadResponseCode;

public class LoadDataResponseImp implements LoadDataResponse {

    private Collection<Integer> data;
    private LoadResponseCode responseCode;

    public LoadDataResponseImp(Collection<Integer> data, LoadResponseCode responseCode) {
        this.data = data;
        this.responseCode = responseCode;
    }

    @Override
    public LoadResponseCode getResponseCode() {
        return responseCode;
    }

    @Override
    public Collection<Integer> getData() {
        return data;
    }
    


}
