package project.server.computation;

import project.annotations.ConceptualAPIPrototype;

public class ComputationApiPrototype {

    @ConceptualAPIPrototype 
    public void prototype(ComputationApi engine) {

        // Client runs computation.
        ComputeResponse computeResponse = engine.compute(new ComputeRequest() {});

    }

}