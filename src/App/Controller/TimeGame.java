package App.Controller;

import App.Model.ChessBoard;
import App.Model.Color;
import App.View.ChessBoardView;

import javax.swing.*;

public class TimeGame implements  Runnable{
    private ChessBoardView chessBoardView;
    private JProgressBar barProgressTime;
    private int time = 0;

    public TimeGame(ChessBoardView chessBoardView, JProgressBar barProgressTime){
        super();
        this.chessBoardView = chessBoardView;
        this.barProgressTime = barProgressTime;

    }
    @Override
    public void run() {
        int playTime = chessBoardView.getChessBoard().getPlayTime();
        Color turnMovement = chessBoardView.getChessBoard().getTurnMovement();
        String formatTurnMovement = null;

        switch (turnMovement){
            case black -> formatTurnMovement = "pretas";
            case white -> formatTurnMovement = "Brancas";
        }

        while (true){
            try {
                Thread.sleep(60000);
                addTime(time+1);
                this.barProgressTime.setValue(this.time);

                if (time<=playTime/2){
                    this.barProgressTime.setForeground(java.awt.Color.green);
                }

                if (time >= ((playTime/2) + ((playTime/2)/2))) {
                    this.barProgressTime.setForeground(java.awt.Color.red);
                }


                if (this.time >= playTime) {
                    JOptionPane.showMessageDialog(null, String.format("As %s pederão o Jogo, pois exedeu o limite de tempo",formatTurnMovement), "Informação", JOptionPane.INFORMATION_MESSAGE);
                    this.resetTime();
                    // Atualizando a referência do tabuleiro
                    this.chessBoardView.setChessBoard(new ChessBoard());
                    this.chessBoardView.buildChessBoardView();

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void addTime(int time) {
        this.time = time;
    }
    public void resetTime() {
        this.time = 0;
    }

}
