package App.View;

import App.Model.ChessBoard;
import App.Model.ChessPieces.ChessPiece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChessBoardView extends JPanel implements MouseListener {
    private ChessBoard chessBoard;
    // A dimenção do tabuleiro de xadrez é 8 x 8, isto é 8 linhas e 8 colunas
    private int dimension = 8;

    ChessBoardView(ChessBoard chessBoard){
        this.chessBoard = chessBoard;
        this.buildChessBoardView();
    }

    // A cada movimento a interface é construida
    public void buildChessBoardView(){
        this.removeAll();
        // Como o xadrez possui um formato de uma tabela de 8x8, usa-se o gridLayout,
        // Para modelar tabuleiro na interface gráfica
        this.setLayout(new GridLayout(dimension,dimension));
        // Percorrendo linhas e colunas para organizar as pessas na interface
        for (int  row = 0; row < dimension ; row ++) {
            for (int col = 0; col < dimension; col++) {
                // cada peça vai ocupar uma celular ou casa no tabuleiro de xadrez
                ChessCellView cellView;
                ChessPiece piece = this.chessBoard.getChessPiece(row,col);

                // caso já exista uma peça
                if (piece != null) {
                    // é passado a peça para a sua celula ou casa
                    cellView = new ChessCellView(new ChessPieceView(piece));
                }else{
                    // caso não exista uma peça cria vazia a celula ou casa
                    cellView = new ChessCellView(row, col);
                }

                if ((row + col) % 2 ==0){
                    cellView.setBackground(Color.white);
                }else{
                    cellView.setBackground(Color.darkGray);
                }

                this.add(cellView);
                cellView.addMouseListener(this);
            }
        }

        // Força a atualização da tela
        this.revalidate();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Obtém a celular  que foi clicada
        ChessCellView cell = (ChessCellView) e.getSource();
        // Controi a jogada
        this.chessBoard.buildPlay(cell.getRow(),cell.getColunm());
        // Recontroi o tabuleiro
        this.buildChessBoardView();

    }

    public  ChessBoard getChessBoard(){
        return  this.chessBoard;
    }



    public void setChessBoard(ChessBoard chessBoard){
        this.chessBoard = chessBoard;
    }

    @Override
    public void mousePressed(MouseEvent e) {


    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
