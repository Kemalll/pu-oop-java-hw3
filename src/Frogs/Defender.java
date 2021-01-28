package Frogs;

import Swamp.GameTile;
import java.awt.*;


public class Defender extends Units {

    public Defender(int row, int col,Color color) {
        this.row = row;
        this.col = col;
        this.color=color;
    }
    public boolean isMoveValid(int moveRow, int moveCol) {
        int rowCoeficient = Math.abs(moveRow - this.row);                    //Движение на фигорите
        int colCoeficient = moveCol - this.col;
        return  rowCoeficient == 1 &&
                colCoeficient == 0;
    }
}


