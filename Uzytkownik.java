import javax.swing.*;

public abstract class Uzytkownik extends JFrame{
    private String login;
    private char[] haslo;
    private String imie;
    private String nazwisko;
    private String plec;
    private String email;
    private String dataUrodzenia;

    public Uzytkownik(){
        dataUrodzenia = (new Object(){
            String dzienObj = "01";
            String miesiacObj = "01";
            String rokObj = "1900";


            public String toString(){
                return dzienObj + "." + miesiacObj + "." + rokObj;
            }
        }).toString();

        this.login = null;
        this.haslo = null;
        this.imie = null;
        this.nazwisko = null;
        this.plec = null;
        this.email = null;
    }
    public Uzytkownik(String login,char[] haslo,String imie,String nazwisko,String dzien,String miesiac,String rok, String plec,String email){
        dataUrodzenia = (new Object(){
            String dzienObj = dzien;
            String miesiacObj = miesiac;
            String rokObj = rok;


            public String toString(){
                return dzienObj + "." + miesiacObj + "." + rokObj;
            }
        }).toString();

        this.login = login;
        this.haslo = haslo;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.plec = plec;
        this.email = email;
    }

    public void otworzPanel(){
        System.out.println("Otwiera panel");
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
        return dataUrodzenia.toString();
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
        this.dataUrodzenia = (new Object(){
            String dzienObj = dzien;
            String miesiacObj = miesiac;
            String rokObj = rok;


            public String toString(){
                return dzienObj + "." + miesiacObj + "." + rokObj;
            }
        }).toString();
    }
    public void setPlec(String plec) {
        this.plec = plec;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}