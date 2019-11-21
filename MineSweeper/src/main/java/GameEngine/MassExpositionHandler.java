package GameEngine;

import DataModel.Grid;
import DataModel.Tile;
import java.util.ArrayDeque;

public class MassExpositionHandler {
   
    public static void expose(Grid grid, int x, int y) {
        
        grid.getTile(x,y).exposeMayExplode();
        grid.tilesYetHidden--;
       
        // check surroundings of the tile using width-first graph search
        
        ArrayDeque<Tile> queue = new ArrayDeque<>();
        queue.add(grid.getTile(x, y));
        
        while(!queue.isEmpty()) {
            Tile nextTile = queue.poll();
            int X = nextTile.x;
            int Y = nextTile.y;
            for(int a = X-1; a <= X+1; a++) {
                for(int b = Y-1; b <= Y+1; b++) {                    
                    if(!grid.getTile(a,b).isExposed() && !grid.getTile(a,b).containsMine()) {
                        grid.getTile(a,b).exposeMayExplode();
                        grid.tilesYetHidden--;
                        if(grid.getTile(a,b).getNeighborsContainingMine() == 0) {
                            queue.add(grid.getTile(a,b));
                        }
                    }
                }
            }
        }
    }
}
