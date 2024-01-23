import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;


public class WyborEdytowanegoFilmu extends JFrame{
    private JPanel panelWyborEdytowanegoFilmu;
    private JLabel panelTytulowy;

    JButton bPowrot;
    JLabel lTitle;
    Color tekstLabel = new Color(15, 29, 68);
    Color tekstForm = new Color(248, 249, 241);
    Color tloForm = new Color(234, 158, 156);
    Color tloButton = new Color(5, 166, 218);

    static EdytujFilm edytujFilm;
    public JPanel getPanelWyborEdytowanegoFilmu() {
        return panelWyborEdytowanegoFilmu;
    };
    public JLabel getPanelTytulowy() {
        return panelTytulowy;
    }

    public WyborEdytowanegoFilmu(String[][] wszystkieFilmy, BazaDanych b, Admin admin){
        setSize(500, 1200);
        setTitle("DVDelfin");

        int rozmiar = wszystkieFilmy.length;

        JPanel galleryPanel = new JPanel(new GridLayout(0, 5, 10, 10));
        bPowrot = new JButton("<-");
        galleryPanel.add(bPowrot);
        bPowrot.setBackground(tloButton);
        bPowrot.setForeground(tekstForm);

        lTitle = new JLabel("Filmy");
        lTitle.setHorizontalAlignment(JLabel.CENTER);
        galleryPanel.add(lTitle);
        lTitle.setForeground(tekstLabel);
        int index;

        for (int i = 0; i<rozmiar; i++){

            ImageIcon icon = resizeImage("filmy/"+wszystkieFilmy[i][1],120,240);
            System.out.println("filmy/"+wszystkieFilmy[i][1]);
            JButton imageButton = new JButton(icon);

            int finalI = i;
            imageButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed (ActionEvent e){
                    //JOptionPane.showMessageDialog(imageButton,wypozyczoneFilmy.elementAt(finalI));

                    edytujFilm = new EdytujFilm(finalI, wszystkieFilmy, admin);
                    ImageIcon icon = new ImageIcon("src/logo - DVDelfin2.jpg");
                    edytujFilm.setIconImage(icon.getImage());
                    edytujFilm.setBackground(new Color(248, 249, 241));
                    edytujFilm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    edytujFilm.setVisible(true);
                    edytujFilm.setLocationRelativeTo(null);
                }
            });
            galleryPanel.add(imageButton);
            bPowrot.addActionListener(e -> Admin.closeWyborEdytowanegoFilmuWindow());
            bPowrot.addActionListener(e -> Admin.showMenuAdminWindow());

        }

        // scrollowanie
        JScrollPane scrollPane = new JScrollPane(galleryPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane);




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

    public static void closeEdytujFilmWindow(){
        edytujFilm.dispose();
        Admin.showWyborEdytowanegoFilmuWindow();
    }
    public static void showEdytujFilmWindow(){ edytujFilm.setVisible(true);}
    public static void hideEdytujFilmWindow(){ edytujFilm.setVisible(false);}

}