import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.time.LocalDate;

public class Logowanie extends JFrame {
    JButton bZaloguj,bPowrot;
    JLabel lLogin,lHaslo,lTitle,lKomunikat;
    JPasswordField pHaslo;
    JTextField tLogin;
    String login;
    char[] haslo;

    Color tekstLabel = new Color(15, 29, 68);
    Color tekstForm = new Color(248, 249, 241);
    Color tloForm = new Color(234, 158, 156);
    Color tloButton = new Color(5, 166, 218);

    String nazwaPliku = "user.txt";
    String[][] daneUzytkownika;


    Uzytkownik klient;
    Uzytkownik admin;

    public Logowanie(){
        setSize(300,250);
        setTitle("DVDelfin");
        setLayout(null);

        bPowrot = new JButton("<-");
        bPowrot.setBounds(10,10,45,20);
        add(bPowrot);
        bPowrot.setBackground(tloButton);
        bPowrot.setForeground(tekstForm);

        lTitle = new JLabel("LOGOWANIE");
        lTitle.setBounds(100,50,100,20);
        add(lTitle);
        lTitle.setForeground(tekstLabel);

        lLogin = new JLabel("Login: ");
        lLogin.setBounds(60,80,70,20);
        add(lLogin);
        lLogin.setForeground(tekstLabel);

        tLogin = new JTextField("");
        tLogin.setBounds(130,80,100,20);
        add(tLogin);
        tLogin.setForeground(tekstForm);
        tLogin.setBackground(tloForm);

        lHaslo = new JLabel("Hasło: ");
        lHaslo.setBounds(60,115,70,20);
        add(lHaslo);
        lHaslo.setForeground(tekstLabel);

        pHaslo = new JPasswordField("");
        pHaslo.setBounds(130,115,100,20);
        add(pHaslo);
        pHaslo.setForeground(tekstForm);
        pHaslo.setBackground(tloForm);

        bZaloguj = new JButton("Zaloguj");
        bZaloguj.setBounds(100,150,100,20);
        add(bZaloguj);
        bZaloguj.setBackground(tloButton);
        bZaloguj.setForeground(tekstForm);

        lKomunikat = new JLabel("");
        lKomunikat.setBounds(60,170,200,20);
        add(lKomunikat);
        lKomunikat.setForeground(tekstLabel);

        bZaloguj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object zrodlo = e.getSource();
                login = tLogin.getText();
                haslo = pHaslo.getPassword();

                // inicjacja zmiennych
                BazaDanych b = new BazaDanych();
                char[] hasloUzytkownika = {' '};
                int indexUzytkownika;


                try{
                    // wyszukiwanie uzytkownika
                    daneUzytkownika = b.odczytZPliku(9,nazwaPliku);
                    indexUzytkownika = b.znajdzIndex(daneUzytkownika,login);

                    if (indexUzytkownika != -1){
                        hasloUzytkownika = daneUzytkownika[indexUzytkownika][1].toCharArray();
                    }else{
                        hasloUzytkownika = null;
                    }


                    // logowanie

                    if(login.isEmpty()){
                        lKomunikat.setText("Pole Login jest puste");
                    }else if(indexUzytkownika == -1 || !isEqual(haslo,hasloUzytkownika)) {
                        lKomunikat.setText("Niepoprawny login lub hasło");

                    }else{
                        if(daneUzytkownika[indexUzytkownika][0].equals("admin")){
                            admin = new Admin(daneUzytkownika[indexUzytkownika][0], daneUzytkownika[indexUzytkownika][1].toCharArray(),daneUzytkownika[indexUzytkownika][2],daneUzytkownika[indexUzytkownika][3],daneUzytkownika[indexUzytkownika][4],daneUzytkownika[indexUzytkownika][5],daneUzytkownika[indexUzytkownika][6],daneUzytkownika[indexUzytkownika][7],daneUzytkownika[indexUzytkownika][8]);
                            admin.otworzPanel();
                            b.log("Zalogowano użytkownika: " + daneUzytkownika[indexUzytkownika][0]);

                        }else{
                            klient = new Klient(daneUzytkownika[indexUzytkownika][0], daneUzytkownika[indexUzytkownika][1].toCharArray(),daneUzytkownika[indexUzytkownika][2],daneUzytkownika[indexUzytkownika][3],daneUzytkownika[indexUzytkownika][4],daneUzytkownika[indexUzytkownika][5],daneUzytkownika[indexUzytkownika][6],daneUzytkownika[indexUzytkownika][7],daneUzytkownika[indexUzytkownika][8]);

                            klient.otworzPanel();
                            b.log("Zalogowano użytkownika: " + daneUzytkownika[indexUzytkownika][0]);

                        }

                        OknoWejsciowe.closeLogowanieWindow();
                    }
                }catch(Exception ex){
                    System.out.println(ex);
                }
            }
        });

        bPowrot.addActionListener(e -> OknoWejsciowe.closeLogowanieWindow());
        bPowrot.addActionListener(e -> {
            Main.main(null);
        });



    }



    public boolean isEqual(char[] password1, char[] password2) {
        if (password1.length != password2.length || password1.length == 0 )
            return false;


        for (int i = 0; i < password1.length; i++) {
            if (password1[i] != password2[i])
                return false;
        }

        return true;
    }

}