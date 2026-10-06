package project.datastore;

public interface LoadDataResponse {

    LoadResponseCode getResponseCode();
    DataWrapper getData();

}
