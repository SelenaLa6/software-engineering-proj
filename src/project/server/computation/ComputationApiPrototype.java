package project.server.computation;

import project.annotations.ConceptualAPIPrototype;

public class ComputationApiPrototype {

    @ConceptualAPIPrototype 
    public void prototype(ComputationApi engine) {

        // Client submits a computation to perform.
        ComputeRequest request = new ComputeRequest() {};
        ComputeResponse response = engine.compute(request);

        // If computation was successful
        if (response.getResponseCode().isSuccessful()) {

            // Client can see result of computation
            ComputeOutput output = response.getOutput();
            System.out.println(output);

        }

    }

}