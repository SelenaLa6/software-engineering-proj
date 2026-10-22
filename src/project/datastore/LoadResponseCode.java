package project.datastore;

public enum LoadResponseCode {
    
    SUCCESS(true),
    FAILURE(false);

    public final boolean successful;

    private LoadResponseCode(boolean successful) {
        this.successful = successful;
    }

}
