import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui2 extends JFrame{


    private JButton a1PlayerButton;
    private JButton a2PlayersButton;
    private JPanel rootPanel2;
    private JTextField textField1;
    private JButton submitButton;
    public int n_rounds;
    public Gui_connection gui_con;
    public Game game;

    public Gui2(){
        game = new Game();
        gui_con = new Gui_connection();
        add(rootPanel2);
        setTitle("Buzz");
        setSize(350,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        a1PlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.players=1;

            }
        });
        a2PlayersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.players=2;
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n_rounds = Integer.parseInt(textField1.getText());
                gui_con.num_rounds = n_rounds;
                dispose();
                if (game.players == 1) {
                    Gui4_1 gui4_1 = new Gui4_1();
                    gui4_1.setVisible(true);
//                    game.play(gui_con);
                }
                else {
                    Gui4_2 gui4_2 = new Gui4_2();
                    gui4_2.setVisible(true);
//                    game.play(gui_con);
                }
            }
        });
        game.play(gui_con);
    }

}
