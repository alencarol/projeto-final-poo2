package App.View;

import javax.swing.*;

public class ChessCellView extends JPanel {
    private ChessPieceView chessPieceView;
    private int row, colunm;

    ChessCellView(int row, int colunm){
        this.row = row;
        this.colunm = colunm;
    }
}
