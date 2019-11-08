package Main;

import DataModel.Grid;
import UserInterface.TextUI;

// mvn compile exec:java -Dexec.mainClass=Main.Main

public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid(9, 9, 10);
        TextUI ui = new TextUI(grid);
        ui.run();
    }
    
}
