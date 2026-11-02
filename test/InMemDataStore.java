import java.util.List;
import java.util.ArrayList;
import project.datastore.DataStoreApi;
import project.datastore.LoadDataRequest;
import project.datastore.LoadDataResponse;
import project.datastore.LoadDataWrapper;
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
            public LoadDataWrapper getData() {
                LoadDataWrapper wrappedData = new LoadDataWrapper() {
                    public List<Integer> dataList = loadedData;
                };
                return wrappedData;
            }
        };
        return response;
    }
    
    @Override
    public StoreDataResponse store(StoreDataRequest storeRequest) {
        InMemOutputConfig outputLocation = (InMemOutputConfig)storeRequest.getStoreLocation();
        InMemOutputData dataToStore = (InMemOutputData)storeRequest.getData();

        if (outputLocation.outputList != null) {
            for(String data : dataToStore.outputData) {
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
