import javax.swing.*;
import java.awt.*;

public class Gui_Image extends JFrame{
    private JPanel ImagePanel;
    private JLabel Image;

    Gui_Image(String imagePath){
        setUndecorated(true);
        add(ImagePanel);
        ImageIcon im = new ImageIcon(new ImageIcon (imagePath).getImage().getScaledInstance(400,400, java.awt.Image.SCALE_DEFAULT ));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2 - 880 , dim.height/2-this.getSize().height/2 - 280);
        Image.setIcon(im);
        setTitle("Image");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
}




