package App.Model.ChessPieces;

import App.Model.ChessBoard;
import App.Model.Color;

public class Peon extends ChessPiece {
    private boolean isFirstMove = true;

    public Peon(Color color, int row, int column) {
        super("./src/App/img/peao-"+color+".png", color, row, column);
    }

    @Override
    public boolean ValidMovement(int rowDestination, int colunmDestination) {
        int rowOrigin = this.getRow();
        int colunmOrigin =  this.getColumn();

        // Valida se existe alguma pença na possição de destino
        ChessPiece piece = this.getChessboard().getChessPiece( rowDestination,colunmDestination);
        if (piece != null && colunmOrigin == colunmDestination ) {
            return  false;
        }

        // O peão só pode se movimenta na horizotal, salvo algumas exceções
        if (colunmDestination != colunmOrigin)  {
            if (piece == null  ||  piece.getColor().equals(this.getColor())){
                return  false;
            }

        }


        // Valida a movimentação dos peãos de acordo com a cor
        switch (this.getColor()){
            // Valida os peãos brancos
            case white: {
                if (rowDestination < this.getRow()) {
                    // o peão não pode mover para atras
                    return false;
                } else if (rowDestination > rowOrigin + 2 && this.isFirstMove) {
                    // valida primeira jogada
                    return false;
                }

                break;
            }

            // Valida os peãos Pretos
            case black:{
                if (rowDestination > this.getRow()){
                    // o pião não pode mover para atras
                    return  false;
                }else  if (rowDestination <rowOrigin-2 && this.isFirstMove) {
                    // valida primeira jogada
                    return  false;
                }else if (rowDestination <rowOrigin-1 && !this.isFirstMove){
                    // valida as jogas depois da primeira
                    return  false;
                }

                break;
            }

        }

        this.isFirstMove = true;
        return true;
    }
}
