package PP.src.controleur;

import PP.src.model.Date;
    import PP.src.model.Reservation;
    
    import java.util.HashMap;
    import java.util.Map;
    
    public class ClientController {
        private Map<Integer, Reservation> reservations;
    
        public ClientController() {
            this.reservations = new HashMap<>();
        }
    
        public void demanderReservation(Reservation reservation) {
            reservations.put(reservation.getId(), reservation);
        }
    
        public void modifierReservation(int id, Reservation reservation) {
            if (reservations.containsKey(id)) {
                Reservation existingReservation = reservations.get(id);
                if (existingReservation.getStatut().equals("En attente")) {
                    reservations.put(id, reservation);
                } else {
                    throw new IllegalStateException("Erreur: Réservation déjà traitée, ne peut pas être modifiée.");
                }
            } else {
                throw new IllegalArgumentException("Erreur: Réservation non existante.");
            }
        }
    
        public void annulerReservation(int id) {
            if (reservations.containsKey(id)) {
                Reservation reservation = reservations.get(id);
                if (reservation.getStatut().equals("En attente") && reservation.getCheckInDate().isAfter(new Date(2024, 1, 1))) { // Remplacer par la date actuelle
                    reservations.remove(id);
                } else {
                    throw new IllegalStateException("Erreur: Réservation déjà traitée ou date de début passée, ne peut pas être annulée.");
                }
            } else {
                throw new IllegalArgumentException("Erreur: Réservation non existante.");
            }
        }
    
        public Map<Integer, Reservation> getReservations() {
            return reservations;
        }
    }
    

