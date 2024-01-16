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
    static MenuGlowne m;
    Klient klient;

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
        lKomunikat.setBounds(30,55,200,20);
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
                    hasloUzytkownika = daneUzytkownika[indexUzytkownika][1].toCharArray();

                    // logowanie

                    if(login.isEmpty()){
                        lKomunikat.setText("Pole Login jest puste");
                    }else if(indexUzytkownika == -1 || !isEqual(haslo,hasloUzytkownika)) {
                        lKomunikat.setText("Niepoprawny login lub hasło");
                    }else{
                        klient = new Klient(daneUzytkownika[indexUzytkownika][0], daneUzytkownika[indexUzytkownika][1].toCharArray(),daneUzytkownika[indexUzytkownika][2],daneUzytkownika[indexUzytkownika][3],daneUzytkownika[indexUzytkownika][4],daneUzytkownika[indexUzytkownika][5],daneUzytkownika[indexUzytkownika][6],daneUzytkownika[indexUzytkownika][7],daneUzytkownika[indexUzytkownika][8]);

                        m = new MenuGlowne(klient);
                        ImageIcon icon = new ImageIcon("src/logo - DVDelfin2.jpg");
                        m.setIconImage(icon.getImage());
                        m.setContentPane(m.getPanelMenuGlownego());
                        m.setTitle("DVDelfin - Start");
                        m.setSize(300,600);
                        m.setVisible(true);
                        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        m.setLocationRelativeTo(null);
                        lKomunikat.setText("Dane poprawne. Następuje logowanie");
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
        bZaloguj.addActionListener(e -> OknoWejsciowe.closeLogowanieWindow());


    }

    public static void hideMenuWindow(){ m.setVisible(false);}
    public static void showMenuWindow(){ m.setVisible(true);}
    public static void closeMenuWindow() {
        m.dispose();
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
