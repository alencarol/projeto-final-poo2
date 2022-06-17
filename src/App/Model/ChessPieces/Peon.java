package App.Model.ChessPieces;

import App.Model.Color;

public class Peon extends ChessPiece {
    private boolean isFirstMove = true;

    public Peon(Color color, int row, int column) {
        super("./src/App/img/peao-"+color+".png", color, row, column);
    }

    @Override
    public boolean ValidMovement(int rowDestination, int colunmDestination) {
        if (colunmDestination != this.getColumn()) {
            return  false;
        }

        return true;
    }
}
