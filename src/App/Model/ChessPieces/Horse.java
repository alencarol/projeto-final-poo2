package App.Model.ChessPieces;

import App.Model.Color;

public class Horse extends ChessPiece {
    public Horse(Color color, int row, int column) {
        super("/home/lucas/xadrez/cavalo-"+color+".png", color, row, column);
    }

    @Override
    public boolean ValidMovement(int rowDestination, int colunmDestination) {

        int rowOrigin = this.getRow();
        int colunmOrigin =  this.getColumn();


        ChessPiece piece = this.getChessboard().getChessPiece( rowDestination,colunmDestination);
        if (piece != null  && piece.getColor().equals(this.getColor())) {
            return  false;
        }


        // Validação do comevimento do cavalo, nota o cavalo se move em L
        if ( ( colunmDestination == colunmOrigin+1 || colunmDestination == colunmOrigin -1 ) && (rowDestination == rowOrigin+2 || rowDestination == rowOrigin-2)){
            return  true;
        }

        if ( (colunmDestination == colunmOrigin+2  ||  colunmDestination == colunmOrigin -2) && (rowDestination == rowOrigin+1 || rowDestination == rowOrigin-1)){
            return  true;
        }


        return false;
    }
}
