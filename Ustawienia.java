import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ustawienia extends JFrame {
    JButton bPowrot, bZapisz;
    JLabel lTitle,lImie,lNazwisko,lStareHaslo,lNoweHaslo,lEmail,lKomunikat;
    JPasswordField pStareHaslo, pNoweHaslo;
    JTextField tImie,tNazwisko,tEmail;
    String imie,nazwisko,email;
    char[] stareHaslo, noweHaslo;
    String[][] daneUzytkownika;
    String nazwaPliku = "user.txt";

    private JPanel panelUstawienia;
    public JPanel getPanelUstawienia() {
        return panelUstawienia;
    }

    Color tekstLabel = new Color(15, 29, 68);
    Color tekstForm = new Color(248, 249, 241);
    Color tloForm = new Color(234, 158, 156);
    Color tloButton = new Color(5, 166, 218);

    public Ustawienia(Klient klient){
        setSize(500,400);
        setTitle("DVDelfin");
        setLayout(null);

        bPowrot = new JButton("<-");
        bPowrot.setBounds(10,10,45,20);
        add(bPowrot);
        bPowrot.setBackground(tloButton);
        bPowrot.setForeground(tekstForm);

        lTitle = new JLabel("Ustawienia");
        lTitle.setBounds(200,20,100,20);
        add(lTitle);
        lTitle.setForeground(tekstLabel);

        // ZMIANA IMIENIA
        lImie = new JLabel("Imie:\t");
        lImie.setBounds(130,80,100,20);
        add(lImie);
        lImie.setForeground(tekstLabel);

        tImie =  new JTextField("");
        tImie.setBounds(230,80,100,20);
        add(tImie);
        tImie.setForeground(tekstForm);
        tImie.setBackground(tloForm);

        // ZMIANA NAZWISKA
        lNazwisko = new JLabel("Nazwisko:\t");
        lNazwisko.setBounds(130,110,100,20);
        add(lNazwisko);
        lNazwisko.setForeground(tekstLabel);

        tNazwisko = new JTextField("");
        tNazwisko.setBounds(230, 110,100,20);
        add(tNazwisko);
        tNazwisko.setForeground(tekstForm);
        tNazwisko.setBackground(tloForm);

        // ZMIANA HASŁA
        lStareHaslo = new JLabel("Stare hasło:\t");
        lStareHaslo.setBounds(130,140,100,20);
        add(lStareHaslo);
        lStareHaslo.setForeground(tekstLabel);

        pStareHaslo = new JPasswordField("");
        pStareHaslo.setBounds(230,140,100,20);
        add(pStareHaslo);
        pStareHaslo.setForeground(tekstForm);
        pStareHaslo.setBackground(tloForm);

        lNoweHaslo = new JLabel("Nowe hasło:\t");
        lNoweHaslo.setBounds(130,170,100,20);
        add(lNoweHaslo);
        lNoweHaslo.setForeground(tekstLabel);

        pNoweHaslo = new JPasswordField("");
        pNoweHaslo.setBounds(230,170,100,20);
        add(pNoweHaslo);
        pNoweHaslo.setForeground(tekstForm);
        pNoweHaslo.setBackground(tloForm);

        // ZMIANA MAILA
        lEmail = new JLabel("Email:\t");
        lEmail.setBounds(130,200,100,20);
        add(lEmail);
        lEmail.setForeground(tekstLabel);

        tEmail = new JTextField("");
        tEmail.setBounds(230,200,100,20);
        add(tEmail);
        tEmail.setForeground(tekstForm);
        tEmail.setBackground(tloForm);

        bZapisz = new JButton("Zapisz zmiany");
        bZapisz.setBounds(200,230,100,20);
        add(bZapisz);
        bZapisz.setBackground(tloButton);
        bZapisz.setForeground(tekstForm);

        lKomunikat = new JLabel("");
        lKomunikat.setBounds(130,260,200,20);
        add(lKomunikat);
        lKomunikat.setForeground(tekstLabel);

        bZapisz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //String[] dane = new String[4];
                imie = tImie.getText();
                nazwisko = tNazwisko.getText();
                stareHaslo = pStareHaslo.getPassword();
                noweHaslo = pNoweHaslo.getPassword();
                email = tEmail.getText();


                BazaDanych baza = new BazaDanych();
                int indexUzytkownika;
                try {

                    daneUzytkownika = baza.odczytZPliku(9,"user.txt");
                    indexUzytkownika = baza.znajdzIndex(daneUzytkownika,klient.getLogin());

                    if (!imie.isEmpty()) {
                        klient.setImie(imie);
                        daneUzytkownika[indexUzytkownika][2] = imie;
                    }

                    if (!nazwisko.isEmpty()) {
                        klient.setNazwisko(nazwisko);
                        daneUzytkownika[indexUzytkownika][3]= nazwisko;
                    }

                    if (!noweHaslo.toString().isEmpty()  && isEqual(stareHaslo, noweHaslo)) {
                        klient.setHaslo(noweHaslo);
                        daneUzytkownika[indexUzytkownika][1]= new String(noweHaslo);
                    }

                    if (!email.isEmpty() && !czyMailPoprawny(email)) {
                        klient.setEmail(email);
                        daneUzytkownika[indexUzytkownika][8]= email;
                    }

                    baza.zastapPlik(daneUzytkownika,nazwaPliku);

                    lKomunikat.setText("Zapisano zmiany");

                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        bPowrot.addActionListener(e -> OknoWejsciowe.closeRejestracjaWindow());
        bPowrot.addActionListener(e -> Main.main(null));


    }

    public static boolean czyMailPoprawny(String eMail){
        return eMail.matches("(\\w+)(\\.|_)?(\\w*)@(\\w+)(\\.(\\w+))+");
    }
    boolean isEqual(char[] password1, char[] password2) {
        if (password1.length != password2.length || password1.length == 0 ) {
            return false;
        }

        for (int i = 0; i < password1.length; i++) {
            if (password1[i] != password2[i]) {
                return false;
            }
        }

        return true;
    }
}
