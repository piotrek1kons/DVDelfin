import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.Vector;

public class Admin extends Uzytkownik {
    private String[][] wszystkieFilmy;   // tytuł ; src ; reżyser ; gatunek ; czas trwania (gg:mm) ; opis
    private String wszystkieFilmyPath = "filmy.txt";  // login ; tytuł
    static EdytujFilm e;
    static WyborEdytowanegoFilmu wf;
    static UsunFilm uf;
    static DodajFilm df;
    static UsunUzytkownika uu;
    static MenuAdmin a;
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

    public void otworzPanel(){
        a = new MenuAdmin(this);
        ImageIcon icon = new ImageIcon("src/logo - DVDelfin2.jpg");
        a.setIconImage(icon.getImage());
        a.setContentPane(a.getPanelMenuAdmin());
        a.setTitle("DVDelfin - Start");
        a.setSize(300,600);
        a.setVisible(true);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setLocationRelativeTo(null);
    }

    public void usunFilm() throws FileNotFoundException {
        uf = new UsunFilm();
        ImageIcon icon = new ImageIcon("src/logo - DVDelfin2.jpg");
        uf.setIconImage(icon.getImage());
        //wp.setContentPane(wp.getPanelWypozyczFilm());
        uf.setTitle("DVDelfin - Administrator start");
        uf.setSize(1400,getMaximumSize().height);
        uf.setVisible(true);
        hideMenuAdminWindow();
        uf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        uf.setLocationRelativeTo(null);
    }
    public void edytujFilm(){
        wf = new WyborEdytowanegoFilmu(wszystkieFilmy,b,this);
        ImageIcon icon = new ImageIcon("src/logo - DVDelfin2.jpg");
        wf.setIconImage(icon.getImage());
        //wp.setContentPane(wp.getPanelWypozyczFilm());
        wf.setTitle("DVDelfin - Administrator start");
        wf.setSize(1400,getMaximumSize().height);
        wf.setVisible(true);
        hideMenuAdminWindow();
        wf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wf.setLocationRelativeTo(null);
    }

    public void dodajFilm(){
        df = new DodajFilm();
        ImageIcon icon = new ImageIcon("src/logo - DVDelfin2.jpg");
        df.setIconImage(icon.getImage());
        //wp.setContentPane(wp.getPanelWypozyczFilm());
        df.setTitle("DVDelfin - Administrator start");
        df.setSize(500,400);
        df.setVisible(true);
        hideMenuAdminWindow();
        df.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        df.setLocationRelativeTo(null);
    }

    public void usunUzytkownika() throws FileNotFoundException {
        uu = new UsunUzytkownika();
        ImageIcon icon = new ImageIcon("src/logo - DVDelfin2.jpg");
        uu.setIconImage(icon.getImage());
        //wp.setContentPane(wp.getPanelWypozyczFilm());
        uu.setTitle("DVDelfin - Administrator start");
        uu.setSize(500,400);
        uu.setVisible(true);
        hideMenuAdminWindow();
        uu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        uu.setLocationRelativeTo(null);
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
    public static void closeUsunUzytkownikaWindow(){
        uu.dispose();
        showMenuAdminWindow();
    };

    public static void closeUsunFilmWindow(){
        uf.dispose();
        showMenuAdminWindow();
    };


    public static void closeWyborEdytowanegoFilmuWindow(){
        wf.dispose();
        showMenuAdminWindow();
    }

    public static void closeDodajFilmWindow(){
        df.dispose();
        showMenuAdminWindow();
    }

    public static void hideMenuAdminWindow(){ a.setVisible(false);}
    public static void showMenuAdminWindow(){ a.setVisible(true);}
    public static void closeMenuAdminWindow() {
        a.dispose();
    }
}