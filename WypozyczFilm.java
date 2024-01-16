import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WypozyczFilm extends JFrame{
    private JPanel panelWypozyczFilm;
    private JButton asterixMisjaKleopatraButton;
    private JButton avatarIstotaWodyButton;
    private JButton avatarButton;
    private JButton barbieButton;
    private JButton charlieIFabrykaCzekoladyButton;
    private JButton chlopiButton;
    private JButton cocoButton;
    private JButton cruellaButton;
    private JButton encantoButton;
    private JButton heartstopperButton;
    private JButton harryPotterICzaraButton;
    private JButton harryPotterIInsygniaButton;
    private JButton harryPotterIInsygniaButton1;
    private JButton harryPotterIKamienButton;
    private JButton harryPotterIKomnataButton;
    private JButton harryPotterIKsiazeButton;
    private JButton harryPotterIWiezienButton;
    private JButton harryPotterIZakonButton;
    private JButton krainaLodu2Button;
    private JButton krainaLoduButton;
    private JButton oppenheimerButton;
    private JButton piecKoszmarnychNocyButton;
    private JButton pulpFictionButton;
    private JButton ratatujButton;
    private JButton toNieWypandaButton;
    private JButton wGlowieSieNieButton;
    private JButton zywotBrianaButton;
    private JLabel panelTytulowy;

    public JPanel getPanelWypozyczFilm() {
        return panelWypozyczFilm;
    };
    public JLabel getPanelTytulowy() {
        return panelTytulowy;
    }

    public WypozyczFilm(){


        asterixMisjaKleopatraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                JOptionPane.showMessageDialog(asterixMisjaKleopatraButton,"Wybrałeś Asterix Misja Kleopatra");
            }
        });

        avatarIstotaWodyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                JOptionPane.showMessageDialog(avatarIstotaWodyButton,"Wybrałeś Avatar Istota Wody");
            }
        });

        avatarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                JOptionPane.showMessageDialog(avatarButton,"Wybrałeś Avatar");
            }
        });

        barbieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                JOptionPane.showMessageDialog(barbieButton,"Wybrałeś Barbie");
            }
        });

        charlieIFabrykaCzekoladyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                JOptionPane.showMessageDialog(charlieIFabrykaCzekoladyButton,"Wybrałeś Charlie i Fabryka Czekolady");
            }
        });

        chlopiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                JOptionPane.showMessageDialog(chlopiButton,"Wybrałeś Chłopi");
            }
        });

        cocoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                JOptionPane.showMessageDialog(cocoButton,"Wybrałeś Coco");
            }
        });

        cruellaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                JOptionPane.showMessageDialog(cruellaButton,"Wybrałeś Cruella");
            }
        });

        encantoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                JOptionPane.showMessageDialog(encantoButton,"Wybrałeś Encanto");
            }
        });

        heartstopperButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                JOptionPane.showMessageDialog(heartstopperButton,"Wybrałeś Heartstopper");
            }
        });

        harryPotterICzaraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                JOptionPane.showMessageDialog(harryPotterICzaraButton,"Wybrałeś Harry Potter i Czara Ognia");
            }
        });

        harryPotterIInsygniaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                JOptionPane.showMessageDialog(harryPotterIInsygniaButton,"Wybrałeś Harry Potter i Insygnia Śmierci cz.1");
            }
        });

        harryPotterIInsygniaButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                JOptionPane.showMessageDialog(harryPotterIInsygniaButton1,"Wybrałeś Harry Potter i Insygnia Śmierci cz.2");
            }
        });

        harryPotterIKamienButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                JOptionPane.showMessageDialog(harryPotterIKamienButton,"Wybrałeś Harry Potter i Kamień Filozoficzny");
            }
        });

        harryPotterIKomnataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                JOptionPane.showMessageDialog(harryPotterIKomnataButton,"Wybrałeś Harry Potter i Komnata Tajemnic");
            }
        });

        harryPotterIKsiazeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                JOptionPane.showMessageDialog(harryPotterIKsiazeButton,"Wybrałeś Harry Potter i Książę Półkrwi");
            }
        });

        harryPotterIWiezienButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                JOptionPane.showMessageDialog(harryPotterIWiezienButton,"Wybrałeś Harry Potter i Więzień Azkabanu");
            }
        });

        harryPotterIZakonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                JOptionPane.showMessageDialog(harryPotterIZakonButton,"Wybrałeś Harry Potter i Zakon Feniksa");
            }
        });

        krainaLodu2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                JOptionPane.showMessageDialog(krainaLodu2Button,"Wybrałeś Kraina Lodu 2");
            }
        });

        krainaLoduButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                JOptionPane.showMessageDialog(krainaLoduButton,"Wybrałeś Kraina Lodu 1");
            }
        });

        oppenheimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                JOptionPane.showMessageDialog(oppenheimerButton,"Wybrałeś Oppenheimer");
            }
        });

        piecKoszmarnychNocyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                JOptionPane.showMessageDialog(piecKoszmarnychNocyButton,"Wybrałeś Pięć koszmarnych nocy");
            }
        });

        ratatujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                JOptionPane.showMessageDialog(ratatujButton,"Wybrałeś Ratatuj");
            }
        });


        pulpFictionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                JOptionPane.showMessageDialog(pulpFictionButton,"Wybrałeś Pulp Fiction");
            }
        });

        toNieWypandaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                JOptionPane.showMessageDialog(toNieWypandaButton,"Wybrałeś To Nie Wypanda");
            }
        });

        wGlowieSieNieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                JOptionPane.showMessageDialog(wGlowieSieNieButton,"Wybrałeś W Głowie Się Nie Mieści");
            }
        });

        zywotBrianaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                JOptionPane.showMessageDialog(zywotBrianaButton,"Wybrałeś Zywot Briana");
            }
        });

        asterixMisjaKleopatraButton.addActionListener(e -> Main.closeMainWindow());
        avatarIstotaWodyButton.addActionListener(e -> Main.closeMainWindow());
        avatarButton.addActionListener(e -> Main.closeMainWindow());
        barbieButton.addActionListener(e -> Main.closeMainWindow());
        charlieIFabrykaCzekoladyButton.addActionListener(e -> Main.closeMainWindow());
        chlopiButton.addActionListener(e -> Main.closeMainWindow());
        cocoButton.addActionListener(e -> Main.closeMainWindow());
        cruellaButton.addActionListener(e -> Main.closeMainWindow());
        encantoButton.addActionListener(e -> Main.closeMainWindow());
        heartstopperButton.addActionListener(e -> Main.closeMainWindow());
        harryPotterICzaraButton.addActionListener(e -> Main.closeMainWindow());
        harryPotterIInsygniaButton.addActionListener(e -> Main.closeMainWindow());
        harryPotterIInsygniaButton1.addActionListener(e -> Main.closeMainWindow());
        harryPotterIKamienButton.addActionListener(e -> Main.closeMainWindow());
        harryPotterIKomnataButton.addActionListener(e -> Main.closeMainWindow());
        harryPotterIKsiazeButton.addActionListener(e -> Main.closeMainWindow());
        harryPotterIWiezienButton.addActionListener(e -> Main.closeMainWindow());
        harryPotterIZakonButton.addActionListener(e -> Main.closeMainWindow());
        krainaLodu2Button.addActionListener(e -> Main.closeMainWindow());
        krainaLoduButton.addActionListener(e -> Main.closeMainWindow());
        oppenheimerButton.addActionListener(e -> Main.closeMainWindow());
        piecKoszmarnychNocyButton.addActionListener(e -> Main.closeMainWindow());
        pulpFictionButton.addActionListener(e -> Main.closeMainWindow());
        ratatujButton.addActionListener(e -> Main.closeMainWindow());
        toNieWypandaButton.addActionListener(e -> Main.closeMainWindow());
        wGlowieSieNieButton.addActionListener(e -> Main.closeMainWindow());
        zywotBrianaButton.addActionListener(e -> Main.closeMainWindow());

    }

}
