import java.util.Vector;

public class Klient extends Uzytkownik {
    private Vector<String> wypozyczoneFilmy;
    public Klient(){
        super();
    }
    public Klient(String login,char[] haslo,String imie,String nazwisko,String dzien,String miesiac,String rok, String plec,String email){
        super(login,haslo,imie,nazwisko,dzien,miesiac,rok,plec,email);
        this.wypozyczoneFilmy = new Vector<String>();
    }

    public void wyswietlWypozyczoneFilmy(){
        // TODO ....
    }
    public void zarzadzajFilmami(){
        // TODO ....
    }



}
