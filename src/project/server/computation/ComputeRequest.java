package project.server.computation;
import java.util.Collection;

public interface ComputeRequest {
    
    Collection<Integer> getInputData();
    String getFieldDelim();
    String getRecordDelim();
    String getFirstBlockDelim();
    String getSecondBlockDelim();

}
