import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DodajFilm extends JFrame {
    private JPanel panelDodajFilm;
    private JLabel panelTytulowy;

    Color tekstLabel = new Color(15, 29, 68);
    Color tekstForm = new Color(248, 249, 241);
    Color tloForm = new Color(234, 158, 156);
    Color tloButton = new Color(5, 166, 218);

    public JPanel getPanelWyborEdytowanegoFilmu() {
        return panelDodajFilm;
    };
    public JLabel getPanelTytulowy() {
        return panelTytulowy;
    }

    JButton bPowrot, bZapisz;
    JLabel lTitle,lTytul,lSciezka,lRezyser,lGatunek,lCzas,lOpis, lKomunikat;
    JTextField tTytul,tSciezka,tRezyser, tGatunek, tCzas, tOpis;

    String tytul, sciezka, rezyser, gatunek, czas, opis, komunikat;

    String[] daneFilmu;
    String nazwaPliku = "filmy.txt";

    public DodajFilm(){
        setSize(500,400);
        setTitle("DVDelfin");
        setLayout(null);

        bPowrot = new JButton("<-");
        bPowrot.setBounds(10,10,45,20);
        add(bPowrot);
        bPowrot.setBackground(tloButton);
        bPowrot.setForeground(tekstForm);

        lTitle = new JLabel("Dodaj Film");
        lTitle.setBounds(200,20,100,20);
        add(lTitle);
        lTitle.setForeground(tekstLabel);

        // Tytuł
        lTytul = new JLabel("Tytuł:\t");
        lTytul.setBounds(130,80,100,20);
        add(lTytul);
        lTytul.setForeground(tekstLabel);

        tTytul =  new JTextField("");
        tTytul.setBounds(230,80,100,20);
        add(tTytul);
        tTytul.setForeground(tekstForm);
        tTytul.setBackground(tloForm);

        // Ścieżka
        lSciezka = new JLabel("Ścieżka:\t");
        lSciezka.setBounds(130,110,100,20);
        add(lSciezka);
        lSciezka.setForeground(tekstLabel);

        tSciezka = new JTextField("");
        tSciezka.setBounds(230, 110,100,20);
        add(tSciezka);
        tSciezka.setForeground(tekstForm);
        tSciezka.setBackground(tloForm);

        // Reżyser
        lRezyser = new JLabel("Reżyser:\t");
        lRezyser.setBounds(130,140,100,20);
        add(lRezyser);
        lRezyser.setForeground(tekstLabel);

        tRezyser = new JTextField("");
        tRezyser.setBounds(230,140,100,20);
        add(tRezyser);
        tRezyser.setForeground(tekstForm);
        tRezyser.setBackground(tloForm);

        // Gatunek
        lGatunek = new JLabel("Gatunekl:\t");
        lGatunek.setBounds(130,170,100,20);
        add(lGatunek);
        lGatunek.setForeground(tekstLabel);

        tGatunek = new JTextField("");
        tGatunek.setBounds(230,170,100,20);
        add(tGatunek);
        tGatunek.setForeground(tekstForm);
        tGatunek.setBackground(tloForm);

        // Czas trwania
        lCzas = new JLabel("Czas trwania:\t");
        lCzas.setBounds(130,200,100,20);
        add(lCzas);
        lCzas.setForeground(tekstLabel);

        tCzas = new JTextField("");
        tCzas.setBounds(230,200,100,20);
        add(tCzas);
        tCzas.setForeground(tekstForm);
        tCzas.setBackground(tloForm);

        // Opis
        lOpis = new JLabel("Opis:\t");
        lOpis.setBounds(130,230,100,20);
        add(lOpis);
        lOpis.setForeground(tekstLabel);

        tOpis = new JTextField("");
        tOpis.setBounds(230,230,100,20);
        add(tOpis);
        tOpis.setForeground(tekstForm);
        tOpis.setBackground(tloForm);

        bZapisz = new JButton("Dodaj film");
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
                sciezka = tSciezka.getText();
                rezyser = tRezyser.getText();
                gatunek = tGatunek.getText();
                czas = tCzas.getText();
                opis = tOpis.getText();


                BazaDanych baza = new BazaDanych();
                int indexFilmu;
                try {

                    if (tytul.isEmpty()) {
                        lKomunikat.setText("Tytuł nie może być pusty!");
                    } else if (sciezka.isEmpty()) {
                        lKomunikat.setText("Ścieżka do pliku nie może być pusta!");
                    } else if (rezyser.isEmpty()) {
                        lKomunikat.setText("Pole reżysera nie może być puste!");
                    } else if (gatunek.isEmpty()) {
                        lKomunikat.setText("Pole gatunek nie może być puste!");
                    } else if (czas.isEmpty()) {
                        lKomunikat.setText("Czas trwania nie może być pusty!");
                    } else if (opis.isEmpty()) {
                        lKomunikat.setText("Opis nie może być pusty!");
                    } else{
                        daneFilmu = new String[6];
                        daneFilmu[0] = tytul;
                        daneFilmu[1] = sciezka;
                        daneFilmu[2] = rezyser;
                        daneFilmu[3] = gatunek;
                        daneFilmu[4] = czas;
                        daneFilmu[5] = opis;

                        baza.zapisDoPliku(daneFilmu,nazwaPliku);
                        lKomunikat.setText("Zapisano zmiany");

                    }


                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        bPowrot.addActionListener(e -> Admin.closeDodajFilmWindow());
    }
}
