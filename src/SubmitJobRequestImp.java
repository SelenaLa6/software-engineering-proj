import project.server.InputDataLocation;
import project.server.OutputDataLocation;
import project.server.SubmitJobRequest;

public class SubmitJobRequestImp implements SubmitJobRequest{
    
    private InputDataLocation source;
    private OutputDataLocation destination;
    private Character[] delimiters;

    // general constructor
    public SubmitJobRequestImp(InputDataLocation source, OutputDataLocation destination, Character[] delimiters) {
        this.source = source;
        this.destination = destination;
        this.delimiters = delimiters;
    }

    // constructor with default delimiters (if delimiters not provided)
    public SubmitJobRequestImp(InputDataLocation source, OutputDataLocation destination) {
        this(source, destination, new Character[] {',',';'});
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
    public Character[] getDelimiters() {
        return delimiters;
    }

}
