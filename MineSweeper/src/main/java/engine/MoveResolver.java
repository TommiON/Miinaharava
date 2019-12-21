package engine;

import model.Grid;
import model.Tile; 

/**
 * Static helper class with a single method, resolves what happens when player chooses a move
 */
public class MoveResolver {

    /**
     * @param grid current grid against which move will be resolved
     * @param move move to be resolved
     * @return 0: game continues, 1: game won, 2: game lost 
     */
    public static int resolve(Grid grid, Move move) {
        Tile focusTile = grid.getTile(move.getX(), move.getY());
        
        if (focusTile.isExposed()) {
            return 0;
        }
        
        if (move.isFlagging()) {
            focusTile.placeOrRemoveFlag();
            return 0;
        }
        
        if (focusTile.containsMine()) {
            focusTile.exposeMayExplode();
            grid.tilesYetHidden--;
            return 2;
        }
        
        if (!focusTile.containsMine() && focusTile.getNeighborsContainingMine() != 0) {
            focusTile.exposeMayExplode();
            grid.tilesYetHidden--;
        }
        
        if (focusTile.getNeighborsContainingMine() == 0) {
            grid.getTile(move.getX(), move.getY()).exposeMayExplode();
            grid.tilesYetHidden--;       
            ExpositionHandler.expose(grid, move.getX(), move.getY());
        }
        
        if (grid.tilesYetHidden == grid.numberOfMines) {
            return 1;
        }
              
        return 0;
    }
}
