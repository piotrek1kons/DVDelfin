import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MenuGlowne extends JFrame {
    private JPanel panelGlowny;
    private JPanel panelTytulowy;
    private JButton buttonWypozyczFilm;
    private JButton buttonSprawdzWypozyczoneFilmy;
    private JButton buttonUstawienia;
    private JButton buttonWyloguj;
    String login;
    BazaDanych b = new BazaDanych();
    static Klient klient;

    public JPanel getPanelMenuGlownego() {
        return panelGlowny;
    }
    public JPanel getPanelTytulowy() {
        return panelTytulowy;
    }

    public MenuGlowne(Klient klient){
        login = klient.getLogin();
        buttonWypozyczFilm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(buttonWypozyczFilm,"Wybrałeś wypozyczenie filmu");
                klient.wypozyczFilm();
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


        buttonWyloguj.addActionListener(e -> Klient.closeMenuWindow());
        buttonWyloguj.addActionListener(e -> {
            Main.main(null);
            try {
                b.log("Wylogowano użytkownika: " + login);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

    }
}