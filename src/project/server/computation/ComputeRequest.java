package project.server.computation;

public interface ComputeRequest {
    
    InputData getInputData();
    String getFieldDelim();
    String getRecordDelim();
    String getFirstBlockDelim();
    String getSecondBlockDelim();

}
