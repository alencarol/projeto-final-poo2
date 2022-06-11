package App.View;

import App.Model.ChessBoard;

import javax.swing.*;

public class ChessBoardView extends JPanel {
    private ChessBoard chessBoard;

    ChessBoardView(ChessBoard chessBoard){
        this.chessBoard = chessBoard;
    }
}
