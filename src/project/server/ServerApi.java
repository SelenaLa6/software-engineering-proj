package project.server;

import project.annotations.NetworkAPI;

@NetworkAPI
public interface ServerApi {

    SubmitJobResponse acceptJob(SubmitJobRequest request);
    void configureJob(DataSource source, DataDestination destination, Character[] delimiters);
    JobResult runJob();

}