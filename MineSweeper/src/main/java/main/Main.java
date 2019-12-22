package main;

import engine.GameController;

/**
 * Main class validates command-line parameters, if any, and then hands the reins to GameController
 */
public class Main {
    /**
     * staring point of the program
     * @param args Array of String, to be converted to Ints: width, height, number of Mines
     */
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
    
    /**
     * Validates and transforms (String to Int) command-line parameters
     * @param parameter parameter as String
     * @return parameter as Int if valid, returns 0 if not valid
     */
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
