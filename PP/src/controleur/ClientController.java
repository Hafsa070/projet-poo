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
            if (reservation == null) {
                throw new IllegalArgumentException("La réservation ne peut pas être null.");
            }
            if (reservations.containsKey(reservation.getId())) {
                throw new IllegalArgumentException("Une réservation avec cet ID existe déjà.");
            }
            reservations.put(reservation.getId(), reservation);
        }
        public void modifierReservation(int id, Reservation reservation) {
            if (!reservations.containsKey(id)) {
                throw new IllegalArgumentException("Réservation non existante.");
            }
            if (reservation == null) {
                throw new IllegalArgumentException("La réservation ne peut pas être null.");
            }
            if (!reservation.getStatut().equals("En attente")) {
                throw new IllegalStateException("Impossible de modifier une réservation déjà traitée.");
            }
            reservations.put(id, reservation);
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
    

