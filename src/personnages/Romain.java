package personnages;

import objets.Equipement;

public class Romain {
    private String nom;
    private int force;
    private Equipement[] equipements = new Equipement[2];
    private int nbEquipement = 0;

    public Romain(String nom, int force) {
        this.nom = nom;
        this.force = force;
        assert isInvariantVerified() : "Invariant non respecté : la force doit être positive ou nulle.";
    }

    public String getNom() {
        return nom;
    }

    public void parler(String texte) {
        System.out.println("Le Romain " + nom + " : \"" + texte + "\"");
    }

    private boolean isInvariantVerified() {
        return force >= 0;
    }

    public void recevoirCoup(int forceCoup) {
        assert forceCoup > 0 : "Précondition non respectée : le coup reçu doit être positif.";

        int ancienneForce = force;
        force -= forceCoup;

        if (force > 0) {
            parler("Aïe");
        } else {
            force = 0;
            parler("J'abandonne !");
        }

        assert force < ancienneForce : "Postcondition non respectée : la force n'a pas diminué.";
        assert isInvariantVerified() : "Invariant non respecté : la force est devenue négative.";
    }

    private void afficherEquipement(Equipement equipement) {
        System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
    }

    public void sEquiper(Equipement equipement) {
        switch (nbEquipement) {
            case 2:
                System.out.println("Le soldat " + nom + " est déjà bien protégé !");
                break;

            case 1:
                if (equipements[0] == equipement) {
                    System.out.println("Le soldat " + nom + " possède déjà un " + equipement + " !");
                } else {
                    equipements[nbEquipement] = equipement;
                    nbEquipement++;
                    afficherEquipement(equipement);
                }
                break;

            case 0:
                equipements[nbEquipement] = equipement;	 
                nbEquipement++;
                afficherEquipement(equipement);
                break;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Test des énumérations et équipements ===");
        Romain minus = new Romain("Minus", 6);

        minus.sEquiper(Equipement.CASQUE);
        minus.sEquiper(Equipement.CASQUE); 
        minus.sEquiper(Equipement.BOUCLIER);
        minus.sEquiper(Equipement.CASQUE);
    }
}
