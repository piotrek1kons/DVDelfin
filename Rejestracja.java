import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Rejestracja extends JFrame implements ActionListener {

    JButton bZarejestruj;
    JLabel lTitle,lLogin,lHaslo,lPowtorzHaslo,lImie,lNazwisko,lPlec,lEmail,lKomunikat;
    JPasswordField pHaslo,pPowtorzHaslo;
    JTextField tLogin,tImie,tNazwisko,tEmail,tPlec;
    JRadioButton rbKobieta, rbMezczyzna;
    ButtonGroup bgPlec;
    String imie,nazwisko,eMail,plec,login;

    char[] haslo,powtorzHaslo;

    Color tekstLabel = new Color(15, 29, 68);
    Color tekstForm = new Color(248, 249, 241);
    Color tloForm = new Color(234, 158, 156);
    Color tloButton = new Color(5, 166, 218);
    public Rejestracja(){
        setSize(500,400);
        setTitle("DVDelfin");
        setLayout(null);

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

        lPlec = new JLabel("Płeć: ");
        lPlec.setBounds(130,175,100,20);
        add(lPlec);
        lPlec.setForeground(tekstLabel);

        bgPlec = new ButtonGroup();
        tPlec = new JTextField("");

        rbKobieta = new JRadioButton("Kobieta", false);
        rbKobieta.setBounds(230,200,100,20);
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
        rbMezczyzna.setBounds(230,220,100,20);
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
        lEmail.setBounds(130,245,100,20);
        add(lEmail);
        lEmail.setForeground(tekstLabel);

        tEmail = new JTextField("");
        tEmail.setBounds(230,245,100,20);
        add(tEmail);
        tEmail.setForeground(tekstForm);
        tEmail.setBackground(tloForm);

        bZarejestruj = new JButton("Zarejestruj");
        bZarejestruj.setBounds(200,280,100,20);
        add(bZarejestruj);
        bZarejestruj.setBackground(tloButton);
        bZarejestruj.setForeground(tekstForm);
        bZarejestruj.addActionListener(this);


        lKomunikat = new JLabel("");
        lKomunikat.setBounds(130,305,200,20);
        add(lKomunikat);
        lKomunikat.setForeground(tekstLabel);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        Object zrodlo = e.getSource();
        login = tLogin.getText();
        imie = tImie.getText();
        nazwisko = tNazwisko.getText();
        haslo = pHaslo.getPassword();
        powtorzHaslo =pPowtorzHaslo.getPassword();
        eMail = tEmail.getText();
        if(zrodlo == bZarejestruj){
            if(login.isEmpty()){
                lKomunikat.setText("Pole Login jest puste");
            }else if(!isEqual(haslo,powtorzHaslo)) {
                lKomunikat.setText("Podane hasła różnią się od siebie.");
            }else if(imie.isEmpty()){
                lKomunikat.setText("Pole Imię jest puste");
            } else if (nazwisko.isEmpty()) {
                lKomunikat.setText("Pole Nazwisko jest puste");
            } else if(!rbMezczyzna.isSelected() && !rbKobieta.isSelected()){
                lKomunikat.setText("Wybierz Płeć");
            }else if(!czyMailPoprawny(eMail)) {
                lKomunikat.setText("Błędny adres E-Mail");
            }else{
                lKomunikat.setText("Dane poprawne");
            }


        }

    }
}
