package App.Model.ChessPieces;

import App.Model.Color;

public class Bishop extends ChessPiece {
    public Bishop(Color color, int row, int column) {
        super("/home/lucas/xadrez/bispo-"+color+".png", color, row, column);
    }

    @Override
    public boolean ValidMovement(int rowDestination, int colunmDestination) {
        return true;
    }
}
