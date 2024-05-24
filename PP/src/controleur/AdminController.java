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
        chambres.put(chambre.getIdCham(), chambre);
    }

    public void modifierChambre(int id, Chambre chambre) {
        if (chambres.containsKey(id)) {
            if (!chambres.get(id).isReservee()) {
                chambres.put(id, chambre);
            } else {
                throw new IllegalStateException("Erreur: Chambre réservée, ne peut pas être modifiée.");
            }
        } else {
            throw new IllegalArgumentException("Erreur: Chambre non existante.");
        }
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
        if (reservations.containsKey(id)) {
            Reservation reservation = reservations.get(id);
            reservation.setStatut("Acceptée");
            chambres.get(reservation.getIdChambre()).setReservee(true);
        } else {
            throw new IllegalArgumentException("Erreur: Réservation non existante.");
        }
    }

    public void declinerReservation(int id) {
        if (reservations.containsKey(id)) {
            Reservation reservation = reservations.get(id);
            reservation.setStatut("Déclinée");
        } else {
            throw new IllegalArgumentException("Erreur: Réservation non existante.");
        }
    }

    public Map<Integer, Chambre> getChambres() {
        return chambres;
    }

    public Map<Integer, Reservation> getReservations() {
        return reservations;
    }
}

