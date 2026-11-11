import project.server.DataLocation;
import project.server.SubmitJobRequest;
import java.util.List;

public class SubmitJobRequestImp implements SubmitJobRequest{
    
    private DataLocation source;
    private DataLocation destination;
    private List<String> delimiters;

    // general constructor
    public SubmitJobRequestImp(DataLocation source, DataLocation destination, List<String> delimiters) {
        this.source = source;
        this.destination = destination;
        this.delimiters = delimiters;
    }

    // constructor with default delimiters (if delimiters not provided)
    public SubmitJobRequestImp(DataLocation source, DataLocation destination) {
        this(source, destination, List.of(",", ";"));
    }

    @Override
    public DataLocation getSource() {
        return source;
    }

    @Override
    public DataLocation getDestination() {
        return destination;
    }

    @Override
    public List<String> getDelimiters() {
        return delimiters;
    }

}
