import javax.swing.*;

public class Main extends JFrame{
    static OknoWejsciowe o;

    public static void main(String[] args) {
        o = new OknoWejsciowe();
        o.setContentPane(o.getPanelStartowy());
        o.setTitle("DVDelfin - Start");
        o.setSize(300,400);
        o.setVisible(true);
        o.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        o.setLocationRelativeTo(null);
    }

    public static void closeMainWindow() {
        o.dispose();
    }

}
