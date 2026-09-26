package project.server;

import project.annotations.ConceptualAPIPrototype;

public class ComputationApiPrototype {

    @ConceptualAPIPrototype 
    public void prototype(ComputationApi engine) {

        // get input to process
        ComputeRequest computeRequest = new ComputeRequest() {};

        // run the computation
        ComputeResponse computeResponse = engine.run(computeRequest);

    }

}
