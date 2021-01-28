package Frogs;

import Swamp.Battelfield;
import Swamp.GameTile;
import java.awt.*;

public class Leader extends Units {

    public Leader(int row, int col, Color color) {
        this.row = row;
        this.col = col;
        this.color = color;
    }

    public void render(Graphics g) {
        int x = this.col * GameTile.TILE_SIZE;
        int y = this.row * GameTile.TILE_SIZE;

        g.setColor(this.color);
        g.fillRect(x + 25, y + 25, 55, 55);


    }

    @Override
    public boolean isMoveValid(int moveRow, int moveCol) {

//        for (moveRow = row; moveRow < Battelfield.TILE_SIDE_COUNT; moveRow++) {
//        }
//        for (moveCol = col; moveCol < Battelfield.TILE_SIDE_COUNT; moveCol++) {
//        }
//       return true;

        return false;

    }
}