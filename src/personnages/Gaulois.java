package personnages;

public class Gaulois {
    private String nom;
    private int force;
    private int effetPotion = 0; //

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

    @Override
    public String toString() {
        return "Gaulois " + nom + " (force " + force + ")";
    }
}



