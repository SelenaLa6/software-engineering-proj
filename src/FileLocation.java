import java.io.File;

import project.server.DataLocation;

public class FileLocation implements DataLocation {
    
    private File wrappedFile;

    public FileLocation(String pathname) {
        this.wrappedFile = new File(pathname);
    }

    public File getFile() {
        return wrappedFile;
    }

}
