/**
 * class pour ampoules électriques
 */
public class LightBulb {
    // attributs de la classes
    private int watts;
    private int lumens;
    private String color;
    private boolean on = false; // initalement la val par défaut est deja à false mais j'explicite

    /**
     * crée une ampoule avec un taux de consommation en watt, production lumineuse et couleur d'éclairage 
     * @param watts puissance électrique consommée en Watts
     * @param lumens puissance lumineuse produite en lumens
     * @param color couleur de l'éclairage
     */
    public LightBulb(int watts, int lumens, String color) {
        this.watts = watts;
        this.lumens = lumens;
        this.color = color;
    }

    /**
     * Obtient le nombre de watts qu'elle consomme
     * @return le nombre de Watts qu'elle consomme
     */
    public int getWatt() {
        return this.watts;
    }

    /**
     * Obtient la puissance lumineuse produite
     * @return la puissance lumineuse de l'ampoule
     */
    public int getLumen() {
        return this.lumens;
    }

    /**
     * Obtient la couleur d'éclairage de l'ampoule
     * @return la couleur d'éclairage de l'ampoule
     */
    public String getColor() {
        return this.color;
    }

    /**
     * Allume l'ampoule
     */
    public void turnOn() {
        if (this.on != true) {
            this.on = true;
        }
    }

    /**
     * Eteint l'ampoule
     */
    public void turnOff() {
        if (this.on != false) {
            this.on = false;
        }
    }

    /**
     * Savoir si une ampoule est allumée ou éteinte
     * @return l'ampoule est elle allumée oui ou non
     */
    public boolean isOn() {
        return this.on == true;
    }

    /**
     * Description complète de l'ampoule
     * @return description complète de l'ampoule
     */
    public String toString() {
        if (this.on == false) {
            return "L'ampoule est éteinte, elle consomme " + this.getWatt() + " watts " + "et produit " + this.getLumen() +
            " lumens";
        }
        else {
            return "L'ampoule est allumée, elle consomme " + this.getWatt() + " watts " + ",produit " + this.getLumen() +
            " lumens" + " et sa couleur d'éclairage est " + this.getColor();
        }
    }
}
