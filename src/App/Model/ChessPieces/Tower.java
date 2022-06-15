package App.Model.ChessPieces;

import App.Model.Color;

public class Tower extends ChessPiece {
    public Tower(Color color, int row, int column) {
        super("/home/lucas/xadrez/torre-"+color+".png", color, row, column);
    }

    @Override
    public boolean ValidMovement(int rowDestination, int colunmDestination) {
        return true;
    }
}
