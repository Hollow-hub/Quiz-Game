import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui_Bidding extends  JFrame{
    private JPanel rootPanelBidding;
    private JButton a250Button;
    private JButton a500Button;
    private JButton a750Button;
    private JButton a1000Button;
    public JLabel Player;
    public int bidding;

    public Gui_Bidding(){
        add(rootPanelBidding);
        setTitle("Buzz");
        setSize(350,220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        a250Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bidding = 250;
                dispose();
            }
        });
        a500Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bidding = 500;
                dispose();
            }
        });
        a750Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bidding = 750;
                dispose();
            }
        });
        a1000Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bidding = 1000;
                dispose();
            }
        });
    }
}
