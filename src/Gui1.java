import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui1 extends JFrame {
    private JButton newGameButton;
    private JButton quitGameButton;
    private JPanel rootPanel;
    public boolean access;

    public Gui1(){
        setUndecorated(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2 - 180 , dim.height/2-this.getSize().height/2 - 260);
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
//                Gui2 gui_2 = new Gui2();
//                gui_2.setVisible(true);
            }
        });
        quitGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                access = false;
                System.exit(0);
            }
        });
    }
}
