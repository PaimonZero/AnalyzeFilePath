
package controller;

import java.util.Arrays;
import model.Path;
import model.PathHash;
import view.ConsoleUI;

public class Application {
    private final ConsoleUI cui;

    public Application(ConsoleUI cui) {
        this.cui = cui;
    }
    
    private PathHash ph = new PathHash();
    
    public void run() {
        while (true) {
            //step 1: Display GUI and users input Data
            int choice = cui.showMenuList();

            switch (choice) {
                //step 2: perform function based on the selected option
                case 1:
                    this.getPathFromUser();
                    break;
                case 2:
                    // exit the program
                    System.exit(0);
            }

        }
    }
    
    public void getPathFromUser() {
        System.out.println("====================================");
        Path path = ph.createPath("Please input Path: ");
        if(ph.checkPath(path) == false) {
            System.out.println("Error Path!");
        } else {
            System.out.println("---------- Result Analysis ----------");
            System.out.println("Disk: " + ph.findDisk(path));
            System.out.println("Extension: " + ph.findExtension(path));
            System.out.println("File Name: " + ph.findFileName(path));
            System.out.println("Path: " + ph.findPath(path));
            System.out.println("Folders: " + Arrays.toString(ph.findFolders(path)));
        }
    }
}
