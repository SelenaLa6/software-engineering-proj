package impserver.impcompute;
import java.util.Collection;

import project.server.computation.ComputeRequest;

public class ComputeRequestImp implements ComputeRequest{

    private Collection<Integer> inputData;
    private String fieldDelim;
    private String recordDelim;
    private String openBlockDelim;
    private String closeBlockDelim;

    public ComputeRequestImp(
        Collection<Integer> inputData,
        String fieldDelim,
        String recordDelim,
        String openBlockDelim,
        String closeBlockDelim
    ) {

        this.inputData = inputData;
        this.fieldDelim = fieldDelim;
        this.recordDelim = recordDelim;
        this.openBlockDelim = openBlockDelim;
        this.closeBlockDelim = closeBlockDelim;      

    }

    @Override
    public Collection<Integer> getInputData() {
        return inputData;
    }

    @Override
    public String getFieldDelim() {
        return fieldDelim;
    }

    @Override
    public String getRecordDelim() {
        return recordDelim;
    }

    @Override
    public String getOpenBlockDelim() {
        return openBlockDelim;
    }

    @Override
    public String getCloseBlockDelim() {
        return closeBlockDelim;
    }
    
}
