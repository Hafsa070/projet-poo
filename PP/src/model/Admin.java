package PP.src.model;

public class Admin extends PP.src.model.Utilisateur {

     static String mdp = "poo9" ;

    public Admin(int id, String nomUtilisateur, String motDePasse,int mdp) {
        super(id, nomUtilisateur, motDePasse);

    }


    @Override
    public String getType() {
        return "Admin";

        
    }
}


