import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;

import project.datastore.DataStoreApi;
import project.datastore.LoadDataRequest;
import project.datastore.LoadDataResponse;
import project.datastore.LoadResponseCode;
import project.datastore.StoreDataRequest;
import project.datastore.StoreDataResponse;
import project.datastore.StoreResponseCode;
import project.server.DataLocation;

public class DataStoreImp implements DataStoreApi {
    
    public LoadDataResponse load(LoadDataRequest request) {

        try {

            Collection<Integer> loadedData = read(request.getLoadLocation());
            
            return new LoadDataResponseImp(loadedData, LoadResponseCode.SUCCESS);
        
        } catch (Exception e) {

            return new LoadDataResponseImp(null, LoadResponseCode.FAILURE);

        }
        
    }

    public StoreDataResponse store(StoreDataRequest request) {

        try {

            Collection<String> dataToWrite = request.getData();
            Boolean writeSuccessful = write(request.getStoreLocation(), dataToWrite);

            if (writeSuccessful) {
                return new StoreDataResponseImp(StoreResponseCode.SUCCESS);
            } else {
                return new StoreDataResponseImp(StoreResponseCode.FAILURE);
            }

        } catch (Exception e) {

            return new StoreDataResponseImp(StoreResponseCode.FAILURE);

        }
    }

    private Collection<Integer> read(DataLocation dl){
        
        if (dl instanceof FileLocation) {
            
            try {

                FileReader reader = (FileReader) dl.getReader();
                Collection<Integer> data = new ArrayList<>();
                String token = "";

                while (reader.ready()) {
                    Character c = Character.toChars(reader.read())[0];
                    if (Character.isDigit(c)) {
                        token = token + c;
                    } else if (!token.isEmpty()) {
                        Integer num = Integer.parseInt(token);
                        data.add(num);
                        token = "";
                    }
                }

                return data;

            } catch (Exception e) {
                return null;
            }

        } else {
            return null;
        }
    }

    private Boolean write(DataLocation dl, Collection<String> dataToWrite) {
        
        if (dl instanceof FileLocation) {
            
            try {

                FileWriter writer = (FileWriter) dl.getWriter();

                for (String str : dataToWrite) {
                    writer.write(str);
                }

                return true;

            } catch (Exception e) {
                return false;
            }

        } else {
            return false;
        }
    }

}
