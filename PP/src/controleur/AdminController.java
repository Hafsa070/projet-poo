package PP.src.controleur;
import PP.src.model.Chambre;
import PP.src.model.Reservation;
import java.util.HashMap;
import java.util.Map;

public class AdminController {
    private Map<Integer, Chambre> chambres;
    private Map<Integer, Reservation> reservations;

    public AdminController() {
        this.chambres = new HashMap<>();
        this.reservations = new HashMap<>();
    }

    // Méthodes pour gérer les chambres
    public void ajouterChambre(Chambre chambre) {
        if (chambre == null) {
            throw new IllegalArgumentException("La chambre ne peut pas être null.");
        }
        if (chambres.containsKey(chambre.getId())) {
            throw new IllegalArgumentException("Une chambre avec cet ID existe déjà.");
        }
        chambres.put(chambre.getId(), chambre);
    }

    public void modifierChambre(int id, Chambre chambre) {
        if (!chambres.containsKey(id)) {
            throw new IllegalArgumentException("Chambre non existante.");
        }
        if (chambre == null) {
            throw new IllegalArgumentException("La chambre ne peut pas être null.");
        }
        if (chambres.get(id).isReservee()) {
            throw new IllegalStateException("Impossible de modifier une chambre réservée.");
        }
        chambres.put(id, chambre);
    }

    public void supprimerChambre(int id) {
        if (chambres.containsKey(id)) {
            if (!chambres.get(id).isReservee()) {
                chambres.remove(id);
            } else {
                throw new IllegalStateException("Erreur: Chambre réservée, ne peut pas être supprimée.");
            }
        } else {
            throw new IllegalArgumentException("Erreur: Chambre non existante.");
        }
    }

    // Méthodes pour gérer les réservations
    public void accepterReservation(int id) {
        if (!reservations.containsKey(id)) {
            throw new IllegalArgumentException("Réservation non existante.");
        }
        Reservation reservation = reservations.get(id);
        if (!reservation.getStatut().equals("En attente")) {
            throw new IllegalStateException("Impossible d'accepter une réservation qui n'est pas en attente.");
        }
        reservation.setStatut("Acceptée");
        if (!chambres.containsKey(reservation.getIdChambre())) {
            throw new IllegalStateException("La chambre associée à la réservation n'existe pas.");
        }
        chambres.get(reservation.getIdChambre()).setReservee(true);
    }

    public void declinerReservation(int id) {
        if (!reservations.containsKey(id)) {
            throw new IllegalArgumentException("Réservation non existante.");
        }
        Reservation reservation = reservations.get(id);
        if (!reservation.getStatut().equals("En attente")) {
            throw new IllegalStateException("Impossible de décliner une réservation qui n'est pas en attente.");
        }
        reservation.setStatut("Déclinée");
    }

    public Map<Integer, Chambre> getChambres() {
        return chambres;
    }

    public Map<Integer, Reservation> getReservations() {
        return reservations;
    }
}

