package App.Model.ChessPieces;

import App.Model.Color;

public class King extends ChessPiece {
    public King(Color color, int row, int column) {
        super("./src/App/img/rei-"+color+".png", color, row, column);
    }

    @Override
    public boolean ValidMovement(int rowDestination, int colunmDestination) {
        return true;
    }
}
