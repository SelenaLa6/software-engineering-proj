package project.server;

public interface SubmitJobRequest {

    public InputDataLocation getSource();
    public OutputDataLocation getDestination();
    public Character[] getDelimiters();

}
