package project.server.computation;

public interface ComputeResponse {
    
    ComputeResponseCode getResponseCode();
    ComputeOutput getOutput();

}
