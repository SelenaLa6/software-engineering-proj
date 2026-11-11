package project.server;
import java.util.List;

public interface SubmitJobRequest {

    public DataLocation getSource();
    public DataLocation getDestination();
    public List<String> getDelimiters();

}
