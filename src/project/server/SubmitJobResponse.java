package project.server;

public interface SubmitJobResponse {

    boolean hasCustomDelimiters();

    DataSource getSource();
    DataDestination getDestination();
    char[] getDelimiters();

    boolean isValid();

}
