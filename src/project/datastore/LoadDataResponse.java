package project.datastore;

public interface LoadDataResponse {

    LoadResponseCode getResponseCode();
    LoadDataWrapper getData();

}
