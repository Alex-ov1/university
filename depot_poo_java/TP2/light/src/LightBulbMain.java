/**
 * class principale permettant de tester les fonctionnalités de la classe LightBulb
 */
public class LightBulbMain {
    /**
     * Point d'entrée du programme
     * @param args arguments de la ligne de commande
     */
    public static void main(String[] args) {
        LightBulb ampoule1 = new LightBulb(4, 1200, "blanche");
        System.out.println(ampoule1);

        ampoule1.turnOn();
        System.out.println(ampoule1);

        LightBulb ampoule2 = new LightBulb(7, 1500, "jaune");
        LightSwitch interrupteur = new LightSwitch(ampoule2);
        interrupteur.push();
        System.out.println(ampoule2);
    }
}
