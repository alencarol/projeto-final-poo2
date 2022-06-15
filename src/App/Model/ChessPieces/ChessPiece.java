package App.Model.ChessPieces;

import App.Model.ChessBoard;
import App.Model.Color;

// ChessPiece é uma classe que não vai poder gerar objetos, pois é abstrata, vai servir apenas
// como modelo para construção de outras classes
public abstract  class ChessPiece {
    private Color color; // toda peça tem uma cor
    private int row, column; // toda peça tem uma posição no tabuleiro
    private String imageIcon; // toda peça tem uma imagem

    // toda peça tem um status de vida, no inicio do jogo todas estão com vida
    // toda peça pode ou não está selecionada, no inicio do jogo nenhuma peça está selecionada
    private boolean lifeless , select = false;

    // A peça deve ter acesso ao tabuleiro, para obter algumas informações, pois a peça está inserida no tabuleiro.
    private ChessBoard chessboard;

    public ChessPiece(String imageIcon, Color color, int row, int column){
        this.imageIcon = imageIcon;
        this.color = color;
        this.row = row;
        this.column = column;

    }

    public void addChessboard(ChessBoard chessboard){
        this.chessboard = chessboard;
    }

    public ChessBoard getChessboard(ChessBoard chessboard){
        return this.chessboard;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }


    public boolean isLifeless() {
        return lifeless;
    }

    public void setLifeless(boolean lifeless) {
        this.lifeless = lifeless;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public Color getColor() {
        return color;
    }

    // ValidMovement é um metodo que vai ser implementado nas sub classes
    public  abstract boolean ValidMovement(int rowDestination, int colunmDestination);


    public String getImageIcon() {
        return imageIcon;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColunm(int colunm) {
        this.column = colunm;
    }
}