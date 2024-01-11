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

    JButton bPowrot;
    JLabel lTitle,lPustaTablica;

    Color tekstLabel = new Color(15, 29, 68);
    Color tekstForm = new Color(248, 249, 241);
    Color tloForm = new Color(234, 158, 156);
    Color tloButton = new Color(5, 166, 218);

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
        if (wypozyczoneFilmy.size() != 0){
            rozmiarOkna();
            przyciskPowrotu();
            setTytul("Wypożyczone Filmy");
            int rozmiar = wypozyczoneFilmy.size();

            JPanel galleryPanel = new JPanel(new GridLayout(0, 2, 10, 10));
            int index;

            for (int i=0; i<rozmiar; i++){
                JButton imageButton = new JButton();
                index = b.znajdzIndex(wszystkieFilmy, wypozyczoneFilmy.elementAt(i));

                ImageIcon icon = resizeImage("filmy/"+wszystkieFilmy[index][1],240,480);
                imageButton.setIcon(icon);
                galleryPanel.add(imageButton);
            }

            // scrollowanie
            JScrollPane scrollPane = new JScrollPane(galleryPanel);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

            add(galleryPanel);

        }else{
            lPustaTablica = new JLabel("Brak wypożyczonych filmów");
            lPustaTablica.setBounds(130,150,100,20);
            add(lPustaTablica);
            lPustaTablica.setForeground(tekstLabel);
        }


    }
    public void zarzadzajFilmami(){
        rozmiarOkna();
        przyciskPowrotu();
        setTytul("Zarządzanie Filmami");
    }
    public void wypozyczFilm(){
        rozmiarOkna();
        przyciskPowrotu();
        setTytul("Wypożyczanie Filmu");
    }
    public void oddajFilm(){
        rozmiarOkna();
        przyciskPowrotu();
        setTytul("Oddaj Film");
    }
    public void ustawienia(){
        rozmiarOkna();
        przyciskPowrotu();
        setTytul("Ustawienia");
    }

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
    }

    private void pobierzBazeFilmow() throws FileNotFoundException {
        try{
            wszystkieFilmy = b.odczytZPliku(2, wszystkieFilmyPath);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    private static ImageIcon resizeImage(String imagePath, int width, int height) {
        try {
            File file = new File(imagePath);
            BufferedImage originalImage = ImageIO.read(file);
            Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImage);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}
