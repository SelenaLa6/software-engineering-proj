package project.server.computation;

import project.annotations.ConceptualAPI;

@ConceptualAPI 
public interface ComputationApi {
    
    ComputeResponse compute(ComputeRequest request);

}
