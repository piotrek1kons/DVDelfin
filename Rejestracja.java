import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Locale;

public class Rejestracja extends JFrame {

    JComboBox<Integer> cbRok;
    String[] miesiace = {"Styczeń", "Luty", "Marzec", "Kwiecień", "Maj", "Czerwiec", "Lipiec", "Sierpień", "Wrzesień", "Październik", "Listopad", "Grudzień"};
    JComboBox<String> cbMiesiace;

    SpinnerNumberModel dni = new SpinnerNumberModel(1, 1, 31, 1);
    JSpinner sDzien;
    JButton bZarejestruj, bPowrot;
    JLabel lTitle,lLogin,lHaslo,lPowtorzHaslo,lImie,lNazwisko,lDataUrodzenia,lPlec,lEmail,lKomunikat;
    JPasswordField pHaslo,pPowtorzHaslo;
    JTextField tLogin,tImie,tNazwisko,tEmail,tPlec;
    JRadioButton rbKobieta, rbMezczyzna;
    ButtonGroup bgPlec;
    String imie,nazwisko,eMail,plec,login,dzien, miesiac,rok1;

    char[] haslo,powtorzHaslo;
    String[][] daneUzytkownika;
    String nazwaPliku = "user.txt";
    Color tekstLabel = new Color(15, 29, 68);
    Color tekstForm = new Color(248, 249, 241);
    Color tloForm = new Color(234, 158, 156);
    Color tloButton = new Color(5, 166, 218);


