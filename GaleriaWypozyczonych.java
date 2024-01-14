import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class GaleriaWypozyczonych extends JFrame {

    JButton bPowrot;
    JLabel lTitle,lPustaTablica;
    private JPanel panelGaleriaWypozyczen;
    public JPanel getPanelGaleriaWypozyczen() {
        return panelGaleriaWypozyczen;
    }

    Color tekstLabel = new Color(15, 29, 68);
    Color tekstForm = new Color(248, 249, 241);
    Color tloForm = new Color(234, 158, 156);
    Color tloButton = new Color(5, 166, 218);


    static WyswietlFilm wyswietlFilm;

    public GaleriaWypozyczonych(Vector<String> wypozyczoneFilmy, String[][] wszystkieFilmy, BazaDanych b, Klient klient){
        setSize(500,400);
        setTitle("DVDelfin");
        setLayout(null);

        bPowrot = new JButton("<-");
        bPowrot.setBounds(10,10,45,20);
        add(bPowrot);
        bPowrot.setBackground(tloButton);
        bPowrot.setForeground(tekstForm);

        lTitle = new JLabel("Wypożyczone Filmy");
        lTitle.setBounds(200,20,100,20);
        add(lTitle);
        lTitle.setForeground(tekstLabel);

        if (!wypozyczoneFilmy.isEmpty()){

            int rozmiar = wypozyczoneFilmy.size();

            JPanel galleryPanel = new JPanel(new GridLayout(0, 2, 10, 10));
            int index;

            for (int i = 0; i<rozmiar; i++){
                JButton imageButton = new JButton();
                index = b.znajdzIndex(wszystkieFilmy, wypozyczoneFilmy.elementAt(i));

                ImageIcon icon = resizeImage("filmy/"+wszystkieFilmy[index][1],240,480);
                imageButton.setIcon(icon);

                int finalI = index;
                imageButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed (ActionEvent e){
                        //JOptionPane.showMessageDialog(imageButton,wypozyczoneFilmy.elementAt(finalI));
                        wyswietlFilm = new WyswietlFilm(finalI, wszystkieFilmy, false,klient);
                        ImageIcon icon = new ImageIcon("src/logo - DVDelfin2.jpg");
                        wyswietlFilm.setIconImage(icon.getImage());
                        wyswietlFilm.setBackground(new Color(248, 249, 241));
                        wyswietlFilm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        wyswietlFilm.setVisible(true);
                        wyswietlFilm.setLocationRelativeTo(null);
                    }
                });
                galleryPanel.add(imageButton);
            }

            // scrollowanie
            JScrollPane scrollPane = new JScrollPane(galleryPanel);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

            add(galleryPanel);

        }else{
            lPustaTablica = new JLabel("Brak wypożyczonych filmów");
            lPustaTablica.setBounds(130,150,100,20);
            add(lPustaTablica);
            lPustaTablica.setForeground(tekstLabel);
        }
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
