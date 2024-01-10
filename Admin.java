import java.util.Vector;

public class Admin extends Uzytkownik {
    public Admin(){
        super();
    }
    public Admin(String login,char[] haslo,String imie,String nazwisko,String dzien,String miesiac,String rok, String plec,String email){
        super(login,haslo,imie,nazwisko,dzien,miesiac,rok,plec,email);
    }

    public void dodajFilm(){
        // TODO ....
    }
    public void usunFilm(){
        // TODO ....
    }
    public void edytujFilm(){
        // TODO ....
    }
}
