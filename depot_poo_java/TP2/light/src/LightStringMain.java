public class LightStringMain {
    public static void main(String[] args) {
        LightString guirlande = new LightString(10);

        guirlande.turnOn();
        System.out.println(guirlande.getConsumedPower());

        LightBulb ampoule = new LightBulb(2, 120, "jaune");
        guirlande.changeLightBulb(4, ampoule);

        System.out.println(guirlande.getConsumedPower());
    }
}
