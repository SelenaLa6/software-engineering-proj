package project.datastore;
import java.util.Collection;

public interface LoadDataResponse {

    LoadResponseCode getResponseCode();
    Collection<Integer> getData();

}
