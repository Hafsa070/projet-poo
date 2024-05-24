package PP.src.model;


    public abstract class Utilisateur {
        protected int iduser;
        protected String nomUtilisateur;
        protected String motDePasse;
    
        public Utilisateur(int id, String nomUtilisateur, String motDePasse) {
            this.iduser = id;
            this.nomUtilisateur = nomUtilisateur;
            this.motDePasse = motDePasse;
        }
    
        public int getId() { return iduser; }
        public String getNomUtilisateur() { return nomUtilisateur; }
        public String getMotDePasse() { return motDePasse; }
    
        public abstract String getType();
    }
    
