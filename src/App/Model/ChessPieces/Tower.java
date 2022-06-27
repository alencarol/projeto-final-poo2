package App.Model.ChessPieces;

import App.Model.Color;

public class Tower extends ChessPiece {
    public Tower(Color color, int row, int column) {
        super("tower", color, row, column);
    }

    @Override
    public boolean ValidMovement(int rowDestination, int colunmDestination) {
        //linha e coluna atual:
        int rowOrigin = this.getRow();
        int colunmOrigin =  this.getColumn();

        ChessPiece piece = this.getChessboard().getChessPiece( rowDestination,colunmDestination); //pega a peça que está na posição de destino
        if (piece != null  && piece.getColor().equals(this.getColor())) { // retorna falso se tiver uma peça de mesma cor nesse posição
            return  false;
        }
        //Validação do movimento da torre. Nota: a torre anda em vertical ou horizontal
        if (((rowDestination == rowOrigin) && (colunmDestination != colunmOrigin)) || ((rowDestination != rowOrigin) && (colunmDestination == colunmOrigin))) {
            return true;
        }

        return false;
    }
}
