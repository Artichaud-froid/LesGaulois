package personnages;

public class Druide {
    private String nom;
    private Chaudron chaudron = new Chaudron();

    public Druide(String nom) {
        this.nom = nom;
    }

    public void parler(String texte) {
        System.out.println("Le Druide " + nom + " : \"" + texte + "\"");
    }

    public void fabriquerPotion(int nbDoses, int forcePotion) {
        chaudron.remplir(nbDoses, forcePotion);
        parler("J’ai concocté " + nbDoses + " doses de potion magique de force " + forcePotion + ".");
    }

    public void booster(Gaulois gaulois) {
        if (gaulois.getNom().equals("Obélix")) {
            parler("Non Obélix, non ! Et tu le sais très bien !");
        } else if (chaudron.restePotion()) {
            int forcePotion = chaudron.utiliserDose();
            gaulois.boirePotion(forcePotion);
            parler("Tiens " + gaulois.getNom() + ", bois cette potion magique !");
        } else {
            parler("Je n’ai plus de potion !");
        }
    }
}
