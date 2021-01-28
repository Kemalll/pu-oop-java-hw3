package Frogs;

import Swamp.GameTile;
import java.awt.*;
import java.util.Random;

public class Turtles extends Units {

    public Turtles(Color color) {
        Random rand=new Random();

        int r=rand.nextInt(5);
        while(r==2){
            r=rand.nextInt(5);
        }
        this.col= r;
        this.row = 2;
        this.color = color;
//        System.out.println(col+"=this is col");
    }
    public void render(Graphics g) {
        int x = this.col * GameTile.TILE_SIZE;
        int y = this.row * GameTile.TILE_SIZE;

        g.setColor(this.color);
        g.fillOval(x+27, y+27 , 45,45);
        g.setColor(Color.RED);
        g.drawOval(x+27, y+27,45,45);

}

    @Override
    public boolean isMoveValid(int moveRow, int moveCol) {
        return false;
    }
}
