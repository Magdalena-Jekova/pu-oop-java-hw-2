package pieces;

import java.awt.*;

public class FrogsLeader extends Pieces{

    public FrogsLeader(int row, int col, Color color){
        super(row, col, color);
    }

    /**
     * Метод за визуализиране на лидерите, в зависимост от техния цвят.
     * @param g Graphics object
     */
    @Override
    public void render(Graphics g) {

        int frogsLeaderX = this.col * (PIECE_SIZE * 2);
        int frogsLeaderY = this.row * (PIECE_SIZE * 2);

        g.setColor(color);
        if (color.equals(Color.YELLOW)) {
            g.fillRect(frogsLeaderX + 20, frogsLeaderY + 30, PIECE_SIZE, PIECE_SIZE);
        }
        if(color.equals(Color.GREEN)){
            g.fillRect(frogsLeaderX + 30,frogsLeaderY + 20, PIECE_SIZE, PIECE_SIZE);
        }
    }

    /**
     * Метод, при извикването на който фигурата се премества на друго поле от дъската,
     * ако движението е валидно.
     * @param row - редът, на който фигурата ще се премести
     * @param col- колоната, на която фигурата ще се премести
     */
    @Override
    public void move(int row, int col, Pieces[][] pieceCollection) {

        if(pieceCollection[row][col] == null){
            this.row = row;
            this.col = col;
        }else if (row < this.row){
            this.row = row + 1;
        }else if (row > this.row){
            this.row = row - 1;
        }
    }
}