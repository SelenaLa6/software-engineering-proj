package project.server;

public enum JobResponseCode {
    
    SUCCESS(true),
    FAILURE(false);

    private final boolean successful;

    private JobResponseCode(boolean successful) {
        this.successful = successful;
    }

}
