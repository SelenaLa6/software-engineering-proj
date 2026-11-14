import project.server.DataLocation;

import java.io.Reader;
import java.io.Writer;
import java.util.List;

class InMemOutputConfig implements DataLocation {
    public List<String> outputList;

    @Override
    public Reader getReader() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getReader'");
    }

    @Override
    public Writer getWriter() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getWriter'");
    }
}
