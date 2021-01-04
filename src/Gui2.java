import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui2 extends JFrame{


    private JButton a1PlayerButton;
    private JButton a2PlayersButton;
    private JPanel rootPanel2;

    public Gui2(){
        add(rootPanel2);
        setTitle("Buzz");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        a1PlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Gui3 gui3 = new Gui3();
                gui3.setVisible(true);
            }
        });
        a2PlayersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Gui3 gui3 = new Gui3();
                gui3.setVisible(true);
            }
        });
    }

}
