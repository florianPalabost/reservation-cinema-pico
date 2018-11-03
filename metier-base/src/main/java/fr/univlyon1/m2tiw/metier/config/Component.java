package fr.univlyon1.m2tiw.metier.config;

public class Component {
    private String className;
    private String path;

    public Component(String className, String path) {
        this.className = className;
        this.path = path;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
}
