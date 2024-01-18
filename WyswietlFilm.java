import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

public class WyswietlFilm extends JFrame {

    Film film;
    String[][] wszystkieFilmy;
    boolean czyMoznaPozyczyc;
    String plikWypozyczone = "wypozyczone_filmy.txt";
    Klient klient;
    String pochodzenie;

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

    public WyswietlFilm(int index, String[][] wszystkieFilmy, boolean czyMoznaPozyczyc, Klient klient, String pochodzenie){
        this.pochodzenie = pochodzenie;

        if(this.pochodzenie == "wypozycz"){
            Klient.hideWypozyczFilmWindow();
        }else{
            Klient.hideWypozyczoneFilmyWindow();
        }

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
        lTitle.setBounds(200,60,300,20);
        add(lTitle);
        lTitle.setForeground(tekstLabel);


        ImageIcon icon = resizeImage("filmy/"+wszystkieFilmy[index][1],120,240);
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setBounds(10,60,180,240);
        add(imageLabel);

        lRyzyser = new JLabel("Reżyser:\t" + film.getRezyser());
        lRyzyser.setBounds(200,90,300,20);
        add(lRyzyser);
        lRyzyser.setForeground(tekstLabel);

        lGatunek = new JLabel("Gatunek:\t" + film.getGatunek());
        lGatunek.setBounds(200,120,300,20);
        add(lGatunek);
        lGatunek.setForeground(tekstLabel);

        lCzasTrwania = new JLabel("Czas Trwania:\t" + film.getCzasTrwania());
        lCzasTrwania.setBounds(200,150,300,20);
        add(lCzasTrwania);
        lCzasTrwania.setForeground(tekstLabel);

        lOpis = new JLabel("<html>Opis:\t" + film.getOpis() + "</html>");
        lOpis.setBounds(200,180,250,150);
        add(lOpis);
        lOpis.setForeground(tekstLabel);


        if (czyMoznaPozyczyc){  // TODO else - przycisk do oddania

            Vector<String> pozyczone = klient.getWypozyczoneFilmy();

            bWypozycz = new JButton("Wypożycz");
            bWypozycz.setBounds(65,10,100,20);
            add(bWypozycz);
            bWypozycz.setBackground(tloButton);
            bWypozycz.setForeground(tekstForm);

            lKomunikat = new JLabel("");
            lKomunikat.setBounds(175,10,200,20);
            add(lKomunikat);
            lKomunikat.setForeground(tekstLabel);

            bWypozycz.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String[] dane = {klient.getLogin(),film.getTytul()};
                    BazaDanych b = new BazaDanych();
                    int indexWyp = b.znajdzIndex(pozyczone,wszystkieFilmy[index][0]);

                    if (indexWyp == -1){
                        try {
                            b.zapisDoPliku(dane,plikWypozyczone);
                            klient.dodajDoPozyczonych(film.getTytul());
                            setCzyMoznaPozyczyc(false);
                            lKomunikat.setText("Wypożyczono film");
                            repaint();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }else{
                        lKomunikat.setText("Film jest już pożyczony");
                    }

                }

            });


        }else {

            Vector<String> pozyczone = klient.getWypozyczoneFilmy();

            bWypozycz = new JButton("Oddaj");
            bWypozycz.setBounds(65,10,100,20);
            add(bWypozycz);
            bWypozycz.setBackground(tloButton);
            bWypozycz.setForeground(tekstForm);

            lKomunikat = new JLabel("");
            lKomunikat.setBounds(175,10,200,20);
            add(lKomunikat);
            lKomunikat.setForeground(tekstLabel);

            bWypozycz.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String[] dane = {klient.getLogin(),film.getTytul()};
                    BazaDanych b = new BazaDanych();
                    int indexWyp = b.znajdzIndex(pozyczone,wszystkieFilmy[index][0]);

                    if (indexWyp != -1){
                        try {
                            klient.usunZPozyczonych(film.getTytul());
                            //b.zapisDoPliku(dane,plikWypozyczone);
                            //b.zastapPlik();
                            String[][] wszystkiePozyczenia = b.odczytZPliku(2,"wypozyczone_filmy.txt");
                            int ind = b.znajdzIndex(wszystkiePozyczenia,wszystkieFilmy[index][0]);
                            // TODO nie chce mi sie
                            setCzyMoznaPozyczyc(true);
                            lKomunikat.setText("Oddano film");
                            repaint();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }else{
                        lKomunikat.setText("Film jest już pożyczony");
                    }

                }

            });

        }
        if(pochodzenie == "galeria"){
            bPowrot.addActionListener(e -> GaleriaWypozyczonych.closeWyswietlFilmWindow());
        }else{
            bPowrot.addActionListener(e -> WypozyczFilm.closeWyswietlFilmWindow());
        }

    }

    private void setCzyMoznaPozyczyc(boolean cmp){
        this.czyMoznaPozyczyc = cmp;
    }

    private static ImageIcon resizeImage(String imagePath, int width, int height) {
        try {
            File file = new File(imagePath);
            BufferedImage originalImage = ImageIO.read(file);
            Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImage);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}