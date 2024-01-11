import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{
    static OknoWejsciowe o;

    public static void main(String[] args) {
        o = new OknoWejsciowe();
        ImageIcon icon = new ImageIcon("src/logo - DVDelfin2.jpg");
        o.setIconImage(icon.getImage());
        o.setContentPane(o.getPanelStartowy());
        o.setTitle("DVDelfin - Start");
        o.setSize(300,500);
        o.setVisible(true);
        o.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        o.setLocationRelativeTo(null);
    }

    public static void closeMainWindow() {
        o.dispose();
    }

}
