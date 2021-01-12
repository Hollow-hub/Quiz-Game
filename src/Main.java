import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, IOException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
//                Gui1 gui_1 = new Gui1();
//                gui_1.setVisible(true);
            }
        });
        Game buzz = new Game();
        buzz.play();
    }
}
