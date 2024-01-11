import java.io.*;
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

            iloscLinii = (int) Files.lines(Paths.get(nazwaPliku)).count();

            dane = new String[iloscLinii][rozmiar];

            for (int i=0; i<iloscLinii; i++){
                dane[i]= odczyt.nextLine().split(";");
            }

        } catch (Exception e){
            System.out.println(e);
        }

        return dane;

    }

    public void zapisDoPliku(String[] dane) throws IOException {
        try (FileWriter file = new FileWriter("user.txt", true);
             BufferedWriter buffor = new BufferedWriter(file)) {
                for(int i=0; i < dane.length;i++) {
                buffor.write(dane[i]);
                if (i < dane.length-1) {
                    buffor.write(";");
                }
            }
            buffor.newLine();
        }
    }

    public int znajdzIndex(String[][] dane, String login){
        if(dane == null){
            return -1;
        }else{
            int rozmiar = dane.length;
            for (int i=0; i<rozmiar; i++){
                if (dane[i][0].equals(login)) return i;
            }

        }


        return -1;
    }
}
