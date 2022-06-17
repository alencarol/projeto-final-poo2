package App.View;

import App.Model.ChessBoard;

import javax.swing.*;
import java.awt.*;

public class ChessMainView extends JFrame {
    private int dimensionWindow = 500;


    public ChessMainView(String title, int dimension){
        this.setTitle(title);
        this.setSize(dimensionWindow,dimensionWindow);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        this.setLayout(new BorderLayout());
        this.add(new ChessBoardView(new ChessBoard(dimension)),BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

    }

}
