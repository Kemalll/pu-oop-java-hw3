package Swamp;

import Frogs.Defender;
import Frogs.Leader;
import Frogs.Turtles;
import Frogs.Units;
import ui.Modal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Battelfield extends JFrame implements MouseListener {

    private Units[][] pieceCollection;                            ///Tук са обектите от defender and leader.
    private Units selectedPiece;                                  ///Следи дали елементат е избран
    public static final int TILE_SIDE_COUNT = 5;

    public Battelfield() {

        this.pieceCollection = new Units[TILE_SIDE_COUNT][TILE_SIDE_COUNT];

        //Green
        this.pieceCollection[0][0] = (new Defender(0, 0, Color.green));
        this.pieceCollection[0][1] = (new Defender(0, 1, Color.green));
        this.pieceCollection[0][2] = (new Defender(0, 2, Color.green));
        this.pieceCollection[0][3] = (new Defender(0, 3, Color.green));
        this.pieceCollection[0][4] = (new Leader  (0, 4, Color.green));
        this.pieceCollection[2][3]=(new Turtles(Color.BLUE));

        //Yellow
        this.pieceCollection[4][1] = (new Defender(4, 1, Color.yellow));
        this.pieceCollection[4][2] = (new Defender(4, 2, Color.yellow));
        this.pieceCollection[4][3] = (new Defender(4, 3, Color.yellow));
        this.pieceCollection[4][4] = (new Defender(4, 4, Color.yellow));
        this.pieceCollection[4][0] = (new Leader  (4, 0, Color.yellow));
        this.pieceCollection[2][4]=(new Turtles(Color.RED));


        this.setSize(500, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int row = this.getBoardDimention(e.getY());               //
        int col = this.getBoardDimention(e.getX());               //

        if (this.selectedPiece != null){

            Units u=this.selectedPiece;

            if(u.isMoveValid(row,col)){
                moveUnit(row,col,u);
                this.repaint();
                return;}
        }
        if (this.hasBoardPiece(row, col)) {
            this.selectedPiece = this.getBoardPiece(row, col);
        }
//        Modal.render(this,"Congratulations!","You Won the battel!!!");}
        }
    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void paint(Graphics g) {
        for (int row = 0; row < 5; row++) {                         //Създава полето
            for (int col = 0; col < 5; col++) {
                this.renderGameTile(g, row, col);
                this.renderGamePiece(g, row, col);

            }
        }
    }
    private void moveUnit(int row, int col, Units u) {
        int initialRow= u.getRow();
        int initialCol= u.getCol();

        u.move(row, col);

        this.pieceCollection[u.getRow()][u.getCol()]=this.selectedPiece;
        this.pieceCollection[initialRow][initialCol]=null;

        this.selectedPiece=null;
    }

    private Color getTileColor(int row, int col) {
        if ((col == 0 && row == 0 || col == 4 && row == 0) ||
                (col == 1 && row == 4 || col == 3 && row == 4))  //If Else проверява кое поле как да се оцвети
        {
            return Color.ORANGE;     //Промяна на цвета на полето(ПНЦНП)
        } else if ((col == 1 && row == 1 || col == 0 && row == 1) ||
                (col == 3 && row == 1 || col == 4 && row == 1) ||
                (col == 1 && row == 3 || col == 0 && row == 3) ||
                (col == 3 && row == 3 || col == 4 && row == 3)) {
            return Color.GRAY;   //(ПНЦНП)
        } else if ((col == 1 && row == 0 || col == 3 && row == 0) ||
                (col == 0 && row == 4 || col == 4 && row == 4)) {
            return Color.BLACK;   //(ПНЦНП)
        } else if (col==2 && row==2) {
            return Color.CYAN;
        }
        return Color.WHITE;   //(ПНЦНП)
    }

    private void renderGameTile(Graphics g, int row, int col) {             //Рендира квадратите на полето

        Color tileColor = this.getTileColor(row, col);
        GameTile tile = new GameTile(row, col, tileColor);
        tile.render(g);
    }

    private Units getBoardPiece(int row, int col) {
        return this.pieceCollection[row][col];
    }

    private boolean hasBoardPiece(int row, int col) {                //Проверява дали фигората съществува
        return this.getBoardPiece(row, col) != null;
    }

    private void renderGamePiece(Graphics g, int row, int col) {
        if (this.hasBoardPiece(row, col)) {
            Units u=this.getBoardPiece(row,col);
            u.render(g);
        }
        }
        private int getBoardDimention ( int coordinates){
        return coordinates / GameTile.TILE_SIZE;
    }

}





