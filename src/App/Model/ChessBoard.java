package App.Model;

import App.Model.ChessPieces.ChessPiece;

public class ChessBoard {
    private ChessPiece[][] boardGame;
    private ChessPiece chessPieceSelect = null;
    private Collor turnMovement = Collor.WHITE;  // o primeiro movimento sempre é das peças brancas

    // Os jogadores tem um tempo para movimenta as peças
    private static int PlayTime = 10000;

    public ChessBoard(int rowns, int colunms){
        // criando a matriz que é a essencia do tabuleiro
        this.boardGame = new ChessPiece[rowns][colunms];
    }

    public ChessPiece getChessPiece(int rowChessPiece, int colunmChessPiece){
        return this.boardGame[rowChessPiece][colunmChessPiece];
    }

    public void  addChessPiece(ChessPiece piece){
        // as peças no xadrez tem possição definidas no tabuleiro
        this.boardGame[piece.getRow()][piece.getColumn()] = piece;
        // passando as referencia do tabuleiro para peça, pois a peça podem armazenar os dado do tabuleiro
        piece.addChessboard(this);

    }

    public void  selectChessPiece(ChessPiece piece){
        // Caso a peça do xadrez esteja selecionada
        if (piece.isSelect()){
            piece.setSelect(false);
            chessPieceSelect = null;
        }else { // caso a peça do xadrez não esteja selecionada
            piece.setSelect(true);
            this.chessPieceSelect = piece;
        }
    }

    public void  movementChessPiece(ChessPiece piece, int row, int colunm){

    }

    public void  setTurnMovement(){
        // se a jogada atual for das peças brancas, a proxima é das pretas
        if (turnMovement.equals(Collor.WHITE)) {
            this.turnMovement = Collor.BLACK;
        }else{
            this.turnMovement = Collor.WHITE;
        }

    }


}
