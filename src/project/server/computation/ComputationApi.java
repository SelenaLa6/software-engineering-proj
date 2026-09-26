package project.server.computation;

import project.annotations.ConceptualAPI;

@ConceptualAPI 
public interface ComputationApi {
    
    ComputeResponse run(ComputeRequest request);

}
