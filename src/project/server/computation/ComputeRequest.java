package project.server.computation;
import java.util.List;

public interface ComputeRequest {
    
    InputData getInputData();
    List<Character> getDelimiters();

}
