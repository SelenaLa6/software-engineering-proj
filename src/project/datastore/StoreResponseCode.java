package project.datastore;

public enum StoreResponseCode {
    
    SUCCESS(true),
    FAILURE(false);

    public final boolean successful;

    private StoreResponseCode(boolean successful) {
        this.successful = successful;
    }

}
