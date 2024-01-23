import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

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

    BazaDanych b = new BazaDanych();
    String login;
    static Admin admin;
    public JPanel getPanelMenuAdmin() {
        return panelMenuAdmin;
    }
    public JPanel getPanelTytulowy() {
        return panelTytulowy;
    }

    public MenuAdmin(Admin admin) {
        login = admin.getLogin();
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
                try {
                    admin.usunFilm();
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        buttonUsunUytkownika.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(buttonSprawdzWypozyczoneFilmy,"Wybrałeś sprawdzenie wypozyczonych filmów");
                try {
                    admin.usunUzytkownika();
                    Admin.hideMenuAdminWindow();
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        buttonEdytujFilm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(buttonUstawienia,"Wybrałeś ustawienia");
                admin.edytujFilm();


            }
        });


        buttonWyloguj.addActionListener(e -> Admin.closeMenuAdminWindow());
        buttonWyloguj.addActionListener(e -> {
            Main.main(null);
            try {
                b.log("Wylogowano użytkownika: " +login);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
