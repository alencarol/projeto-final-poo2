package App.View;

import App.Controller.TimeGame;
import App.Model.ChessBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChessMainView extends JFrame {
    private int dimensionWindow = 500;
    private JProgressBar barProgressTime;
    private  ChessBoardView chessBoardView;
    private TimeGame timeGame;

    public ChessMainView(String title){
        this.chessBoardView = new ChessBoardView(new ChessBoard());
        this.setTitle(title);
        this.setSize(dimensionWindow,dimensionWindow);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        this.setLayout(new BorderLayout());
        this.add(chessBoardView,BorderLayout.CENTER);
        this.Menu();
        this.barProgressTime();

        this.timeGame =new TimeGame(this.chessBoardView, this.barProgressTime);
        // Controlar execução da Thread
        Thread threadTime = new Thread(timeGame);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        threadTime.start();
        this.pack();
    }

    public void Menu(){
            // Cria uma barra de menu para o JFrame
            JMenuBar menuBar = new JMenuBar();

            // Adiciona a barra de menu ao  frame
            this.setJMenuBar(menuBar);

            // Define e adiciona dois menus drop down na barra de menus
            JMenu menu = new JMenu("Opções");
            menuBar.add(menu);

            // Cria e adiciona um item simples para o menu
            JMenuItem newAction = new JMenuItem("Novo Jogo");
            menu.add(newAction);
            newAction.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    resetGame();
                }
            });

    }

    public void barProgressTime(){
        barProgressTime = new JProgressBar();
        barProgressTime.setMinimum(0);
        barProgressTime.setMaximum(10);
        this.add(barProgressTime,BorderLayout.NORTH);
    }


    private void resetGame(){
        this.timeGame.resetTime();
        // Atualizando a referência do tabuleiro
        this.chessBoardView.setChessBoard(new ChessBoard());
        this.chessBoardView.buildChessBoardView();
    }

}
