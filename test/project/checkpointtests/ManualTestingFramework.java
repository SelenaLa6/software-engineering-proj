package project.checkpointtests;

import java.io.File;
import java.util.List;

import impDatastore.DataStoreImp;
import impServer.ComputeEngineImp;
import impServer.FileLocation;
import impServer.JobHandlerImp;
import impServer.SubmitJobRequestImp;
import project.datastore.DataStoreApi;
import project.server.JobHandlerApi;
import project.server.SubmitJobRequest;
import project.server.computation.ComputationApi;

public class ManualTestingFramework {
    
    public static final String INPUT = "manualTestInput.txt";
    public static final String OUTPUT = "manualTestOutput.txt";

    public static void main(String[] args) {
        
        DataStoreApi dataStore = new DataStoreImp();
        ComputationApi computeEngine = new ComputeEngineImp();
        JobHandlerApi jobHandler = new JobHandlerImp(dataStore, computeEngine);

        new File(INPUT).deleteOnExit();
        new File(OUTPUT).deleteOnExit();

        SubmitJobRequest req = new SubmitJobRequestImp(
            new FileLocation(INPUT),
            new FileLocation(OUTPUT),
            List.of(" ", ",")
        );

        jobHandler.runJob(req);

    }
}
