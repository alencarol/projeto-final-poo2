package App.Model;

import App.Model.ChessPieces.*;

import javax.swing.*;

public class ChessBoard {
    private int dimension = 8;
    private ChessPiece[][] boardGame;
    private ChessPiece chessPieceSelect = null;
    private Boolean existMovement = false;
    private Color turnMovement = Color.white;  // o primeiro movimento sempre é das peças brancas

    // Os jogadores tem um tempo para movimenta as peças
    private  int playTime;

    public ChessBoard(){
        // criando a matriz que é a essencia do tabuleiro
        this.boardGame = new ChessPiece[dimension][dimension];
        this.setPlayTime(10);
        this.buildChessPiece();
    }

    public ChessPiece getChessPiece(int rowChessPiece, int colunmChessPiece){
        return this.boardGame[rowChessPiece][colunmChessPiece];
    }
    
    private void  addChessPiece(ChessPiece piece){
        // as peças no xadrez tem possição definidas no tabuleiro
        this.boardGame[piece.getRow()][piece.getColumn()] = piece;
        // passando as referencia do tabuleiro para peça, pois a peça podem armazenar os dado do tabuleiro
        piece.addChessboard(this);

    }

    public void  removeChessPiece(ChessPiece piece){
        this.boardGame[piece.getRow()][piece.getColumn()] = null;

    }

    private void buildChessPiece(){
        // Torre branca
        addChessPiece(new Tower(Color.white,0,0));
        addChessPiece(new Tower(Color.white,0,7));

        // Torre Preta
        addChessPiece(new Tower(Color.black,7,7));
        addChessPiece(new Tower(Color.black,7,0));


        // Cavalo Branco
        addChessPiece(new Horse(Color.white,0,1));
        addChessPiece(new Horse(Color.white,0,6));

        // Cavalo Preto
        addChessPiece(new Horse(Color.black,7,1));
        addChessPiece(new Horse(Color.black,7,6));

        // Bispo Branco
        addChessPiece(new Bishop(Color.white,0,2));
        addChessPiece(new Bishop(Color.white,0,5));

        // Bispo Preto
        addChessPiece(new Bishop(Color.black,7,2));
        addChessPiece(new Bishop(Color.black,7,5));

        // Rei Branco
        addChessPiece(new King(Color.white,0,4));

        // Rei Preto
        addChessPiece(new King(Color.black,7,4));

        // Rainha Branca
        addChessPiece(new Queen(Color.white,0,3));

        // Rainha Preto
        addChessPiece(new Queen(Color.black,7,3));

        // Criando Peaos
        for (int i=0;i<8;i++){
            addChessPiece(new Peon(Color.white,1,i));
            addChessPiece(new Peon(Color.black,6,i));
        }
    }

    public void selectChessPiece(ChessPiece piece){
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
        if (piece.ValidMovement(row,colunm)) { // true
            this.removeChessPiece(piece); // remover
            // Atualizar a referencia
            piece.setRow(row);
            piece.setColunm(colunm);

            this.addChessPiece(piece);
            this.selectChessPiece(piece);
            this.setTurnMovement();
            this.existMovement = true;
        }

    }

    public void  setTurnMovement(){
        // se a jogada atual for das peças brancas, a proxima é das pretas
        switch (turnMovement){
            case white -> this.turnMovement = Color.black;
            case black -> this.turnMovement = Color.white;
        }
    }


    // buildPlay controir a jogadar
    public void buildPlay(int row, int col) {
        // captura a peça selecionada
        ChessPiece piece = this.getChessPiece(row, col);

        if (this.chessPieceSelect == null && piece != null && !piece.getColor().equals(turnMovement)) {
            JOptionPane.showMessageDialog(null, "Não é sua vez de jogar", "Informação", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Realizar as verifiações necessarias para selecionar peça da joga e realizar o movimento
        // Realizar as verifiações necessarias para selecionar peça da joga e realizar o movimento
        if ((this.chessPieceSelect == null) && (piece != null && piece.getColor().equals(turnMovement))) {
            this.selectChessPiece(piece);
        } else {
            if (this.chessPieceSelect.equals(piece)) {
                this.selectChessPiece(piece);
            } else {
                if (piece == null || !piece.getColor().equals(this.chessPieceSelect.getColor())) {
                    this.movementChessPiece(this.chessPieceSelect, row, col);
                }
            }


        }

    }

    public int getPlayTime() {
        return playTime;
    }

    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }

    public Color getTurnMovement(){
        return  this.turnMovement;
    }

    public boolean getExistMovement(){
        return  this.existMovement;
    }

    public void setExistMovement(boolean existMovement){
        this.existMovement = existMovement;
    }
}
