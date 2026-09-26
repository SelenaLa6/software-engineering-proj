package project.server;

import project.annotations.NetworkAPIPrototype;

public class ServerApiPrototype {

    @NetworkAPIPrototype
    public void prototype(ServerApi server) {

        // Client submits request, it gets processed.
        SubmitJobResponse submitJobResponse = server.acceptJob(new SubmitJobRequest() {});

        // Is submitted job valid? (parameters are "good")
        if (submitJobResponse.isValid()) {

            // configure job
            // use custom delimiters if provided
            if (submitJobResponse.hasCustomDelimiters()) {
                server.configureJob(
                    submitJobResponse.getSource(),
                    submitJobResponse.getDestination(),
                    submitJobResponse.getDelimiters()
                );
            } else { // otherwise, use default delimiters
                server.configureJob(
                    submitJobResponse.getSource(),
                    submitJobResponse.getDestination(),
                    new char[] {':', '\n'}
                );
            }

            // attempt to run job
            JobResult result = server.runJob();

        }

    }

}