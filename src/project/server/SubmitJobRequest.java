package project.server;
import java.util.List;

public interface SubmitJobRequest {

    public InputDataLocation getSource();
    public OutputDataLocation getDestination();
    public List<String> getDelimiters();

}
