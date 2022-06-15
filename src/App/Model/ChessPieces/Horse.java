package App.Model.ChessPieces;

import App.Model.Color;

public class Horse extends ChessPiece {
    public Horse(Color color, int row, int column) {
        super("/home/lucas/xadrez/cavalo-"+color+".png", color, row, column);
    }

    @Override
    public boolean ValidMovement(int rowDestination, int colunmDestination) {
        return true;
    }
}
