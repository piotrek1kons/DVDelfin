import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAdmin extends JFrame {
    private JPanel panelMenuAdmin;
    private JPanel panelTytulowy;
    private JLabel LableMenuAdmin;
    private JLabel LableLogo;
    private JButton buttonDodajFilm;
    private JButton buttonUsunFilm;
    private JButton buttonUsunUytkownika;
    private JButton buttonEdytujFilm;
    private JButton buttonWyloguj;

    static Admin admin;
    public JPanel getPanelMenuAdmin() {
        return panelMenuAdmin;
    }
    public JPanel getPanelTytulowy() {
        return panelTytulowy;
    }

    public MenuAdmin(Admin admin) {

        buttonDodajFilm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(buttonWypozyczFilm,"Wybrałeś wypozyczenie filmu");
                admin.dodajFilm();
            }
        });
        buttonUsunFilm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(buttonOddajFilm,"Wybrałeś oddanie filmu");
                admin.dodajFilm();

            }
        });
        buttonUsunUytkownika.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(buttonSprawdzWypozyczoneFilmy,"Wybrałeś sprawdzenie wypozyczonych filmów");

            }
        });
        buttonEdytujFilm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(buttonUstawienia,"Wybrałeś ustawienia");


            }
        });


        buttonWyloguj.addActionListener(e -> Logowanie.closeMenuWindow());
        buttonWyloguj.addActionListener(e -> {
            Main.main(null);
        });
    }
}
