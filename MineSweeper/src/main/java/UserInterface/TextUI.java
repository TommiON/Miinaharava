package UserInterface;

import DataModel.Grid;

public class TextUI {
    static Grid grid;
    
    public TextUI(Grid grid) {
        this.grid = grid;
    }
    
    public static void run() {
        System.out.println("MIINAHARAVA");
        System.out.println("Ei voi vielä pelata, mutta osaa jo generoida pelilaudan.");
        System.out.println("(M = miinoitettu ruutu, numero = miinoitettujen naapureiden määrä)");
        System.out.println("");
        System.out.println(grid.toString());
    }
    
}
