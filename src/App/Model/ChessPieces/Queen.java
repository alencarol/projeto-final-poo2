package App.Model.ChessPieces;

import App.Model.Color;

public class Queen extends ChessPiece {
    public Queen(Color color, int row, int column) {
        super("queen", color, row, column);
    }

    @Override
    public boolean ValidMovement(int rowDestination, int colunmDestination) {
        //linha e coluna de destino:
        int rowOrigin = this.getRow();
        int colunmOrigin =  this.getColumn();

        ChessPiece piece = this.getChessboard().getChessPiece( rowDestination,colunmDestination); //pega a peça que está na posição de destino
        if (piece != null  && piece.getColor().equals(this.getColor())) { // retorna falso se tiver uma peça de mesma cor nesse posição
            return  false;
        }
        //validando movimento da rainha. Nota: a rainha anda na vertical, na horizontal e na diagonal
        if ( ( colunmDestination == colunmOrigin+1 || colunmDestination == colunmOrigin -1 ) && (rowDestination == rowOrigin+2 || rowDestination == rowOrigin-2)){
            return  false;
        }
        if ( (colunmDestination == colunmOrigin+2  ||  colunmDestination == colunmOrigin -2) && (rowDestination == rowOrigin+1 || rowDestination == rowOrigin-1)){
            return  false;
        }

        return true;
    }
}
