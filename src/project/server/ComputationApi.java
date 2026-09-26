package project.server;

import project.annotations.ConceptualAPI;

@ConceptualAPI 
public interface ComputationApi {
    
    ComputeResponse run(ComputeRequest request);

}
