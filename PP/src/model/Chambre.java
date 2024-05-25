package PP.src.model;
import java.util.HashMap;
import java.util.Scanner;

public class Chambre {
    private int numchambre;
    private String type;
    private double prix;
    private boolean reservee;
    private static int nbChambreDouble = 20;
    private static int nbChambreTriple = 15;
    private static int nbSuite = 10;
    public Chambre(int numchambre, String type, double prix) {
        this.numchambre = numchambre;
        this.type = type;
        this.prix = prix;
        this.reservee = false;
    }

    public Chambre() {}

    public int getNumchambre() {
        return numchambre;
    }

    public void setNumchambre(int numchambre) {
        this.numchambre = numchambre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public boolean isReservee() {
        return reservee;
    }

    public void setReservee(boolean reservee) {
        this.reservee = reservee;
    }

    public static int getNbChambreDouble() {
        return nbChambreDouble;
    }

    public static void setNbChambreDouble(int nbChambreDouble) {
        Chambre.nbChambreDouble = nbChambreDouble;
    }

    public static int getNbChambreTriple() {
        return nbChambreTriple;
    }

    public static void setNbChambreTriple(int nbChambreTriple) {
        Chambre.nbChambreTriple = nbChambreTriple;
    }

    public static int getNbSuite() {
        return nbSuite;
    }

    public static void setNbSuite(int nbSuite) {
        Chambre.nbSuite = nbSuite;
    }

    HashMap<Integer, Integer> chambredouble = new HashMap<>();
    HashMap<Integer, Integer> chambretriple = new HashMap<>();
    HashMap<Integer, Integer> suite = new HashMap<>();

    public void remplirchambre() {
        int i = 1;
        System.out.println(" **chambre double :** ");
        while (i <= nbChambreDouble) {
            chambredouble.put(i, i);
            i++;
        }
        System.out.println(chambredouble);
        System.out.println(" **chambre triple :** ");
        while (i <= nbChambreDouble + nbChambreTriple) {
            chambretriple.put(i, i);
            i++;
        }
        System.out.println(chambretriple);
        System.out.println(" **suites :** ");
        while (i <= nbChambreDouble + nbChambreTriple + nbSuite) {
            suite.put(i, i);
            i++;
        }
        System.out.println(suite);
    }

    public void ajouterchambre(int numch) {
        System.out.println("Veuillez entrer le type de chambre à ajouter (1 pour suite, 2 pour double, 3 pour triple)");
        Scanner scanner = new Scanner(System.in);
        int typech = scanner.nextInt();

        switch (typech) {
            case 1:
                if (!suite.containsKey(numch)) {
                    suite.put(numch, numch);
                    nbSuite++;
                    System.out.println("Suite numéro " + numch + " ajoutée avec succès.");
                } else {
                    System.out.println("La suite numéro " + numch + " existe déjà.");
                }
                break;
            case 2:
                if (!chambredouble.containsKey(numch)) {
                    chambredouble.put(numch, numch);
                    nbChambreDouble++;
                    System.out.println("Chambre double numéro " + numch + " ajoutée avec succès.");
                } else {
                    System.out.println("La chambre double numéro " + numch + " existe déjà.");
                }
                break;
            case 3:
                if (!chambretriple.containsKey(numch)) {
                    chambretriple.put(numch, numch);
                    nbChambreTriple++;
                    System.out.println("Chambre triple numéro " + numch + " ajoutée avec succès.");
                } else {
                    System.out.println("La chambre triple numéro " + numch + " existe déjà.");
                }
                break;
            default:
                throw new IllegalArgumentException("Type de chambre invalide. Veuillez entrer 1, 2 ou 3.");
        }
    }
}
}

