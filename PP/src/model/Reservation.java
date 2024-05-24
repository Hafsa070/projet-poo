package PP.src.model;


public class Reservation {
    private int id;
    private int roomId;
    private int userId;
    private PP.src.model.Date checkInDate;
    private PP.src.model.Date checkOutDate;
    private String statut;

    public Reservation(int id, int roomId, int userId, PP.src.model.Date checkInDate, PP.src.model.Date checkOutDate, String statut) {
        this.id = id;
        this.roomId = roomId;
        this.userId = userId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.statut = statut;
    }

    public int getId() {
        return id;
    }

    public int getIdChambre() {
        return roomId;
    }

    public int getUserId() {
        return userId;
    }

    public PP.src.model.Date getCheckInDate() {
        return checkInDate;
    }

    public PP.src.model.Date getCheckOutDate() {
        return checkOutDate;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}

