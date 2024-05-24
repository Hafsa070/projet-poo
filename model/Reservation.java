public class Reservation {

private int id;
    private int idChambre;
    private int idClient;
    private String dateDebut;
    private String dateFin;
    private String statut;

    public Reservation(int id, int idChambre, int idClient, String dateDebut, String dateFin, String statut) {
        this.id = id;
        this.idChambre = idChambre;
        this.idClient = idClient;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.statut = statut;
    }

    public int getId() { return id; }
    public int getIdChambre() { return idChambre; }
    public int getIdClient() { return idClient; }
    public String getDateDebut() { return dateDebut; }
    public String getDateFin() { return dateFin; }
    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    @Override
    public String toString() {
        return "Reservation [id=" + id + ", idChambre=" + idChambre + ", idClient=" + idClient + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", statut=" + statut + "]";
    }
}
