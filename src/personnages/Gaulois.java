package personnages;

public class Gaulois {
    private String nom;
    private int force;
    private int effetPotion = 0; //
    private Village village;

    public Gaulois(String nom, int force) {
        this.nom = nom;
        this.force = force;
    }

    public String getNom() {
        return nom;
    }

    public void parler(String texte) {
        System.out.println("Le Gaulois " + nom + " : \"" + texte + "\"");
    }

    public void boirePotion(int forcePotion) {
        this.effetPotion = forcePotion;
    }

    public void frapper(Romain romain) {
        int forceCoup = (force / 3) + effetPotion;
        System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
        romain.recevoirCoup(forceCoup);
    }
    
    public void setVillage(Village village) {
        this.village = village;
    }
    
    public void sePresenter() {
        System.out.print("Le Gaulois " + nom + " : \"Bonjour, je m'appelle " + nom + ". ");
        if (this instanceof Chef) {
            System.out.println("Je suis le chef du village " + village.getNom() + ".\"");
        } else if (village != null) {
            System.out.println("J'habite le village " + village.getNom() + ".\"");
        } else {
            System.out.println("Je voyage de villages en villages.\"");
        }
    }
    
    @Override
    public String toString() {
        return "Gaulois " + nom + " (force " + force + ")";
    }
}



