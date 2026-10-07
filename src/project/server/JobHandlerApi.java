package project.server;

import project.annotations.NetworkAPI;

@NetworkAPI
public interface JobHandlerApi {

    SubmitJobResponse configureJob(SubmitJobRequest request);

}