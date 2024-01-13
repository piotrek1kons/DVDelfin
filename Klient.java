import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Vector;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

public class Klient extends Uzytkownik {
    private Vector<String> wypozyczoneFilmy;  // tytuły
    private String[][] wszystkieFilmy;   // tytuł ; src ; reżyser ; gatunek ; czas trwania (gg:mm) ; opis
    private String pozyczoneFilmyPath = "wypozyczone_filmy.txt";
    private String wszystkieFilmyPath = "filmy.txt";  // login ; tytuł
    BazaDanych b;

    public Klient(){
        super();
    }
    public Klient(String login,char[] haslo,String imie,String nazwisko,String dzien,String miesiac,String rok, String plec,String email) throws FileNotFoundException {
        super(login,haslo,imie,nazwisko,dzien,miesiac,rok,plec,email);
        this.wypozyczoneFilmy = new Vector<String>();
        String[][] filmy;

        try{
            b = new BazaDanych();
            filmy = b.odczytZPliku(2, pozyczoneFilmyPath);
            for (int i=0; i<filmy.length; i++){
                if (filmy[i][0].equals(login)){
                    wypozyczoneFilmy.addElement(filmy[i][1]);
                }
            }

            pobierzBazeFilmow();

        }catch(Exception e){
            System.out.println(e);
        }

    }

    public void wyswietlWypozyczoneFilmy(){

        GaleriaWypozyczonych galeria = new GaleriaWypozyczonych(wypozyczoneFilmy,wszystkieFilmy,b);
        ImageIcon icon = new ImageIcon("src/logo - DVDelfin2.jpg");
        galeria.setIconImage(icon.getImage());
        galeria.setContentPane(galeria.getPanelGaleriaWypozyczen());
        galeria.setTitle("DVDelfin - Start");
        galeria.setSize(300,500);
        galeria.setVisible(true);
        galeria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        galeria.setLocationRelativeTo(null);


    }
    public void zarzadzajFilmami(){
        //rozmiarOkna();
        //przyciskPowrotu();
        //setTytul("Zarządzanie Filmami");
    }
    public void wypozyczFilm(){
        WypozyczFilm wp = new WypozyczFilm();
        ImageIcon icon = new ImageIcon("src/logo - DVDelfin2.jpg");
        wp.setIconImage(icon.getImage());
        wp.setContentPane(wp.getPanelWypozyczFilm());
        wp.setTitle("DVDelfin - Start");
        wp.setSize(300,500);
        wp.setVisible(true);
        wp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wp.setLocationRelativeTo(null);
    }
    public void oddajFilm(){
        //rozmiarOkna();
        //przyciskPowrotu();
       // setTytul("Oddaj Film");
    }
    public void ustawienia(){
        //rozmiarOkna();
       // przyciskPowrotu();
        //setTytul("Ustawienia");
    }
/*
    private void rozmiarOkna(){
        setSize(500,400);
        setTitle("DVDelfin");
        setLayout(null);
    }
    private void przyciskPowrotu(){
        bPowrot = new JButton("<-");
        bPowrot.setBounds(10,10,45,20);
        add(bPowrot);
        bPowrot.setBackground(tloButton);
        bPowrot.setForeground(tekstForm);
    }
    private void setTytul(String tytul){
        lTitle = new JLabel(tytul);
        lTitle.setBounds(200,20,100,20);
        add(lTitle);
        lTitle.setForeground(tekstLabel);
    } */

    private void pobierzBazeFilmow() throws FileNotFoundException {
        try{
            wszystkieFilmy = b.odczytZPliku(6, wszystkieFilmyPath);
        }catch(Exception e){
            System.out.println(e);
        }
    }




}
