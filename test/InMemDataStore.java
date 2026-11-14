import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import project.datastore.DataStoreApi;
import project.datastore.LoadDataRequest;
import project.datastore.LoadDataResponse;
import project.datastore.LoadResponseCode;
import project.datastore.StoreDataRequest;
import project.datastore.StoreDataResponse;
import project.datastore.StoreResponseCode;

class InMemDataStore implements DataStoreApi {

    @Override
    public LoadDataResponse load(LoadDataRequest loadRequest) {
        InMemInputConfig inputLocation = (InMemInputConfig)loadRequest.getLoadLocation();

        LoadDataResponse response = new LoadDataResponse() {
            public List<Integer> loadedData = deepCopyInput(inputLocation.inputList);
            
            @Override
            public LoadResponseCode getResponseCode() {
                if (inputLocation != null && inputLocation.inputList != null) {
                    return LoadResponseCode.SUCCESS;
                } else {
                    return LoadResponseCode.FAILURE;
                }
            }

            @Override
            public Collection<Integer> getData() {
                return loadedData;
            }
        };
        return response;
    }
    
    @Override
    public StoreDataResponse store(StoreDataRequest storeRequest) {
        InMemOutputConfig outputLocation = (InMemOutputConfig)storeRequest.getStoreLocation();
        Collection<String> dataToStore = storeRequest.getData();

        if (outputLocation.outputList != null) {
            for(String data : dataToStore) {
                outputLocation.outputList.add(data);
            }
        }

        StoreDataResponse response = new StoreDataResponse() {
            @Override
            public StoreResponseCode getResponseCode() {
                return StoreResponseCode.SUCCESS;
            }
        };
        return response;
    }

    private List<Integer> deepCopyInput(List<Integer> originalList) {
        List<Integer> newList = new ArrayList<>();
        for (Integer item : originalList) {
            newList.add(item);
        }
        return newList;
    }

}    
