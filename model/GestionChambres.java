import java.util.HashMap;
import java.util.Map;

public class GestionChambres {
    private Map<Integer, Chambre> chambres = new HashMap<>();

    // Méthode pour ajouter une chambre
    public void ajouterChambre(int numero, String type, double prix) {
        Chambre chambre = new Chambre(numero, type, prix);
        chambres.put(numero, chambre);
    }

    // Méthode pour modifier une chambre
    public void modifierChambre(int numero, String type, double prix) {
        if (chambres.containsKey(numero)) {
            Chambre chambre = chambres.get(numero);
            chambre.setType(type);
            chambre.setPrix(prix);
            chambres.put(numero, chambre);
        } else {
            System.out.println("La chambre n'existe pas.");
        }
    }

    // Méthode pour supprimer une chambre
    public void supprimerChambre(int numero) {
        if (chambres.containsKey(numero)) {
            chambres.remove(numero);
        } else {
            System.out.println("La chambre n'existe pas.");
        }
    }

    // Méthode pour afficher toutes les chambres
    public void afficherChambres() {
        for (Chambre chambre : chambres.values()) {
            System.out.println(chambre);
        }
    }

    // Classe interne pour représenter une chambre
    private class Chambre {
        private int numero;
        private String type;
        private double prix;

        public Chambre(int numero, String type, double prix) {
            this.numero = numero;
            this.type = type;
            this.prix = prix;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setPrix(double prix) {
            this.prix = prix;
        }

        @Override
        public String toString() {
            return "Chambre{" +
                    "numero=" + numero +
                    ", type='" + type + '\'' +
                    ", prix=" + prix +
                    '}';
        }
    }
}
