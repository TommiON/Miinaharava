package main;

import engine.GameController;

public class Main {
    public static void main(String[] args) {
        System.out.println("MIINAHARAVA");
        
        int width, height, numberOfMines;
        
        if(args.length > 0) {
            // tsekkaa myös parametrien tyypit
            width = Integer.parseInt(args[0]);
            height = Integer.parseInt(args[1]);
            numberOfMines = Integer.parseInt(args[2]);
            System.out.println("Alustetaan " + width + " x " + height + " pelilaudalla ja " + numberOfMines  + " miinalla.");
        } else {
            width = 9;
            height = 9;
            numberOfMines = 10;
            System.out.println("Parametreja ei annettu tai ne ovat virheellisiä, käynnistetään oletusarvoilla: 9 x 9 ruutua, 10 miinaa.");
        }
        
        GameController controller = new GameController(width, height, numberOfMines);
        controller.run();
    }
}
