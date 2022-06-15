package App.Model.ChessPieces;

import App.Model.Color;

public class King extends ChessPiece {
    public King(Color color, int row, int column) {
        super("/home/lucas/xadrez/rei-"+color+".png", color, row, column);
    }

    @Override
    public boolean ValidMovement(int rowDestination, int colunmDestination) {
        return true;
    }
}
