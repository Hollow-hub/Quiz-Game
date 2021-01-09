import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui1 extends JFrame {
    private JButton newGameButton;
    private JButton quitGameButton;
    private JPanel rootPanel;
    private JButton instructionsButton;
    public Gui_connection gui_connection;
    public boolean access;

    public Gui1(){
        setUndecorated(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2 - 180 , dim.height/2-this.getSize().height/2 - 260);
        gui_connection = new Gui_connection();
        add(rootPanel);
        setTitle("Buzz");
        setSize(350,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                access = true;
            }
        });
        quitGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                access = false;
                System.exit(0);
            }
        });
        instructionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui_Instructions gui_instructions = new Gui_Instructions();
                gui_instructions.setVisible(true);
            }
        });
    }
}
