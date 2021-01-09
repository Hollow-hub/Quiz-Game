import javax.swing.*;

public class Gui_Image extends JFrame{
    private JPanel ImagePanel;
    private JLabel Image;

    Gui_Image(String imagePath){
        add(ImagePanel);
        ImageIcon im = new ImageIcon(imagePath);
        Image.setIcon(im);
        setTitle("Image");
        setSize(250,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
}




