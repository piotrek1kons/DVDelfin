import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class BazaDanych {
    public String[][] odczytZPliku(int rozmiar, String nazwaPliku) throws FileNotFoundException {

        File plik = new File(nazwaPliku);
        String[][] dane = null;
        int iloscLinii = 0;

        try{
            Scanner odczyt = new Scanner(plik);

            iloscLinii = (int)Files.lines(Paths.get(nazwaPliku)).count();

            dane = new String[iloscLinii][rozmiar];

            for (int i=0; i<iloscLinii; i++){
                dane[i]= odczyt.nextLine().split(";");
            }

        } catch (Exception e){
            System.out.println(e);
        }

        return dane;

    }

    public void zapisDoPliku(){
        // TODO ....
    }

    public int znajdzIndex(String[][] dane, String login){
        int rozmiar = dane.length;
        for (int i=0; i<rozmiar; i++){
            if (dane[i][0].equals(login)) return i;
        }

        return -1;
    }
}
