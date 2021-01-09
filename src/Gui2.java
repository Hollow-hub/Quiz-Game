import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui2 extends JFrame{


    private JButton a1PlayerButton;
    private JButton a2PlayersButton;
    private JPanel rootPanel2;
    private JTextField textField1;
    private JButton submitButton;
    private JButton Exit;
    public int n_rounds;
    public Gui_connection gui_con;
    public int players;

    public Gui2(){
        setUndecorated(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2 - 180 , dim.height/2-this.getSize().height/2 - 260);
        gui_con = new Gui_connection();
        add(rootPanel2);
        setTitle("Buzz");
        setSize(350,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        a1PlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                players=1;
            }
        });
        a2PlayersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                players=2;
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n_rounds = Integer.parseInt(textField1.getText());
                dispose();
//                if (players == 1) {
//
////                    Gui4_1 gui4_1 = new Gui4_1();
////                    gui4_1.setVisible(true);
//                }
//                else {
////                    Gui4_2 gui4_2 = new Gui4_2();
////                    gui4_2.setVisible(true);
//
//                }
            }
        });
        //game.play(gui_con);
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

}
