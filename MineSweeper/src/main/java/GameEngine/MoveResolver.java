package GameEngine;

import DataModel.Grid;
import DataModel.Tile;

public class MoveResolver {
    public static int resolve(Grid grid, Move move) {
        // return values
        // 0 = game continues
        // 1 = game won
        // 2 = game lost
        
        Tile focusTile = grid.getTile(move.getX(), move.getY());
        if(focusTile.isExposed()) { return 0; }
        
        if(focusTile.containsMine()) {
            focusTile.exposeMayExplode();
            grid.tilesYetHidden--;
            return 2;
        }
        
        if(!focusTile.containsMine() && focusTile.getNeighborsContainingMine() != 0) {
            focusTile.exposeMayExplode();
            grid.tilesYetHidden--;
        }
        
        if(focusTile.getNeighborsContainingMine() == 0) {
            MassExpositionHandler.expose(grid, move.getX(), move.getY());
        }
        
        if(grid.tilesYetHidden == grid.numberOfMines) {
            return 1;
        }
              
        return 0;
    }
}
