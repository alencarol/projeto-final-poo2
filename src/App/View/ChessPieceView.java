package App.View;

import App.Model.ChessPieces.ChessPiece;

import java.awt.*;

public class ChessPieceView extends Label {
    private ChessPiece piece;

    ChessPieceView(ChessPiece piece){
        this.piece = piece;
    }

    public ChessPiece getChessPieceView(){
        return this.piece;
    }


}
