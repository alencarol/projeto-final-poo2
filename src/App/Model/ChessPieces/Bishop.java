package App.Model.ChessPieces;

import App.Model.Color;

public class Bishop extends ChessPiece {
    public Bishop(Color color, int row, int column) {
        super("bishop", color, row, column);
    }

    @Override
    public boolean ValidMovement(int rowDestination, int colunmDestination) {

        int rowOrigin = this.getRow();
        int colunmOrigin =  this.getColumn();
        int column, row;


        ChessPiece piece = this.getChessboard().getChessPiece( rowDestination,colunmDestination);
        if (piece != null  && piece.getColor().equals(this.getColor())) {
            return  false;
        }

        if (colunmDestination == colunmOrigin || rowDestination == rowOrigin) {
            return  false;
        }

       column = Math.abs(colunmDestination - colunmOrigin);
        row = Math.abs(rowDestination - rowOrigin);

        if (column == row) {
            return  true;
        }

        return false;
    }
}
