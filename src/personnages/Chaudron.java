package personnages;

public class Chaudron {
    private int nbDoses;
    private int forcePotion;

    public void remplir(int nbDoses, int forcePotion) {
        this.nbDoses = nbDoses;
        this.forcePotion = forcePotion;
    }

    public boolean restePotion() {
        return nbDoses > 0;
    }

    public int utiliserDose() {
        if (nbDoses > 0) {
            nbDoses--;
            return forcePotion;
        }
        return 0;
    }
}
