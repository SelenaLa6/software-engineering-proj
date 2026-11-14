package impServer;
import java.util.Collection;

import project.server.computation.ComputeResponse;
import project.server.computation.ComputeResponseCode;

public class ComputeResponseImp implements ComputeResponse {

    private Collection<String> output;
    private ComputeResponseCode responseCode;

    public ComputeResponseImp(Collection<String> output, ComputeResponseCode responseCode) {
        this.output = output;
        this.responseCode = responseCode;
    }

    @Override
    public ComputeResponseCode getResponseCode() {
        return responseCode;
    }

    @Override
    public Collection<String> getOutput() {
        return output;
    }
    
}
