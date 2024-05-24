package PP.src.model;


public class Client extends PP.src.model.Utilisateur {

    public Client(int id, String nomUtilisateur, String motDePasse) {
        super(id, nomUtilisateur, motDePasse);
    }

    @Override
    public String getType() {
        return "Client";
    }
}
