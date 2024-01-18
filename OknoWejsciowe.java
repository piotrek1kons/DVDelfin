import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OknoWejsciowe extends JFrame {

    private JPanel panelStartowy;
    private JButton BottonOpcjaLogowanie;
    private JButton BottonOpcjaRejestracja;

    public JPanel getPanelStartowy() {
        return panelStartowy;
    }

    static Rejestracja rejestracja;
    static Logowanie logowanie;
    public OknoWejsciowe() {
        BottonOpcjaLogowanie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(BottonOpcjaLogowanie,"Wybrałeś logowanie");
                logowanie = new Logowanie();
                ImageIcon icon = new ImageIcon("src/logo - DVDelfin2.jpg");
                logowanie.setIconImage(icon.getImage());
                logowanie.setBackground(new Color(248, 249, 241));
                logowanie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                logowanie.setVisible(true);
                logowanie.setLocationRelativeTo(null);
            }
        });
        BottonOpcjaRejestracja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                rejestracja = new Rejestracja();
                ImageIcon icon = new ImageIcon("src/logo - DVDelfin2.jpg");
                rejestracja.setIconImage(icon.getImage());
                rejestracja.setBackground(new Color(248, 249, 241));
                rejestracja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                rejestracja.setVisible(true);
                rejestracja.setLocationRelativeTo(null);
            }
        });

        BottonOpcjaRejestracja.addActionListener(e -> Main.closeMainWindow());
        BottonOpcjaLogowanie.addActionListener(e -> Main.closeMainWindow());


    }
    public static void closeRejestracjaWindow(){
        rejestracja.dispose();
    }
    public static void closeLogowanieWindow(){
        logowanie.dispose();
    }
}