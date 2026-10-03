/**
 * class permettant de controlé une ampoule avec un interrupteur
 */
public class LightSwitch {
    // attributs de type ampoule
    private LightBulb amp;

    /**
     * Rend une ampoule controlable par interrupteur
     * @param amp l'ampoule controlée par interrupteur
     */
    public LightSwitch(LightBulb amp) {
        this.amp = amp;
    }

    /**
     * Accéder à l’ampoule contrôlée par l’interrupteur
     * @return L'ampoul controlée par l'interrupteur
     */
    public LightBulb getLightBulb() {
        return this.amp;
    }

    /**
     * Eteint l'ampoule si elle est allumée et inversement
     */
    public void push() {
        if (this.amp.isOn() == true) {
            this.amp.turnOff();
        }
        else {
            this.amp.turnOn();
        }
    }
}
