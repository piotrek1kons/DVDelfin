import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.time.LocalDate;

public class Logowanie extends JFrame {
        JButton bZaloguj;
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

        public Logowanie(){
            setSize(500,400);
            setTitle("DVDelfin");
            setLayout(null);



            lTitle = new JLabel("LOGOWANIE");
            lTitle.setBounds(200,20,100,20);
            add(lTitle);
            lTitle.setForeground(tekstLabel);

            lLogin = new JLabel("Login: ");
            lLogin.setBounds(130,50,100,20);
            add(lLogin);
            lLogin.setForeground(tekstLabel);

            tLogin = new JTextField("");
            tLogin.setBounds(230,50,100,20);
            add(tLogin);
            tLogin.setForeground(tekstForm);
            tLogin.setBackground(tloForm);

            lHaslo = new JLabel("Hasło: ");
            lHaslo.setBounds(130,75,100,20);
            add(lHaslo);
            lHaslo.setForeground(tekstLabel);

            pHaslo = new JPasswordField("");
            pHaslo.setBounds(230,75,100,20);
            add(pHaslo);
            pHaslo.setForeground(tekstForm);
            pHaslo.setBackground(tloForm);

            bZaloguj = new JButton("Zarejestruj");
            bZaloguj.setBounds(200,300,100,20);
            add(bZaloguj);
            bZaloguj.setBackground(tloButton);
            bZaloguj.setForeground(tekstForm);
            bZaloguj.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Object zrodlo = e.getSource();
                    login = tLogin.getText();
                    haslo = pHaslo.getPassword();

                    BazaDanych b = new BazaDanych();
                    char[] hasloUzytkownika = {' '};
                    int indexUzytkownika;
                    String[][] daneUzytkownika;

                    try{
                        daneUzytkownika = b.odczytZPliku(9,nazwaPliku);
                        indexUzytkownika = b.znajdzIndex(daneUzytkownika,login);

                        if(zrodlo == bZaloguj){
                            if(login.isEmpty()){
                                lKomunikat.setText("Pole Login jest puste");
                            }else if(!isEqual(haslo,hasloUzytkownika) || indexUzytkownika == -1) {
                                lKomunikat.setText("Niepoprawny login lub hasło");
                            }else{
                                lKomunikat.setText("Dane poprawne. Następuje logowanie");
                            }


                        }

                    }catch(Exception ex){
                        System.out.println(ex);
                    }
                }
            });

            lKomunikat = new JLabel("");
            lKomunikat.setBounds(130,325,200,20);
            add(lKomunikat);
            lKomunikat.setForeground(tekstLabel);

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
