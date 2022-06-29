package App.View;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JFrame {
    private JButton buttonStart;
    private JLabel label;

    public MainView() {
        this.label = new JLabel("Bem vindo ao Xadrez Bruxo");
        this.label.setBounds(50, 50, 400, 40);

        this.buttonStart = new JButton("Inicar");
        this.buttonStart.setBounds(100, 100, 100, 40);
        this.buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chess();
            }
        });

        this.setSize(300, 200);
        this.setLayout(null);
        this.setVisible(true);
        this.add(this.buttonStart);
        this.add(this.label);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void chess() {
        new ChessMainView("Xadrez Bruxo");
        this.setVisible(false);
    }
}