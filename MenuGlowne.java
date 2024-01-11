import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGlowne extends JFrame {
    private JPanel panelGlowny;
    private JPanel panelTytulowy;
    private JButton buttonWypozyczFilm;
    private JButton buttonOddajFilm;
    private JButton buttonSprawdzWypozyczoneFilmy;
    private JButton buttonUstawienia;
    private JButton buttonWyloguj;

    static Klient klient;

    public JPanel getPanelMenuGlownego() {
        return panelGlowny;
    }
    public JPanel getPanelTytulowy() {
        return panelTytulowy;
    }

    public MenuGlowne(){
        buttonWypozyczFilm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(buttonWypozyczFilm,"Wybrałeś wypozyczenie filmu");

            }
        });
        buttonOddajFilm.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //JOptionPane.showMessageDialog(buttonOddajFilm,"Wybrałeś oddanie filmu");


                }
            });
        buttonSprawdzWypozyczoneFilmy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(buttonSprawdzWypozyczoneFilmy,"Wybrałeś sprawdzenie wypozyczonych filmów");
                klient = new Klient();
                ImageIcon icon = new ImageIcon("src/logo - DVDelfin2.jpg");
                klient.setIconImage(icon.getImage());
                klient.setBackground(new Color(248, 249, 241));
                klient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                klient.setVisible(true);
                klient.setLocationRelativeTo(null);
                // klient.wyswietlWypozyczoneFilmy(); ??????
            }
        });
        buttonUstawienia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(buttonUstawienia,"Wybrałeś ustawienia");

            }
        });
        buttonWyloguj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(buttonWyloguj,"Wybrałeś wylogowanie");

            }
        });

        buttonWyloguj.addActionListener(e -> Logowanie.closeMenuWindow());
        buttonWyloguj.addActionListener(e -> Main.main(null));

    }
}
