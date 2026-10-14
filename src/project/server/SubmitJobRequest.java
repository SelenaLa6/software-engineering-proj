package project.server;

public interface SubmitJobRequest {

    public DataLocation getSource();
    public DataLocation getDestination();
    public Character[] getDelimiters();

}
