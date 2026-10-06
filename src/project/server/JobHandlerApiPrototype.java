package project.server;

import project.annotations.NetworkAPIPrototype;

public class JobHandlerApiPrototype {

    @NetworkAPIPrototype
    public void prototype(JobHandlerApi jobHandler) {

        // Client submits some job to compute.
        SubmitJobRequest request = new SubmitJobRequest() {};
        SubmitJobResponse response = jobHandler.configureJob(request);

        // Client is told whether job was successful or not.
        System.out.println("Result: " + response.getResponseCode());

    }

}