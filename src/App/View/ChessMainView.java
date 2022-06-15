package App.View;

import App.Model.ChessBoard;

import javax.swing.*;
import java.awt.*;

public class ChessMainView extends JFrame {
    private static int dimensionWindow = 500;
    private JButton buttonRestartGame;

    public ChessMainView(String title, int dimension){
        this.setTitle(title);
        this.setSize(dimensionWindow,dimensionWindow);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        this.setLayout(new BorderLayout());
        this.add(new ChessBoardView(new ChessBoard(dimension)),BorderLayout.CENTER);
        this.buildPanelSide();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

    }

    // Constroi a menu lateral
    private void buildPanelSide() {
        JPanel panelTop = new JPanel();
        panelTop.setLayout(new GridLayout(10,1));
        buttonRestartGame = new JButton("Reiniciar Jogo");
        panelTop.add(buttonRestartGame);
        this.add(panelTop,BorderLayout.WEST);
    }

}
/*
 WEST - lateral
 NORTH - topo
 */