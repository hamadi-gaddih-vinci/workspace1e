import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

public class PlateauJeuBrutusLolaPolice extends JFrame implements ActionListener {

    private JPanel principal, cadreHaut, cadreBas, cadreMilieu, de;
    private JPanel[] num;
    private JLabel[] cases;
    private JLabel informationEnHaut, faceDe;
    private JButton jouerDe,enter;
    private ImageIcon[] fDe;
    private ImageIcon[] numCase;
    private ImageIcon lola,police, bombe, brutus, brutusAvecOs, os, nicheOccupee;
    private Queue<Integer> listeLancersDes = new LinkedList<Integer>();
    private Thread listener;
    private int numeroCaseLola =-1, numeroCasePolice =-1, numeroCaseBrutus =-1, numeroCaseOs = -1;
    private boolean brutusALOs = false;

    private String path = "./Images/";

    public PlateauJeuBrutusLolaPolice(){

        listener = Thread.currentThread();

        this.setTitle("Brutus, Lola et la police");
        this.setSize(550, 650);
        this.setLocation(30, 30);
        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        principal = new JPanel();

        principal.setLayout(new BorderLayout());

        Font font = new Font("Arial", Font.BOLD, 16);

        fDe = new ImageIcon[6];
        fDe[0]= new ImageIcon(path+"un.png");
        fDe[1]= new ImageIcon(path+"deux.png");
        fDe[2]= new ImageIcon(path+"trois.png");
        fDe[3]= new ImageIcon(path+"quatre.png");
        fDe[4]= new ImageIcon(path+"cinq.png");
        fDe[5]= new ImageIcon(path+"six.png");

        numCase = new ImageIcon[16];
        numCase[0] = new ImageIcon(path+"niche.png");
        numCase[1] = new ImageIcon(path+"num1.png");
        numCase[2] = new ImageIcon(path+"num2.png");
        numCase[3] = new ImageIcon(path+"num3.png");
        numCase[4] = new ImageIcon(path+"num4.png");
        numCase[5] = new ImageIcon(path+"num5.png");
        numCase[6] = new ImageIcon(path+"num6.png");
        numCase[7] = new ImageIcon(path+"num7.png");
        numCase[8] = new ImageIcon(path+"num8.png");
        numCase[9] = new ImageIcon(path+"num9.png");
        numCase[10] = new ImageIcon(path+"num10.png");
        numCase[11] = new ImageIcon(path+"num11.png");
        numCase[12] = new ImageIcon(path+"num12.png");
        numCase[13] = new ImageIcon(path+"num13.png");
        numCase[14] = new ImageIcon(path+"num14.png");
        numCase[15] = new ImageIcon(path+"num15.png");

        police = new ImageIcon(path+"chienPolice.png");
        lola = new ImageIcon(path+"lola.png");
        bombe = new ImageIcon(path+"bombe.png");
        brutus = new ImageIcon(path+"brutus.png");
        os = new ImageIcon(path+"os.png");
        brutusAvecOs = new ImageIcon(path + "brutusAvecOs.png");
        nicheOccupee = new ImageIcon(path + "nicheOccupee.png");

        //cadreHaut (information)
        cadreHaut = new JPanel(new GridLayout(3,1));
        cadreHaut.add(new JLabel(" "));
        informationEnHaut = new JLabel(" ");
        informationEnHaut.setFont(font);
        informationEnHaut.setHorizontalAlignment(SwingConstants.CENTER);
        informationEnHaut.setVerticalAlignment(SwingConstants.CENTER);
        cadreHaut.add(informationEnHaut);
        cadreHaut.add(new JLabel(" "));
        principal.add(cadreHaut, BorderLayout.NORTH);

        //cadreBas (bouton suivant)
        cadreBas = new JPanel(new GridLayout(3,1));
        cadreBas.add(new JLabel(" "));
        principal.add(cadreBas, BorderLayout.SOUTH);

        //cadreMilieu (damier + de)
        cadreMilieu = new JPanel(new GridLayout(5,5));

        // Les cases
        cases = new JLabel[16];
        for (int i = 0; i < cases.length; i++) {
            cases[i]=new JLabel();
            cases[i].setIcon(numCase[i]);
        }

        // Le de
        de = new JPanel();
        de.setLayout(new FlowLayout());
        faceDe = new JLabel("");
        faceDe.setIcon(fDe[0]);
        de.add(faceDe);
        jouerDe = new JButton("lancer");
        jouerDe.addActionListener(this);
        de.add(jouerDe);


        for (int i = 0; i < 5; i++) {
            cadreMilieu.add(cases[i]);
        }

        cadreMilieu.add(cases[15]);
        for (int i = 0; i < 3; i++) {
            cadreMilieu.add(new JLabel(" "));
        }
        cadreMilieu.add(cases[5]);

        cadreMilieu.add(cases[14]);

        cadreMilieu.add(new JLabel(" "));
        cadreMilieu.add(de);
        cadreMilieu.add(new JLabel(" "));

        cadreMilieu.add(cases[6]);
        cadreMilieu.add(cases[13]);
        for (int i = 0; i < 3; i++) {
            cadreMilieu.add(new JLabel(" "));
        }
        cadreMilieu.add(cases[7]);
        for (int i = 0; i < 5; i++) {
            cadreMilieu.add(cases[12-i]);
        }

        principal.add(cadreMilieu, BorderLayout.CENTER);

        setContentPane(principal);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int resultatDe = unEntierAuHasardEntre(1,6);
        faceDe.setIcon(fDe[resultatDe-1]);
        ajouterListeLancerDe(resultatDe);
        principal.invalidate();
        principal.repaint();
    }

