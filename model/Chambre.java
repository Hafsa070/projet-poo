

public class Chambre {
    private int id;
    private String type;
    private double prix;
    private boolean reservee;

    public Chambre(int id, String type, double prix) {
        this.id = id;
        this.type = type;
        this.prix = prix;
        this.reservee = false;
    }

    public int getId() { return id; }
    public String getType() { return type; }
    public double getPrix() { return prix; }
    public boolean isReservee() { return reservee; }
    public void setReservee(boolean reservee) { this.reservee = reservee; }

    @Override
    public String toString() {
        return "Chambre [id=" + id + ", type=" + type + ", prix=" + prix + ", reservee=" + reservee + "]";
    }
}

