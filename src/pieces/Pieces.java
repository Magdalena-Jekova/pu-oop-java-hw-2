package pieces;

import java.awt.*;

public abstract class Pieces {

    public static final int PIECE_SIZE = 50;
    protected int row;
    protected int col;
    protected Color color;
    
    public Pieces(int row, int col, Color color){
        this.row   = row;
        this.col   = col;
        this.color = color;
    }

    public abstract void render(Graphics g);

    public boolean isMoveValid(int moveRow, int moveCol){
        int rowCoefficient = Math.abs(this.row - moveRow );
        int colCoefficient = Math.abs(this.col - moveCol );

        return  (rowCoefficient == 1 && colCoefficient == 0) ;
    };

    public abstract void move(int row, int col, Pieces[][] pieceCollection);
}