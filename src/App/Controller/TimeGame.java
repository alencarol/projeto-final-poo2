package App.Controller;

import App.Model.ChessBoard;
import App.Model.Color;
import App.View.ChessBoardView;

import javax.swing.*;

public class TimeGame implements  Runnable{
    private ChessBoardView chessBoardView;
    private JProgressBar barProgressTime;
    private int time, timeSecods = 0;

    public TimeGame(ChessBoardView chessBoardView, JProgressBar barProgressTime){
        super();
        this.chessBoardView = chessBoardView;
        this.barProgressTime = barProgressTime;
    }

    @Override
    public void run() {
        int playTime = chessBoardView.getChessBoard().getPlayTime();
        String formatTurnMovement = null;

        while (true){
            try {
                Color turnMovement = chessBoardView.getChessBoard().getTurnMovement();
                Boolean existMovement = chessBoardView.getChessBoard().getExistMovement();

                switch (turnMovement){
                    case black -> formatTurnMovement = "pretas";
                    case white -> formatTurnMovement = "Brancas";
                }


                Thread.sleep(10);
                addTime(time+1);
                if ((time % 1000) == 0){
                    timeSecods += 1;
                }

                this.barProgressTime.setValue(this.timeSecods);


                if (timeSecods<=playTime/2){
                    this.barProgressTime.setForeground(java.awt.Color.green);
                }

                if (timeSecods >= ((playTime/2) + ((playTime/2)/2))) {
                    this.barProgressTime.setForeground(java.awt.Color.red);
                }

                if (existMovement && this.timeSecods < playTime) {
                    this.resetTime();
                    chessBoardView.getChessBoard().setExistMovement(false);
                }


                if (this.timeSecods >= playTime) {
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
        this.timeSecods = 0;
    }

}
