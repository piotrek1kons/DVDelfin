import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.Vector;

public class Admin extends Uzytkownik {
    private String[][] wszystkieFilmy;   // tytuł ; src ; reżyser ; gatunek ; czas trwania (gg:mm) ; opis
    private String wszystkieFilmyPath = "filmy.txt";  // login ; tytuł
    static EdytujFilm e;
    static WyborEdytowanegoFilmu wf;
    static DodajFilm df;
    BazaDanych b;
    public Admin(){
        super();
    }
    public Admin(String login,char[] haslo,String imie,String nazwisko,String dzien,String miesiac,String rok, String plec,String email){
        super(login,haslo,imie,nazwisko,dzien,miesiac,rok,plec,email);
        String[][] filmy;

        try{
            b = new BazaDanych();
            pobierzBazeFilmow();

        }catch(Exception e){
            System.out.println(e);
        }

    }

    public void usunFilm(){

    }
    public void edytujFilm(){
        wf = new WyborEdytowanegoFilmu(wszystkieFilmy,b,this);
        ImageIcon icon = new ImageIcon("src/logo - DVDelfin2.jpg");
        wf.setIconImage(icon.getImage());
        //wp.setContentPane(wp.getPanelWypozyczFilm());
        wf.setTitle("DVDelfin - Administrator start");
        wf.setSize(1400,getMaximumSize().height);
        wf.setVisible(true);
        Logowanie.hideMenuAdminWindow();
        wf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wf.setLocationRelativeTo(null);
    }

    public void dodajFilm(){
        df = new DodajFilm();
        ImageIcon icon = new ImageIcon("src/logo - DVDelfin2.jpg");
        df.setIconImage(icon.getImage());
        //wp.setContentPane(wp.getPanelWypozyczFilm());
        df.setTitle("DVDelfin - Administrator start");
        df.setSize(500,getMaximumSize().height);
        df.setVisible(true);
        Logowanie.hideMenuAdminWindow();
        df.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        df.setLocationRelativeTo(null);
    }

    private void pobierzBazeFilmow() throws FileNotFoundException {
        try{
            wszystkieFilmy = b.odczytZPliku(6, wszystkieFilmyPath);

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void hideWyborEdytowanegoFilmuWindow(){ wf.setVisible(false);}
    public static void showWyborEdytowanegoFilmuWindow(){ wf.setVisible(true);}

    public static void closeWyborEdytowanegoFilmuWindow(){
        wf.dispose();
        Logowanie.showMenuAdminWindow();
    }

    public static void closeDodajFilmWindow(){
        df.dispose();
        Logowanie.showMenuAdminWindow();
    }
}