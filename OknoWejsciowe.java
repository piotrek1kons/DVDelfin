import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OknoWejsciowe extends JFrame{
    private JPanel panelStartowy;
    private JButton BottonOpcjaLogowanie;
    private JButton BottonOpcjaRejestracja;

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
                JOptionPane.showMessageDialog(BottonOpcjaRejestracja,"Wybrałeś rejestracje");
            }
        });
    }

    public static void main(String[] args) {
        OknoWejsciowe o = new OknoWejsciowe();
        o.setContentPane(o.panelStartowy);
        o.setTitle("DVDelfin - Start");
        o.setSize(300,400);
        o.setVisible(true);
        o.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
