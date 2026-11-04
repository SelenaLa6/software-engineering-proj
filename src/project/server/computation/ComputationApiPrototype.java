package project.server.computation;

import java.util.Collection;

import project.annotations.ConceptualAPIPrototype;

public class ComputationApiPrototype {

    @ConceptualAPIPrototype 
    public void prototype(ComputationApi engine) {

        // Client submits a computation to perform.
        ComputeRequest request = new ComputeRequest() {
            @Override
            public Collection<Integer> getInputData() {
                // TODO Auto-generated method stub
                return null;
            }
            @Override
            public String getFieldDelim() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getFieldDelim'");
            }
            @Override
            public String getRecordDelim() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getRecordDelim'");
            }
            @Override
            public String getFirstBlockDelim() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getFirstBlockDelim'");
            }
            @Override
            public String getSecondBlockDelim() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getSecondBlockDelim'");
            }
        };
        ComputeResponse response = engine.compute(request);

        // If computation was successful
        if (response.getResponseCode().successful) {

            // Client can see result of computation
            Collection<String> output = response.getOutput();
            System.out.println(output);

        }

    }

}