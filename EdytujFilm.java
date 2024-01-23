import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EdytujFilm extends JFrame {
    Film film;
    JButton bPowrot, bZapisz;
    JLabel lTitle,lTytul,lSciezka,lRezyser,lGatunek,lCzas,lOpis, lKomunikat;
    JTextField tTytul,tSciezka,tRezyser, tGatunek, tCzas, tOpis;

    String tytul, staryTytul, sciezka, rezyser, gatunek, czas, opis, komunikat;

    String[][] daneFilmu;
    String nazwaPliku = "filmy.txt";

    private JPanel panelEdytujFilm;
    public JPanel getPanelEdytujFilm() {
        return panelEdytujFilm;
    }

    Color tekstLabel = new Color(15, 29, 68);
    Color tekstForm = new Color(248, 249, 241);
    Color tloForm = new Color(234, 158, 156);
    Color tloButton = new Color(5, 166, 218);

    public EdytujFilm(int index, String[][] wszystkieFilmy, Admin admin){
        Admin.hideWyborEdytowanegoFilmuWindow();
        film = new Film(wszystkieFilmy[index][0], wszystkieFilmy[index][1], wszystkieFilmy[index][2], wszystkieFilmy[index][3], wszystkieFilmy[index][4], wszystkieFilmy[index][5]);
        setSize(500,400);
        setTitle("DVDelfin");
        setLayout(null);

        bPowrot = new JButton("<-");
        bPowrot.setBounds(10,10,45,20);
        add(bPowrot);
        bPowrot.setBackground(tloButton);
        bPowrot.setForeground(tekstForm);

        lTitle = new JLabel("Edytuj Film");
        lTitle.setBounds(200,20,100,20);
        add(lTitle);
        lTitle.setForeground(tekstLabel);

        // ZMIANA Tytułu
        lTytul = new JLabel("Tytuł:\t");
        lTytul.setBounds(130,80,100,20);
        add(lTytul);
        lTytul.setForeground(tekstLabel);

        tTytul =  new JTextField("");
        tTytul.setBounds(230,80,100,20);
        add(tTytul);
        tTytul.setForeground(tekstForm);
        tTytul.setBackground(tloForm);

        // ZMIANA ŚCIEŻKI
        lSciezka = new JLabel("Ścieżka:\t");
        lSciezka.setBounds(130,110,100,20);
        add(lSciezka);
        lSciezka.setForeground(tekstLabel);

        tSciezka = new JTextField("");
        tSciezka.setBounds(230, 110,100,20);
        add(tSciezka);
        tSciezka.setForeground(tekstForm);
        tSciezka.setBackground(tloForm);

        // ZMIANA REŻYSERA
        lRezyser = new JLabel("Reżyser:\t");
        lRezyser.setBounds(130,140,100,20);
        add(lRezyser);
        lRezyser.setForeground(tekstLabel);

        tRezyser = new JTextField("");
        tRezyser.setBounds(230,140,100,20);
        add(tRezyser);
        tRezyser.setForeground(tekstForm);
        tRezyser.setBackground(tloForm);

        // ZMIANA GATUNKU
        lGatunek = new JLabel("Gatunekl:\t");
        lGatunek.setBounds(130,170,100,20);
        add(lGatunek);
        lGatunek.setForeground(tekstLabel);

        tGatunek = new JTextField("");
        tGatunek.setBounds(230,170,100,20);
        add(tGatunek);
        tGatunek.setForeground(tekstForm);
        tGatunek.setBackground(tloForm);

        // ZMIANA CZAS
        lCzas = new JLabel("Czas:\t");
        lCzas.setBounds(130,200,100,20);
        add(lCzas);
        lCzas.setForeground(tekstLabel);

        tCzas = new JTextField("");
        tCzas.setBounds(230,200,100,20);
        add(tCzas);
        tCzas.setForeground(tekstForm);
        tCzas.setBackground(tloForm);

        // ZMIANA OPISU
        lOpis = new JLabel("Opis:\t");
        lOpis.setBounds(130,230,100,20);
        add(lOpis);
        lOpis.setForeground(tekstLabel);

        tOpis = new JTextField("");
        tOpis.setBounds(230,230,100,20);
        add(tOpis);
        tOpis.setForeground(tekstForm);
        tOpis.setBackground(tloForm);

        bZapisz = new JButton("Zapisz zmiany");
        bZapisz.setBounds(165,260,150,20);
        add(bZapisz);
        bZapisz.setBackground(tloButton);
        bZapisz.setForeground(tekstForm);

        lKomunikat = new JLabel("");
        lKomunikat.setBounds(130,290,200,20);
        add(lKomunikat);
        lKomunikat.setForeground(tekstLabel);

        bZapisz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //String[] dane = new String[4];
                tytul = tTytul.getText();
                staryTytul = tTytul.getText();
                sciezka = tSciezka.getText();
                rezyser = tRezyser.getText();
                gatunek = tGatunek.getText();
                czas = tCzas.getText();
                opis = tOpis.getText();


                BazaDanych baza = new BazaDanych();
                int indexFilmu;
                try {

                    daneFilmu = baza.odczytZPliku(6,"filmy.txt");
                    indexFilmu = baza.znajdzIndex(daneFilmu,film.getTytul());

                    if (!tytul.isEmpty()) {
                        film.setTytul(tytul);
                        daneFilmu[indexFilmu][0] = tytul;
                    }

                    if (!sciezka.isEmpty()) {
                        film.setObrazekSRC(sciezka);
                        daneFilmu[indexFilmu][1] = sciezka;
                    }

                    if (!rezyser.isEmpty()) {
                        film.setRezyser(rezyser);
                        daneFilmu[indexFilmu][2]= rezyser;
                    }

                    if (!gatunek.isEmpty()) {
                        film.setGatunek(gatunek);
                        daneFilmu[indexFilmu][3] = gatunek;
                    }

                    if (!czas.isEmpty()) {
                        film.setCzasTrwania(czas);
                        daneFilmu[indexFilmu][4] = czas;
                    }

                    if (!opis.isEmpty()) {
                        film.setOpis(opis);
                        daneFilmu[indexFilmu][5] = opis;
                    }

                    baza.zastapPlik(daneFilmu,nazwaPliku);

                    lKomunikat.setText("Zapisano zmiany");
                    baza.log("Edytowano film pt. "+staryTytul);

                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        bPowrot.addActionListener(e -> WyborEdytowanegoFilmu.closeEdytujFilmWindow()); // tu powinien zmienic visible
        bPowrot.addActionListener(e -> Admin.showWyborEdytowanegoFilmuWindow()); // tu powinien zmienic visible


    }

}