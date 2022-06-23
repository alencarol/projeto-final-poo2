package App.Model.ChessPieces;

import App.Model.Color;

public class King extends ChessPiece {
    public King(Color color, int row, int column) {
        super("./src/App/img/rei-"+color+".png", color, row, column);
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
        //validando movimento do rei. Nota: o rei anda em quadrado 3 X 3
        if ( ((rowDestination == rowOrigin+1) || (rowDestination == rowOrigin-1)) &&
                ((colunmDestination == colunmOrigin) || (colunmDestination == colunmOrigin+1) || (colunmDestination == colunmOrigin-1)) ){
            return true;
        }else if ( (rowDestination == rowOrigin) && ((colunmDestination == colunmOrigin+1) || (colunmDestination == colunmOrigin-1)) ){
            return true;
        }

        return false;
    }
}
