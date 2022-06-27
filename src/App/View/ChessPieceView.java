package App.View;

import App.Model.ChessPieces.ChessPiece;

import javax.swing.*;

public class ChessPieceView extends JLabel {
    private ChessPiece piece;

    ChessPieceView(ChessPiece piece){
        this.piece = piece;
        this.setIcon(new ImageIcon(piece.getUrlImage()));
    }

    public ChessPiece getChessPiece(){
        return this.piece;
    }


}
