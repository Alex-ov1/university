/**
 * Classe qui crée des membre d'un certain niveau
 */
public class Member {
    private int points;
    private String name;

    /**
     * Initialise le nom du membre
     * @param name le nom du membre
     */
    public Member(String name) {
        this.name = name;
    }

    /**
     * Renvoie si les deux ont le même nom et nombres et points
     * @param o l'autre membre
     * @return si les deux objets sont égaux
     */
    public boolean isEquals(Object o) {
        if (! (o instanceof Member)) {
            return false;
        }
        Member other = (Member) o;
        boolean isName = this.name.equals(other.name);
        boolean isPoints = this.points == other.points;
        return isName && isPoints;
    }

    /**
     * renvoie le nombre de points du membre
     * @return le nombre de points du membre
     */
    public int getPoitns() {
        return this.points;
    }
    
    /**
     * renvoie le nom du membre
     * @return le nom du membre
     */
    public String getName() {
        return this.name;
    }

    /**
     * ajoute a son compteur un certain nombre de points
     * @param points le nombre de points ajouté
     */
    public void addPoints(int points) {
        this.points += points;
    }

    /**
     * renvoie si le nombre de points du Membre 1 est plus grand que le deuxième
     * @param other l'autre membre
     * @return si le nombre de points du Membre 1 est plus grand que le deuxième
     */
    public boolean greatherThan(Member other) {
        if (this.getPoitns() > other.getPoitns()) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Obtenir le niveau du membre en fonction de ses points
     * @return le niveau du membre en fonction de ses points
     */
    public PremiumLevel getLevel() {
        int nb = this.getPoitns();
        return PremiumLevel.fromPoints(nb);
    }

    /**
     * renvoie si le Membre est niveau platine
     * @return si le Membre est niveau platine
     */
    public boolean isPlatine() {
        if (this.getLevel() == PremiumLevel.PLATINE) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * renvoie la descrption du Membre
     * @return la descrption du Membre
     */
    public String toString() {
        return "Le membre "+this.getName()+" a "+this.getPoitns()+
        " points et est niveau "+this.getLevel();
    }
}
