package App.View;

import javax.swing.*;
import java.awt.*;

public class ChessCellView extends JPanel {
    private ChessPieceView pieceView;
    private int row, colunm;

    ChessCellView(int row, int colunm){
        this.row = row;
        this.colunm = colunm;
    }

    ChessCellView(ChessPieceView pieceView){
        this.pieceView = pieceView;
        this.row = pieceView.getChessPiece().getRow();
        this.colunm = pieceView.getChessPiece().getColumn();
        this.add(pieceView);
        if ((pieceView.getChessPiece() != null) && (pieceView.getChessPiece().isSelect())){
            this.setBorder(BorderFactory.createLineBorder(Color.green,6));
        }
    }


    public int getColunm() {
        return colunm;
    }

    public int getRow() {
        return row;
    }
}
