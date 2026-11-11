package project.server;

import java.io.Reader;
import java.io.Writer;

public interface DataLocation {
    
    public Reader getReader();
    public Writer getWriter();

}
