import project.server.InputDataLocation;
import project.server.OutputDataLocation;
import project.server.SubmitJobRequest;
import java.util.List;

public class SubmitJobRequestImp implements SubmitJobRequest{
    
    private InputDataLocation source;
    private OutputDataLocation destination;
    private List<String> delimiters;

    // general constructor
    public SubmitJobRequestImp(InputDataLocation source, OutputDataLocation destination, List<String> delimiters) {
        this.source = source;
        this.destination = destination;
        this.delimiters = delimiters;
    }

    // constructor with default delimiters (if delimiters not provided)
    public SubmitJobRequestImp(InputDataLocation source, OutputDataLocation destination) {
        this(source, destination, List.of(",", ";"));
    }

    @Override
    public InputDataLocation getSource() {
        return source;
    }

    @Override
    public OutputDataLocation getDestination() {
        return destination;
    }

    @Override
    public List<String> getDelimiters() {
        return delimiters;
    }

}
