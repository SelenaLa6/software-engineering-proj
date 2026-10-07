package project.server;

public enum JobResponseCode {
    
    SUCCESS(true),
    FAILURE(false);

    public final boolean successful;

    private JobResponseCode(boolean successful) {
        this.successful = successful;
    }

}
