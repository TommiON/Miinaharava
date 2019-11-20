package GameEngine;

import DataModel.Grid;
import DataModel.Tile;

public class MoveResolver {
    public static int resolve(Grid grid, Move move) {
        // to be completed, now just exposes tiles and terminates if a mine
        // return values
        // 0 = game continues
        // 1 = game won
        // 2 = game lost
        
        Tile focusTile = grid.getTile(move.getX(), move.getY());
        focusTile.exposeMayExplode();
        
        if(focusTile.containsMine()) {
            return 2;
        }
        
        // tsekkaa säännöt, miten se paljastuminen menikään...?
        
        return 0;
    }
}
