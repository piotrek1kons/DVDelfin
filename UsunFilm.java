import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UsunFilm extends JFrame {

    JButton bPowrot;
    JLabel lTitle;
    BazaDanych b;
    Color tekstLabel = new Color(15, 29, 68);
    Color tekstForm = new Color(248, 249, 241);
    Color tloForm = new Color(234, 158, 156);
    Color tloButton = new Color(5, 166, 218);

    public UsunFilm() throws FileNotFoundException {
        setSize(500, 1200);
        setTitle("DVDelfin");
        JPanel deletePanel = new JPanel(new GridLayout(0, 2, 10, 10));
        bPowrot = new JButton("<-");
        //bPowrot.setBounds(10,10,45,20);
        deletePanel.add(bPowrot);
        bPowrot.setBackground(tloButton);
        bPowrot.setForeground(tekstForm);

        lTitle = new JLabel("Filmy");
        //lTitle.setBounds(200,20,100,20);
        lTitle.setHorizontalAlignment(JLabel.CENTER);
        deletePanel.add(lTitle);
        lTitle.setForeground(tekstLabel);

        b = new BazaDanych();
        final String[][] filmy = b.odczytZPliku(6, "filmy.txt");

        if(filmy.length > 0){
            deletePanel.setLayout(new GridLayout(0, 2, 10, 10));
            int rozmiar = filmy.length;

            int index;

            for (int i = 1; i<rozmiar; i++) {
                JLabel nazwa = new JLabel(filmy[i][0]);
                nazwa.setHorizontalAlignment(JLabel.CENTER);
                deletePanel.add(nazwa);

                JButton deleteButton = new JButton("Usuń");
                //imageButton.setIcon(icon);

                ImageIcon icon = resizeImage("filmy/"+filmy[i][1],120,240);
                System.out.println("filmy/"+filmy[i][1]);
                JButton imageButton = new JButton(icon);

                deletePanel.add(deleteButton);

                int finalI = i;
                deleteButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed (ActionEvent e){
                        String[][] nowaTablica;
                        //JOptionPane.showMessageDialog(imageButton,wypozyczoneFilmy.elementAt(finalI));
                        nowaTablica = b.usunZTablicy(filmy, finalI);
                        try {
                            b.zastapPlik(nowaTablica,"filmy.txt");

                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });

                deletePanel.add(deleteButton);
                add(deletePanel);
                bPowrot.addActionListener(e -> Admin.closeUsunFilmWindow());
                JScrollPane scrollPane = new JScrollPane(deletePanel);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

                add(scrollPane);
            }
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
