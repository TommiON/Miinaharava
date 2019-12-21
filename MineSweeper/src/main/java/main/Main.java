package main;

import engine.GameController;

public class Main {
    public static void main(String[] args) {
        int width, height, numberOfMines;
        
        if (args.length > 2 && validatedParameter(args[0]) != 00 && validatedParameter(args[1]) != 0 && validatedParameter(args[2]) != 0) {
            width = Math.min(validatedParameter(args[0]), 20);
            height = Math.min(validatedParameter(args[1]), 20);
            numberOfMines = Math.min(validatedParameter(args[2]), (width * height));
            System.out.println("Alustetaan pelilaudalla " + width + " x " + height + ", miinoja: " + numberOfMines);
        } else {
            width = 9;
            height = 9;
            numberOfMines = 10;
            System.out.println("Ei parametreja tai parametrit virheellisiä, alustetaan oletusasetuksilla: pelilauta 9 x 9, miinoja 10");
        }
        
        GameController controller = new GameController(width, height, numberOfMines);
        controller.run();
    }
    
    public static int validatedParameter(String parameter) {
        try {
            int p = Integer.parseInt(parameter);
            if (p < 1) {
                return 1;
            }
            return p;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
