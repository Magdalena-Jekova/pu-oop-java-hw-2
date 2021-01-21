package game;

import pieces.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameBoard extends JFrame implements MouseListener {

    public static final int TILE_SIDE_COUNT = 5;
    private Pieces[][] pieceCollection;
    private Pieces selectedPiece;

    public GameBoard(){
        this.pieceCollection = new Pieces[TILE_SIDE_COUNT][TILE_SIDE_COUNT];

        //Yellow Frogs
        this.pieceCollection[0][4] = (new FrogsLeader(0,4, Color.YELLOW));
        this.pieceCollection[0][0] = (new FrogsGuard (0,0, Color.YELLOW));
        this.pieceCollection[0][1] = (new FrogsGuard (0,1, Color.YELLOW));
        this.pieceCollection[0][2] = (new FrogsGuard (0,2, Color.YELLOW));
        this.pieceCollection[0][3] = (new FrogsGuard (0,3, Color.YELLOW));

        //Green Frogs
        this.pieceCollection[4][0] = (new FrogsLeader(4,0, Color.GREEN));
        this.pieceCollection[4][1] = (new FrogsGuard (4,1, Color.GREEN));
        this.pieceCollection[4][2] = (new FrogsGuard (4,2, Color.GREEN));
        this.pieceCollection[4][3] = (new FrogsGuard (4,3, Color.GREEN));
        this.pieceCollection[4][4] = (new FrogsGuard (4,4, Color.GREEN));

        this.setSize(500, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = this.getBoardDimensionBasedOnCoordinates(e.getY());
        int col = this.getBoardDimensionBasedOnCoordinates(e.getX());

        if(this.selectedPiece != null) {
            Pieces piece = this.selectedPiece;
            piece.move(row, col, this.pieceCollection);

            this.selectedPiece = null;

            this.repaint();
        }

        if(this.hasBoardPiece(row, col)) {
            this.selectedPiece = this.getBoardPiece(row, col);
        }
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

    /**
     * Метод за визуализиране на фигурите върху дъската,
     * както и на всички нейни полета.
     * @param g Graphics object
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for(int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                this.renderGameBoardTiles(g, row, col);
                this.renderGamePiece(g, row, col);
            }
        }
    }

    /**
     * Метод за визуализиране на полетата на дъската.
     * @param g Graphics object
     * @param row - редът, на който трябва да се постави поле на дъската
     * @param col - колоната, на която трябва да се постави поле на дъската
     */
    private void renderGameBoardTiles(Graphics g, int row, int col){

        BoardTile boardTile = new BoardTile(row, col);
        boardTile.render(g);

        ComplexTile complexTile = new ComplexTile(2, 2);
        complexTile.render(g);
    }

    /**
     * Метод, който връща фигура, която се намира на съответния ред и колона.
     * @param row - редът, на който се намира фигурата
     * @param col - колоната, на която се намира фигурата
     * @return object
     */
    private Pieces getBoardPiece(int row, int col) {
        return this.pieceCollection[row][col];
    }

    /**
     * Метод, който проверява дали на съответния ред и колона има фигура.
     * @param row - редът, на който се проверява дали има фигура
     * @param col - колоната, на която се проверява дали има фигура
     * @return true, ако има фигура и false, ако няма фигура на този ред и колона
     */
    private boolean hasBoardPiece(int row, int col) {
        return this.getBoardPiece(row, col) != null;
    }

    /**
     * Метод за визуализиране на фигура, ако има такава на съответния ред и колона.
     * @param g Graphics object
     * @param row - редът, на който трябва да се визуализира фигурата
     * @param col - колоната, на която трябва да се визуализира фигурата
     */
    private void renderGamePiece(Graphics g, int row, int col) {

        if(this.hasBoardPiece(row, col)) {
            Pieces p = this.getBoardPiece(row, col);
            p.render(g);
        }
    }

    private int getBoardDimensionBasedOnCoordinates(int coordinates) {
        return coordinates / BoardTile.TILE_SIZE;
    }
}