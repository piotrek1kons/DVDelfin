import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Vector;

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

    public void zapisDoPliku(String[] dane, String path) throws IOException {
        try (FileWriter file = new FileWriter(path, true);
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

    public void zastapPlik(String[][] dane, String path) throws IOException {
        try (FileWriter file = new FileWriter(path, false);
             BufferedWriter buffor = new BufferedWriter(file)) {
            for(int i=0; i < dane.length;i++) {
                for (int j=0; j < dane[i].length; j++){
                    buffor.write(dane[i][j]);
                    if (j < dane[i].length-1) {
                        buffor.write(";");
                    }else {
                        buffor.newLine();
                    }
                }

            }
        }
    }

    public int znajdzIndex(String[][] dane, String nazwa){
        if(dane == null){
            return -1;
        }else{
            int rozmiar = dane.length;
            for (int i=0; i<rozmiar; i++){
                if (dane[i][0].equals(nazwa)) return i;
            }

        }


        return -1;
    }

    public int znajdzIndex(String[][] dane, String nazwa, int pozycja){
        if(dane == null){
            return -1;
        }else{
            int rozmiar = dane.length;
            for (int i=0; i<rozmiar; i++){
                if (dane[i][pozycja].equals(nazwa)) return i;
            }

        }


        return -1;
    }

    public int znajdzIndex(Vector<String> dane, String nazwa){
        if(dane == null){
            return -1;
        }else{
            int rozmiar = dane.size();
            for (int i=0; i<rozmiar; i++){
                if (dane.elementAt(i).equals(nazwa)) return i;
            }

        }


        return -1;
    }

    public String[][] usunZTablicy(String[][] dane, int index){
        String[][] nowa = new String[dane.length-1][dane[0].length];

        for (int i=0; i<index; i++){
            for (int j=0; j<dane[i].length; j++){
                nowa[i][j] = dane[i][j];
            }
        }

        for (int i=index; i < dane.length-1; i++){
            for (int j=0; j<dane[0].length; j++){
                nowa[i][j] = dane[i+1][j];
            }
        }

        return nowa;
    }

    public void log(String info) throws IOException {
        try (FileWriter file = new FileWriter("log.txt", true);
             BufferedWriter buffor = new BufferedWriter(file)) {
            buffor.write(info);
            buffor.newLine();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}