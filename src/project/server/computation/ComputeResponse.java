package project.server.computation;
import java.util.Collection;
public interface ComputeResponse {
    
    ComputeResponseCode getResponseCode();
    Collection<String> getOutput();

}
