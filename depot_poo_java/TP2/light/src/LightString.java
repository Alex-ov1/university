/**
 * class pour controlé toutes les ampoules d'une guirlande 
 */
public class LightString {
    // attribut
    private LightBulb[] l;

    /**
     * Créer une guirlande de n ampoules
     * @param n le nombre d'ampoules de la guirlande
     */
    public LightString(int n) {
        this.l = new LightBulb[n];

        for (int i = 0; i < n; i++) {
            this.l[i] = new LightBulb(1, 100, "blanche");
        }
    }

    /**
     * Obtenir la n-ième ampoule de la guirlande
     * @param i le numero de l'ampoule voulue (1-indexed)
     * @return la n-ième ampoule de la guirlande si elle existe, sinon null
     */
    public LightBulb getLightBulb(int i) {
        if (i < 1 || i > this.l.length) {
            return null;
        }
        else {
            return this.l[i-1];
        }
    }

    /**
     * remplace la n-ièm ampoule par celle donnée en paramètre
     * rien ne se passe si 'i' n'est pas un index valide
     * @param i la n-ième ampoule à être modifier (1-indexed) 
     * @param theBulb la nouvelle ampoule
     */
    public void changeLightBulb(int i, LightBulb theBulb) {
        if (i >= 1 && i <= this.l.length) {
            this.l[i-1] = theBulb;
        }
    }

    /**
     * Obtient la consommation en watts de la guirlande si allumée
     * 0 sinon
     * @return la puissance totale de la guirlande en watts
     */
    public int getConsumedPower() {
        int count = 0;

        for (int i = 0; i < this.l.length; i++) {
            if (this.l[i].isOn()) {
                count += this.l[i].getWatt();
            }
        }
        return count;
    }

    /**
     * Allume la guirlande
     */
    public void turnOn() {
        for (int i = 0; i < this.l.length; i++) {
            this.l[i].turnOn();
        }
    }

    /**
     * Eteint la guirlande
     */
    public void turnOff() {
        for (int i = 0; i < this.l.length; i++) {
            this.l[i].turnOff();
        }
    }
}
