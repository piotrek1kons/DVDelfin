import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UsunUzytkownika extends JFrame {
    JButton bPowrot;
    JLabel lTitle;
    BazaDanych b;
    Color tekstLabel = new Color(15, 29, 68);
    Color tekstForm = new Color(248, 249, 241);
    Color tloForm = new Color(234, 158, 156);
    Color tloButton = new Color(5, 166, 218);

    public UsunUzytkownika() throws FileNotFoundException {
        setSize(500, 1200);
        setTitle("DVDelfin");
        JPanel deletePanel = new JPanel(new GridLayout(10, 2, 10, 10));
        bPowrot = new JButton("<-");
        //bPowrot.setBounds(10,10,45,20);
        deletePanel.add(bPowrot);
        bPowrot.setBackground(tloButton);
        bPowrot.setForeground(tekstForm);

        lTitle = new JLabel("Uzytkownicy");
        //lTitle.setBounds(200,20,100,20);
        lTitle.setHorizontalAlignment(JLabel.CENTER);
        deletePanel.add(lTitle);
        lTitle.setForeground(tekstLabel);

        b = new BazaDanych();
        final String[][] uzytkownicy = b.odczytZPliku(6, "user.txt");

        if(uzytkownicy.length > 1){
            deletePanel.setLayout(new GridLayout(0, 2, 10, 10));
            int rozmiar = uzytkownicy.length;

            int index;

            for (int i = 1; i<rozmiar; i++) {
                JLabel nazwa = new JLabel(uzytkownicy[i][0]);
                nazwa.setHorizontalAlignment(JLabel.CENTER);
                deletePanel.add(nazwa);

                JButton deleteButton = new JButton("Usuń");
                //imageButton.setIcon(icon);

                deletePanel.add(deleteButton);

                int finalI = i;
                deleteButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed (ActionEvent e){
                        String[][] nowaTablica;
                        //JOptionPane.showMessageDialog(imageButton,wypozyczoneFilmy.elementAt(finalI));
                        nowaTablica = b.usunZTablicy(uzytkownicy, finalI);
                        try {
                            b.zastapPlik(nowaTablica,"user.txt");
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });

                deletePanel.add(deleteButton);
                add(deletePanel);
                bPowrot.addActionListener(e -> Admin.closeUsunUzytkownikaWindow());
                JScrollPane scrollPane = new JScrollPane(deletePanel);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

                add(scrollPane);
            }
        }
    }

}
