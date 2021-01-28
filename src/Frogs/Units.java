package Frogs;

import Swamp.GameTile;

import java.awt.*;

public abstract class Units {
    protected int col;
    protected int row;
    protected Color color;

    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }

    public void render(Graphics g) {
        int x = this.col * GameTile.TILE_SIZE;
        int y = this.row * GameTile.TILE_SIZE;

        g.setColor(this.color);
        g.fillOval(x+27, y+27 , 45,45);
        g.setColor(Color.BLUE);
        g.drawOval(x+27, y+27,45,45);
    }
    public void move(int row,int col){
        this.row=row;
        this.col=col;


    }
    public abstract boolean isMoveValid(int moveRow,int moveCol);



}

