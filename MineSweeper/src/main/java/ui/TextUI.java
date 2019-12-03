package ui;

import model.Grid;
import engine.Move;
import java.util.Scanner;

public class TextUI {
    static Scanner scanner = new Scanner(System.in);
     
    public static void welcome() {
        System.out.println("MIINAHARAVA");
        // System.out.println("Teksipohjainen versio on debug-moodissa eli näyttää joka kierroksella myös paljastetun pelikentän.");
        System.out.println("(M = miinoitettu ruutu, numero = miinoitettujen naapureiden määrä)");
        System.out.println("");
    }
    
    public static void printGrid(Grid grid, boolean allExposed) {
        System.out.println(grid.toString(allExposed));
    }
    
    public static Move getNextMove(Grid grid) {
        // no input validation, because the text UI is just a temporary hack, will be made into a GUI
        
        System.out.println("Seuraava siirto...");
        System.out.println("Anna x-koordinaatti 1..." + grid.tiles.length + " : ");
        int x = scanner.nextInt() - 1;
        
        System.out.println("Anna y-koordinaatti 1..." + grid.tiles[0].length + " : ");
        int y = scanner.nextInt() - 1;
        
        boolean placeFlag;
        String flagInput = scanner.nextLine();
        System.out.println("Pelkkä ENTER = ei lippua. Mitä tahansa tekstiä ja ENTER = lippu äskeiseen ruutuun");
        flagInput = scanner.nextLine();
        if (flagInput.isEmpty()) {
            placeFlag = false;
        } else {
            placeFlag = true;
        }
        
        return new Move(x, y, placeFlag);
    }
    
    public static void gameLost() {
        System.out.println("BOOM! Kuolit!");
    }
    
    public static void gameWon() {
        System.out.println("Kaikki miinoittamattomat ruudut paljastettu. VOITIT!");
    }
    
}
