package PP.src.model;

public class Admin extends Utilisateur {

    public Admin(int id, String nomUtilisateur, String motDePasse) {
        super(id, nomUtilisateur, motDePasse);
    }

    @Override
    public String getType() {
        return "Admin";

        
    }
}