    private static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
        return (int) (Math.random()* (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
    }

    private int lancerDeSuivant() {
        synchronized (listeLancersDes) {
            while (listeLancersDes.isEmpty()){
                try {
                    listeLancersDes.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return listeLancersDes.remove();

        }
    }

    private void ajouterListeLancerDe(int resultatDe) {
        synchronized (listeLancersDes) {

            listeLancersDes.add(resultatDe);
            if (listener != null)
                listeLancersDes.notifyAll();
        }
    }

    public int lancerDe() {
        int de = lancerDeSuivant();
        return de;
    }

    private void afficherBug(){
        for (int i = 0; i < cases.length; i++) {
            cases[i].setIcon(bombe);
        }
        informationEnHaut.setText("!!!!!!!!!!!BUG!!!!!!!!!!!");
        principal.invalidate();
        principal.repaint();
    }

    public void placerPolice(int numeroCase){
        if(numeroCase<=0||numeroCase>16){
            afficherBug();
        }else{
            if(numeroCase==16)
                numeroCase = 0;
            if(numeroCase== numeroCaseLola){
                numeroCaseLola =-1;
            }
            if(numeroCase== numeroCaseBrutus){
                numeroCaseBrutus =-1;
            }
            if(numeroCase==numeroCaseOs){
                numeroCaseOs=-1;
            }
            cases[numeroCase].setIcon(police);
            numeroCasePolice =numeroCase;
            principal.invalidate();
            principal.repaint();
        }
    }

    public void supprimerPolice(){
        if(numeroCasePolice !=-1){
            cases[numeroCasePolice].setIcon(numCase[numeroCasePolice]);
            numeroCasePolice =-1;
        }
        principal.invalidate();
        principal.repaint();
    }


    public void placerLola(int numeroCase){
        if(numeroCase<=0||numeroCase>16){
            afficherBug();
        }else{
            if(numeroCase==16)
                numeroCase = 0;
            if(numeroCase== numeroCasePolice){
                numeroCasePolice =-1;
            }
            if(numeroCase== numeroCaseBrutus){
                numeroCaseBrutus =-1;
            }
            if(numeroCase==numeroCaseOs){
                numeroCaseOs=-1;
            }
            cases[numeroCase].setIcon(lola);
            numeroCaseLola =numeroCase;
            principal.invalidate();
            principal.repaint();
        }
    }

    public void supprimerLola(){
        if(numeroCaseLola !=-1){
            cases[numeroCaseLola].setIcon(numCase[numeroCaseLola]);
            numeroCaseLola =-1;
        }
        principal.invalidate();
        principal.repaint();
    }

    public void placerBrutus(int numeroCase){
        if(numeroCase<=0||numeroCase>16){
            afficherBug();
        }else{
            if(numeroCase==16)
                numeroCase = 0;
            if(numeroCase== numeroCaseLola){
                numeroCaseLola =-1;
            }
            if(numeroCase== numeroCasePolice){
                numeroCasePolice =-1;
            }
            if(numeroCase==numeroCaseOs){
                numeroCaseOs=-1;
            }
            if(brutusALOs){
                cases[numeroCase].setIcon(brutusAvecOs);
            }else{
                cases[numeroCase].setIcon(brutus);
            }
            numeroCaseBrutus =numeroCase;
            principal.invalidate();
            principal.repaint();
        }
    }


    public void supprimerBrutus(){
        if(numeroCaseBrutus !=-1){
            cases[numeroCaseBrutus].setIcon(numCase[numeroCaseBrutus]);
            numeroCaseBrutus =-1;
        }
        principal.invalidate();
        principal.repaint();
    }

    public void placerOs(int numeroCase){
        if(numeroCase<=0||numeroCase>16){
            afficherBug();
        }else{
            if(numeroCase==16)
                numeroCase = 0;
            if(numeroCase== numeroCasePolice){
                numeroCasePolice =-1;
            }
            if(numeroCase== numeroCaseBrutus){
                numeroCaseBrutus =-1;
            }
            if(numeroCase== numeroCaseLola){
                numeroCaseLola =-1;
            }
            cases[numeroCase].setIcon(os);
            numeroCaseOs=numeroCase;
            principal.invalidate();
            principal.repaint();
        }
    }

    public void supprimerOs(){
        if(numeroCaseOs !=-1){
            cases[numeroCaseOs].setIcon(numCase[numeroCaseOs]);
            numeroCaseOs =-1;
        }
        principal.invalidate();
        principal.repaint();
    }

    public void donnerOsABrutus(){
        brutusALOs = true;
        if (numeroCaseBrutus != -1) {
            cases[numeroCaseBrutus].setIcon(brutusAvecOs);
        }
        principal.invalidate();
        principal.repaint();
    }

    public void occuperNiche(){
        cases[0].setIcon(nicheOccupee);
        principal.invalidate();
        principal.repaint();
    }

    public void afficherInformation(String texte) {
        informationEnHaut.setText(texte);
    }
}
