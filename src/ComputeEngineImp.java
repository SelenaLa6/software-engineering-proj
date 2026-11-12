import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import project.server.computation.ComputationApi;
import project.server.computation.ComputeRequest;
import project.server.computation.ComputeResponse;
import project.server.computation.ComputeResponseCode;

public class ComputeEngineImp implements ComputationApi {
    
    public ComputeResponse compute(ComputeRequest request) {
    
        try {

            FormatBuilder fb = new FormatBuilder()
                .setFieldDelim(request.getFieldDelim())
                .setOpenBlockDelim(request.getOpenBlockDelim())
                .setCloseBlockDelim(request.getCloseBlockDelim())
                .setRecordDelim(request.getRecordDelim());

            Function<Map.Entry<Integer,Integer>,String> formatOutput = fb.build();


            Collection<Integer> input = request.getInputData();

            Collection<String> output = input.stream()
                .map(num -> mapNthDigit.apply(num))
                .map(pair -> formatOutput.apply(pair))
                .collect(Collectors.toList());

                
            return new ComputeResponseImp(
                output, 
                ComputeResponseCode.SUCCESS
            ); 

        } catch (Exception e) {

            return new ComputeResponseImp(
                null,
                ComputeResponseCode.FAILURE
            );

        }

    }

    /*
    Map.Entry is used to keep both input & output together for formatting purposes.
    */
    private Function<Integer, Map.Entry<Integer,Integer>> mapNthDigit = (n) -> {
        
        Integer nthDigit = getNthDigit(n);
        Map.Entry<Integer,Integer> pair = Map.entry(n, nthDigit);
        
        return pair;
    };

    private Integer getNthDigit(Integer n) {
        
        Integer currentNum = 1;
        String numStr = "" + currentNum;

        for (int i = 0; i < n; i++) {
            
            numStr = numStr.substring(1);
            
            if (numStr.isEmpty()) {
                numStr = "" + currentNum++;
            }

        }

        return Integer.parseInt("" + numStr.charAt(0));
    }

    /*
    Builder for the format function, since delimiters will differ between jobs.
    TODO:
    Suspected bug - String.format uses % for placeholders, what happens if % is used in delims?
    */
    public class FormatBuilder {

        private String fieldDelim;
        private String recordDelim;
        private String openBlockDelim;
        private String closeBlockDelim;

        public FormatBuilder setFieldDelim(String c) {
            this.fieldDelim = c;
            return this;
        }

        public FormatBuilder setRecordDelim(String c) {
            this.recordDelim = c;
            return this;
        }

        public FormatBuilder setOpenBlockDelim(String c) {
            this.openBlockDelim = c;
            return this;
        }

        public FormatBuilder setCloseBlockDelim(String c) {
            this.closeBlockDelim = c;
            return this;
        }

        public Function<Map.Entry<Integer,Integer>,String> build() {

            StringBuilder sb = new StringBuilder()
                .append(emptyIfNull(openBlockDelim))
                .append("%d")
                .append(emptyIfNull(fieldDelim))
                .append("%d")
                .append(emptyIfNull(closeBlockDelim))
                .append(emptyIfNull(recordDelim));

            return (pair) -> {
                String format = new String(sb);
                return String.format(
                    format,
                    pair.getKey(),
                    pair.getValue()
                );
            };

        }

        private String emptyIfNull(String c) {
            return c != null ? c : "";
        }

    }

}
