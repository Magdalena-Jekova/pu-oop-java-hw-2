package pieces;

import java.awt.*;

public class FrogsGuard extends Pieces{

    public FrogsGuard(int row, int col, Color color){
        super(row, col, color);
    }

    /**
     * Метод за визуализиране на гардовете, в зависимост от техния цвят.
     * @param g Graphics object
     */
    @Override
    public void render(Graphics g) {

        int frogsGuardX = this.col * (PIECE_SIZE * 2);
        int frogsGuardY = this.row * (PIECE_SIZE * 2);

        if(color == Color.YELLOW) {
            g.setColor(Color.GREEN);
            g.fillOval(frogsGuardX + 20,frogsGuardY + 30,60,60);

            g.setColor(Color.YELLOW);
            g.fillOval(frogsGuardX + 25,frogsGuardY + 35, PIECE_SIZE, PIECE_SIZE);
        }

        if(color == Color.GREEN){
            g.setColor(Color.YELLOW);
            g.fillOval(frogsGuardX + 20, frogsGuardY + 20, 60, 60);

            g.setColor(Color.GREEN);
            g.fillOval(frogsGuardX + 25, frogsGuardY + 25, PIECE_SIZE, PIECE_SIZE);
        }
    }

    /**
     * Метод, чрез който се проверява дали движението на гардовете е валидно.
     *
     * @param moveRow - редът, на който искаме да преместим фигурата
     * @param moveCol - колоната, на която искаме да преместим фигурата
     * @return метода връща true или false, в зависимост от това дали придвижването на фигурата е възможно
     */
    @Override
    public boolean isMoveValid(int moveRow, int moveCol) {

        int rowCoefficient = Math.abs(this.row - moveRow );
        int colCoefficient = Math.abs(this.col - moveCol );

        return  (rowCoefficient == 1 && colCoefficient == 0) || (rowCoefficient == 0 && colCoefficient == 1);
    }

    /**
     * Метод, при извикването на който фигурата се премества на друго поле от дъската,
     * ако движението е валидно.
     * @param row - редът, на който фигурата ще се премести
     * @param col - колоната, на която фигурата ще се премести
     */
    @Override
    public void move(int row, int col, Pieces[][] pieceCollection) {
        if(isMoveValid(row, col) && pieceCollection[row][col] == null){
            this.row = row;
            this.col = col;
        }
    }
}