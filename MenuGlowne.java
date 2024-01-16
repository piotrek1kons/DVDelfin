import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

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

    public MenuGlowne(Klient klient){
        buttonWypozyczFilm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(buttonWypozyczFilm,"Wybrałeś wypozyczenie filmu");
                klient.wypozyczFilm();
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
                klient.wyswietlWypozyczoneFilmy();
            }
        });
        buttonUstawienia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(buttonUstawienia,"Wybrałeś ustawienia");
                klient.ustawienia();

            }
        });
        buttonWyloguj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(buttonWyloguj,"Wybrałeś wylogowanie");

            }
        });

        buttonWyloguj.addActionListener(e -> Logowanie.closeMenuWindow());
        buttonWyloguj.addActionListener(e -> {
            Main.main(null);
        });

    }
}
