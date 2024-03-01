
package model;

public class Path {
    private String pathFile;

    public Path() {
    }

    public Path(String pathFile) {
        this.pathFile = pathFile;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    @Override
    public String toString() {
        return "pathFile=" + pathFile;
    }
}
