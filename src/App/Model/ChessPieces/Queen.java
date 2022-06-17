package App.Model.ChessPieces;

import App.Model.Color;

public class Queen extends ChessPiece {
    public Queen(Color color, int row, int column) {
        super("./src/App/img/rainha-"+color+".png", color, row, column);
    }

    @Override
    public boolean ValidMovement(int rowDestination, int colunmDestination) {
        return true;
    }
}
