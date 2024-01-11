import javax.swing.*;

public class Uzytkownik extends JFrame{
    private String login;
    private char[] haslo;
    private String imie;
    private String nazwisko;
    private String dataUrodzenia;
    private String plec;
    private String email;

    public Uzytkownik(){
        this.login = null;
        this.haslo = null;
        this.imie = null;
        this.nazwisko = null;
        this.dataUrodzenia = null;
        this.plec = null;
        this.email = null;
    }
    public Uzytkownik(String login,char[] haslo,String imie,String nazwisko,String dzien,String miesiac,String rok, String plec,String email){
        this.login = login;
        this.haslo = haslo;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dzien + "." + miesiac + "." + rok;
        this.plec = plec;
        this.email = email;
    }

    public void wyswietlProfil(){
        // TODO wyswietlanie profilu
    }
    public void edytujProfil(){
        // TODO edytowanie profilu
    }

    // GETTERY I SETTERY
    public String getLogin() {
        return login;
    }
    public char[] getHaslo() {
        return haslo;
    }
    public String getImie() {
        return imie;
    }
    public String getNazwisko() {
        return nazwisko;
    }
    public String getDataUrodzenia() {
        return dataUrodzenia;
    }
    public String getPlec() {
        return plec;
    }
    public String getEmail() {
        return email;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setHaslo(char[] haslo) {
        this.haslo = haslo;
    }
    public void setImie(String imie) {
        this.imie = imie;
    }
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    public void setDataUrodzenia(String dzien, String miesiac, String rok) {
        this.dataUrodzenia = dzien + "." + miesiac + "." + rok;
    }
    public void setPlec(String plec) {
        this.plec = plec;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
