package project.server;

import project.annotations.NetworkAPIPrototype;

public class ServerApiPrototype {

    @NetworkAPIPrototype
    public void prototype(ServerApi server) {

        // accept some user request
        JobRequest request = new JobRequest() {};
        JobResponse response = server.acceptRequest(request);

    }

}