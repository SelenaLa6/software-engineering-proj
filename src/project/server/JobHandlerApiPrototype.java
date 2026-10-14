package project.server;

import project.annotations.NetworkAPIPrototype;

public class JobHandlerApiPrototype {

    @NetworkAPIPrototype
    public void prototype(JobHandlerApi jobHandler) {

        // Client submits some job to compute.
        SubmitJobRequest request = new SubmitJobRequest() {
            @Override
            public Character[] getDelimiters() {
                // TODO Auto-generated method stub
                return null;
            }
            @Override
            public OutputDataLocation getDestination() {
                // TODO Auto-generated method stub
                return null;
            }
            @Override
            public InputDataLocation getSource() {
                // TODO Auto-generated method stub
                return null;
            }
        };
        SubmitJobResponse response = jobHandler.runJob(request);

        // Client is told whether job was successful or not.
        System.out.println("Result: " + response.getResponseCode());

    }

}