package project.server.computation;

public enum ComputeResponseCode {
    
    SUCCESS(true),
    FAILURE(false);

    public final boolean successful;

    private ComputeResponseCode(boolean successful) {
        this.successful = successful;
    }

}
