import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class WyswietlFilm extends JFrame {

    Film film;
    String[][] wszystkieFilmy;
    boolean czyMoznaPozyczyc;
    String plikWypozyczone = "wypozyczone_filmy.txt";
    Klient klient;

    JButton bPowrot,bWypozycz;
    JLabel lTitle,lRyzyser,lGatunek,lCzasTrwania,lOpis,lKomunikat;

    private JPanel panelWyswietlFilm;
    public JPanel getPanelWyswietlFilm() {
        return panelWyswietlFilm;
    }

    Color tekstLabel = new Color(15, 29, 68);
    Color tekstForm = new Color(248, 249, 241);
    Color tloForm = new Color(234, 158, 156);
    Color tloButton = new Color(5, 166, 218);

    public WyswietlFilm(int index, String[][] wszystkieFilmy, boolean czyMoznaPozyczyc, Klient klient){
        this.wszystkieFilmy = wszystkieFilmy;
        this.czyMoznaPozyczyc = czyMoznaPozyczyc;
        this.klient = klient;
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

            bWypozycz = new JButton("Wypożycz");
            bWypozycz.setBounds(200,230,100,20);
            add(bWypozycz);
            bWypozycz.setBackground(tloButton);
            bWypozycz.setForeground(tekstForm);

            lKomunikat = new JLabel("");
            lKomunikat.setBounds(130,260,200,20);
            add(lKomunikat);
            lKomunikat.setForeground(tekstLabel);

            bWypozycz.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String[] dane = {klient.getLogin(),film.getTytul()};
                    BazaDanych b = new BazaDanych();
                    try {
                        b.zapisDoPliku(dane,plikWypozyczone);
                        klient.dodajDoPozyczonych(film.getTytul());
                        setCzyMoznaPozyczyc(false);
                        lKomunikat.setText("Wypożyczono film");
                        repaint();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }


            });

            bPowrot.addActionListener(e -> OknoWejsciowe.closeRejestracjaWindow());
            bPowrot.addActionListener(e -> Main.main(null));
        }

    }

    private void setCzyMoznaPozyczyc(boolean cmp){
        this.czyMoznaPozyczyc = cmp;
    }

}
