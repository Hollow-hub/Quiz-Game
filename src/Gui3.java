import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui3 extends JFrame{
    private JPanel rootPanel3;
    private JTextField textField1;
    private JButton submitButton;
    public int n_rounds;
    public Gui_connection gui_con;


    public Gui3(){
        gui_con = new Gui_connection();
        add(rootPanel3);
        setTitle("Buzz");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //isInt(textField1, textField1.getText());
                n_rounds = Integer.parseInt(textField1.getText());
                gui_con.num_rounds = n_rounds;
                dispose();
                Gui4_1 gui4_1 = new Gui4_1();
                gui4_1.setVisible(true);
            }
        });
    }
    public boolean isInt(JTextField input, String message){
        try{
            int rounds = Integer.parseInt(input.getText());
            System.out.println("Nice " + rounds);
            return true;
        }catch(NumberFormatException e){
            System.out.println("Error " + message + " is not a number");
            return false;
        }

    }

}
