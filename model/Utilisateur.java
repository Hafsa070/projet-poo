

    public abstract class Utilisateur {
        protected int id;
        protected String nomUtilisateur;
        protected String motDePasse;
    
        public Utilisateur(int id, String nomUtilisateur, String motDePasse) {
            this.id = id;
            this.nomUtilisateur = nomUtilisateur;
            this.motDePasse = motDePasse;
        }
    
        public int getId() { return id; }
        public String getNomUtilisateur() { return nomUtilisateur; }
        public String getMotDePasse() { return motDePasse; }
    
        public abstract String getType();
    }
    
