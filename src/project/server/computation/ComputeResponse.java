package project.server.computation;

public interface ComputeResponse {
    
    ResponseCode getResponseCode();
    ComputeOutput getOutput();

}
