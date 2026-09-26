package project.server;

import project.annotations.NetworkAPI;

@NetworkAPI
public interface ServerApi {

    JobResponse acceptRequest(JobRequest request);

}