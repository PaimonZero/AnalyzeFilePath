
package analyzefilepath;

import controller.Application;
import view.ConsoleUI;

public class AnalyzeFilePath {

    public static void main(String[] args) {
        ConsoleUI cui = new ConsoleUI();
        Application app = new Application(cui);
        app.run();
    }
    
}
