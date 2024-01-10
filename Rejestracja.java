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

    public OknoWejsciowe() {
        BottonOpcjaLogowanie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(BottonOpcjaLogowanie,"Wybrałeś logowanie");
            }
        });
        BottonOpcjaRejestracja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Rejestracja rejestracja = new Rejestracja();
                ImageIcon icon = new ImageIcon("src/logo - DVDelfin2.jpg");
                rejestracja.setIconImage(icon.getImage());
                rejestracja.setBackground(new Color(248, 249, 241));
                rejestracja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                rejestracja.setVisible(true);
                rejestracja.setLocationRelativeTo(null);
                //JOptionPane.showMessageDialog(BottonOpcjaRejestracja,"Wybrałeś rejestracje");
            }
        });

        BottonOpcjaRejestracja.addActionListener(e -> Main.closeMainWindow());
    }
}
