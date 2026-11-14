package impServer;
import project.server.JobResponseCode;
import project.server.SubmitJobResponse;

public class SubmitJobResponseImp implements SubmitJobResponse{

    private JobResponseCode responseCode;

    public SubmitJobResponseImp(JobResponseCode responseCode) {
        this.responseCode = responseCode;
    }

    @Override
    public JobResponseCode getResponseCode() {
        return responseCode;
    }
    
}
