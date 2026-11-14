package impServer;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

import project.server.DataLocation;

public class FileLocation implements DataLocation {
    
    private File wrappedFile;

    public FileLocation(String pathname) {
        this.wrappedFile = new File(pathname);
    }

    // TODO: add proper exception handling
    @Override
    public Reader getReader(){
        try {
            return new FileReader(wrappedFile);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Writer getWriter() {
        try {
            return new FileWriter(wrappedFile);
        } catch (Exception e) {
            return null;
        }
    }

}