    public Rejestracja(){
        setSize(500,400);
        setTitle("DVDelfin");
        setLayout(null);

        LocalDate data = LocalDate.now();
        int poczatek = data.getYear() - 118;
        int koniec = data.getYear() - 18;

        Integer[] rok = new Integer[koniec-poczatek+1];
        for (int i = poczatek; i <= koniec; i++) {
            rok[i - poczatek] = i;
        }


        bPowrot = new JButton("<-");
        bPowrot.setBounds(10,10,45,20);
        add(bPowrot);
        bPowrot.setBackground(tloButton);
        bPowrot.setForeground(tekstForm);

        lTitle = new JLabel("REJESTRACJA");
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

        lPowtorzHaslo = new JLabel("Powtórz Hasło: ");
        lPowtorzHaslo.setBounds(130,100,100,20);
        add(lPowtorzHaslo);
        lPowtorzHaslo.setForeground(tekstLabel);

        pPowtorzHaslo = new JPasswordField("");
        pPowtorzHaslo.setBounds(230,100,100,20);
        add(pPowtorzHaslo);
        pPowtorzHaslo.setForeground(tekstForm);
        pPowtorzHaslo.setBackground(tloForm);

        lImie = new JLabel("Imię: ");
        lImie.setBounds(130, 125,100,20);
        add(lImie);
        lImie.setForeground(tekstLabel);

        tImie =  new JTextField("");
        tImie.setBounds(230,125,100,20);
        add(tImie);
        tImie.setForeground(tekstForm);
        tImie.setBackground(tloForm);

        lNazwisko = new JLabel("Nazwisko: ");
        lNazwisko.setBounds(130,150,100,20);
        add(lNazwisko);
        lNazwisko.setForeground(tekstLabel);


        tNazwisko = new JTextField("");
        tNazwisko.setBounds(230, 150,100,20);
        add(tNazwisko);
        tNazwisko.setForeground(tekstForm);
        tNazwisko.setBackground(tloForm);

        lDataUrodzenia = new JLabel("Data Urodzenia: ");
        lDataUrodzenia.setBounds(130,175,100,20);
        add(lDataUrodzenia);
        lDataUrodzenia.setForeground(tekstLabel);

        sDzien = new JSpinner(dni);
        add(sDzien);
        sDzien.setBounds(230,175,40,20);

        JComponent editor = sDzien.getEditor();
        if (editor instanceof JSpinner.DefaultEditor) {
            JFormattedTextField textField = ((JSpinner.DefaultEditor) editor).getTextField();
            textField.setBackground(tloForm);
            textField.setForeground(tekstForm);
        }


        cbMiesiace = new JComboBox<>(miesiace);
        add(cbMiesiace);
        cbMiesiace.setBounds(275,175,100,20);
        cbMiesiace.setForeground(tekstForm);
        cbMiesiace.setBackground(tloForm);

        cbRok = new JComboBox<>(rok);
        add(cbRok);
        cbRok.setBounds(380,175,70,20);
        cbRok.setForeground(tekstForm);
        cbRok.setBackground(tloForm);

        lPlec = new JLabel("Płeć: ");
        lPlec.setBounds(130,200,100,20);
        add(lPlec);
        lPlec.setForeground(tekstLabel);

        bgPlec = new ButtonGroup();
        tPlec = new JTextField("");

        rbKobieta = new JRadioButton("Kobieta", false);
        rbKobieta.setBounds(230,220,100,20);
        bgPlec.add(rbKobieta);
        add(rbKobieta);
        rbKobieta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plec = "Kobieta";
                //lKomunikat.setText(plec);
            }
        });

        rbMezczyzna = new JRadioButton("Mężczyzna", false);
        rbMezczyzna.setBounds(230,240,100,20);
        bgPlec.add(rbMezczyzna);
        add(rbMezczyzna);
        rbMezczyzna.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plec = "Mężczyzna";
                //lKomunikat.setText(plec);
            }
        });

        lEmail = new JLabel("E-mail: ");
        lEmail.setBounds(130,265,100,20);
        add(lEmail);
        lEmail.setForeground(tekstLabel);

        tEmail = new JTextField("");
        tEmail.setBounds(230,265,100,20);
        add(tEmail);
        tEmail.setForeground(tekstForm);
        tEmail.setBackground(tloForm);

        bZarejestruj = new JButton("Zarejestruj");
        bZarejestruj.setBounds(200,300,100,20);
        add(bZarejestruj);
        bZarejestruj.setBackground(tloButton);
        bZarejestruj.setForeground(tekstForm);

        lKomunikat = new JLabel("");
        lKomunikat.setBounds(130,325,200,20);
        add(lKomunikat);
        lKomunikat.setForeground(tekstLabel);




        bZarejestruj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] dane = new String[9];
                login = tLogin.getText();
                imie = tImie.getText();
                nazwisko = tNazwisko.getText();
                haslo = pHaslo.getPassword();
                powtorzHaslo = pPowtorzHaslo.getPassword();
                dzien = sDzien.getValue().toString();
                String wybranyMiesiac = (String) cbMiesiace.getSelectedItem();
                miesiac = konwertujMiesiac(wybranyMiesiac);
                rok1 = cbRok.getSelectedItem().toString();

                eMail = tEmail.getText();


                BazaDanych baza = new BazaDanych();
                int indexUzytkownika;
                try {
                    daneUzytkownika = baza.odczytZPliku(9,"user.txt");
                    indexUzytkownika = baza.znajdzIndex(daneUzytkownika,login);
                    if (login.isEmpty()) {
                        lKomunikat.setText("Pole Login jest puste");
                    } else if(indexUzytkownika != -1){
                        lKomunikat.setText("Istnieje użytkownik o takim loginie");
                    } else if (!isEqual(haslo, powtorzHaslo)) {
                        lKomunikat.setText("Podane hasła różnią się od siebie.");
                    } else if (imie.isEmpty()) {
                        lKomunikat.setText("Pole Imię jest puste");
                    } else if (nazwisko.isEmpty()) {
                        lKomunikat.setText("Pole Nazwisko jest puste");
                    } else if (!rbMezczyzna.isSelected() && !rbKobieta.isSelected()) {
                        lKomunikat.setText("Wybierz Płeć");
                    } else if (!czyMailPoprawny(eMail)) {
                        lKomunikat.setText("Błędny adres E-Mail");
                    } else {
                        dane[0]= login;
                        dane[1]= new String(haslo);
                        dane[2]= imie;
                        dane[3]= nazwisko;
                        dane[4]= dzien;
                        dane[5]= miesiac;
                        dane[6]= rok1;
                        dane[7]= plec;
                        dane[8]= eMail;
                        try {
                            baza.zapisDoPliku(dane);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        lKomunikat.setText("Dane poprawne");
                    }
                } catch (FileNotFoundException ex) {
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

    public String konwertujMiesiac(String miesiac){
        switch (miesiac){
            case "Styczeń":
                return "1";
            case "Luty":
                return "2";
            case "Marzec":
                return "3";
            case "Kwiecień":
                return "4";
            case "Maj":
                return "5";
            case "Czerwiec":
                return "6";
            case "Lipiec":
                return "7";
            case "Sierpień":
                return "8";
            case "Wrzesień":
                return "9";
            case "Październik":
                return "10";
            case "Listopad":
                return "11";
            case "Grudzień":
                return "12";
        }
        return "";
    }

}
