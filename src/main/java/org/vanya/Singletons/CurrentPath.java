package org.vanya.Singletons;

/**
 * Created by vanya on 01.03.15.
 */
public class CurrentPath {

    private String currentPath = "/";

    private static CurrentPath ourInstance = new CurrentPath();

    public static CurrentPath getInstance() {
        return ourInstance;
    }

    private CurrentPath() {
    }

    public String getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(String currentPath) {
        //TODO: something wrong but working, remake latter
        this.currentPath = currentPath;
        currentPath = currentPath.replaceAll("//", "/");
        System.out.println("Current path is " + currentPath);
    }
}
