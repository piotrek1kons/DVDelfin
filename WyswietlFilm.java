import javax.swing.*;
import java.awt.*;

public class WyswietlFilm extends JFrame {

    Film film;
    String[][] wszystkieFilmy;
    boolean czyMoznaPozyczyc;

    JButton bPowrot;
    JLabel lTitle,lRyzyser,lGatunek,lCzasTrwania,lOpis;

    private JPanel panelWyswietlFilm;
    public JPanel getPanelWyswietlFilm() {
        return panelWyswietlFilm;
    }

    Color tekstLabel = new Color(15, 29, 68);
    Color tekstForm = new Color(248, 249, 241);
    Color tloForm = new Color(234, 158, 156);
    Color tloButton = new Color(5, 166, 218);

    public WyswietlFilm(int index, String[][] wszystkieFilmy, boolean czyMoznaPozyczyc){
        this.wszystkieFilmy = wszystkieFilmy;
        this.czyMoznaPozyczyc = czyMoznaPozyczyc;
        film = new Film(wszystkieFilmy[index][0], wszystkieFilmy[index][1], wszystkieFilmy[index][2], wszystkieFilmy[index][3], wszystkieFilmy[index][4], wszystkieFilmy[index][5]);

        setSize(500,400);
        setTitle("DVDelfin");
        setLayout(null);

        bPowrot = new JButton("<-");
        bPowrot.setBounds(10,10,45,20);
        add(bPowrot);
        bPowrot.setBackground(tloButton);
        bPowrot.setForeground(tekstForm);

        lTitle = new JLabel(film.getTytul());
        lTitle.setBounds(200,20,100,20);
        add(lTitle);
        lTitle.setForeground(tekstLabel);

        JLabel imageLabel = new JLabel();
        ImageIcon icon = new ImageIcon("/filmy/" + film.getObrazekSRC());
        imageLabel.setIcon(icon);
        JPanel panel = new JPanel();
        panel.add(imageLabel);
        add(panel);

        lRyzyser = new JLabel("Reżyser:\t" + film.getRezyser());
        lRyzyser.setBounds(200,50,100,20);
        add(lRyzyser);
        lRyzyser.setForeground(tekstLabel);

        lGatunek = new JLabel("Gatunek:\t" + film.getGatunek());
        lGatunek.setBounds(200,80,100,20);
        add(lGatunek);
        lGatunek.setForeground(tekstLabel);

        lCzasTrwania = new JLabel("Czas Trwania:\t" + film.getRezyser());
        lCzasTrwania.setBounds(200,110,100,20);
        add(lCzasTrwania);
        lCzasTrwania.setForeground(tekstLabel);

        lOpis = new JLabel("Opis:\t" + film.getOpis());
        lOpis.setBounds(200,140,100,100);
        add(lOpis);
        lOpis.setForeground(tekstLabel);

        if (czyMoznaPozyczyc){
            // TODO dodanie nowego filmu do pożyczonych
            // TODO button który po kliknięciu doda do pożyczonych
            // TODO zapis do pliku nazwa_użytkownika ; tytuł  + aktualizowanie wektora z pożyczonymi filmami
        }

    }



}
