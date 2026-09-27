package project.server;

public interface SubmitJobResponse {

    boolean hasCustomDelimiters();

    DataSource getSource();
    DataDestination getDestination();
    Character[] getDelimiters();

    boolean isValid();

}
