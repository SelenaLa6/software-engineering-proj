import java.util.List;

import project.datastore.DataStoreApi;
import project.datastore.LoadDataRequest;
import project.datastore.LoadDataResponse;
import project.datastore.LoadDataWrapper;
import project.datastore.LoadResponseCode;
import project.datastore.StoreDataRequest;
import project.datastore.StoreDataResponse;
import project.datastore.StoreDataWrapper;
import project.datastore.StoreResponseCode;
import project.server.InputDataLocation;
import project.server.OutputDataLocation;
    
class TestInputConfig implements InputDataLocation {
     public List<Integer> inputList;
}

class TestOutputConfig implements OutputDataLocation {
    public List<String> outputList;
}

class TestOutputData implements StoreDataWrapper {
    public List<String> outputData;
}

class TestDataStore implements DataStoreApi {
    @Override
    public LoadDataResponse load(LoadDataRequest loadRequest) {
        TestInputConfig inputLocation = (TestInputConfig)loadRequest.getLoadLocation();
        LoadDataResponse response = new LoadDataResponse() {
            public List<Integer> loadedData = inputLocation.inputList;
            @Override
            public LoadResponseCode getResponseCode() {
                if (loadedData != null)
                    return LoadResponseCode.SUCCESS;
                else
                    return LoadResponseCode.FAILURE;
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
        TestOutputConfig outputLocation = (TestOutputConfig)storeRequest.getStoreLocation();
        TestOutputData dataToStore = (TestOutputData)storeRequest.getData();

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
}    
