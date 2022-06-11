package App.Model.ChessPieces;

import App.Model.Collor;

public class Peon extends ChessPiece {
    private boolean isFirstMove = true;

    public Peon(String imageIcon, Collor collor, int row, int column) {
        super(imageIcon, collor, row, column);
    }

    @Override
    public boolean ValidMovement(int rowDestination, int colunmDestination) {

        return true;
    }
}
