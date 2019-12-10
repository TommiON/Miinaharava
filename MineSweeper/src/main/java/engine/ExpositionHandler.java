

package engine;

import model.Grid;
import model.Tile;
import java.util.ArrayDeque;

/**
 * A helper class with a single method to expose areas of multiple zero-tiles
 */
public class ExpositionHandler {
   
    /**
     * check surroundings of the tile using width-first graph search, exposes 
     * continuous areas of zero-tiles
     * @param grid the grid to be worked on, passed on as a dependency-injection
     * @param x starting position, x-coordinate
     * @param y starting position, y-coordinate
     */
    public static void expose(Grid grid, int x, int y) {
        grid.getTile(x, y).exposeMayExplode();
        grid.tilesYetHidden--;
               
        ArrayDeque<Tile> queue = new ArrayDeque<>();
        queue.add(grid.getTile(x, y));
        
        while (!queue.isEmpty()) {
            Tile nextTile = queue.poll();
            int coordX = nextTile.x;
            int coordY = nextTile.y;
            for (int a = coordX - 1; a <= coordX + 1; a++) {
                for (int b = coordY - 1; b <= coordY + 1; b++) {                    
                    if (!grid.getTile(a, b).isExposed() && !grid.getTile(a, b).containsMine()) {
                        grid.getTile(a, b).exposeMayExplode();
                        grid.tilesYetHidden--;
                        if (grid.getTile(a, b).getNeighborsContainingMine() == 0) {
                            queue.add(grid.getTile(a, b));
                        }
                    }
                }
            }
        }
    }
}
