package project.server;

import project.annotations.NetworkAPIPrototype;

public class JobHandlerApiPrototype {

    @NetworkAPIPrototype
    public void prototype(JobHandlerApi jobHandler) {

        SubmitJobRequest request = new SubmitJobRequest() {};
        SubmitJobResponse response = jobHandler.configureJob(request);

    }

}