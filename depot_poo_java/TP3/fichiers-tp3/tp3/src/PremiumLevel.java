/**
 * class qui permet d'obtenir le niveau associé au nombre de points
 */
public enum PremiumLevel {
    OR,
    ARGENT,
    PLATINE;

    private static final int points_or = 1000;
    private static final int points_argent = 0;
    private static final int points_platine = 2500;

    /**
     * renvoie le niveau associé au nombre de points
     * @param n le nombre de points
     * @return le niveau associé au nombre de points
     */
    public static PremiumLevel fromPoints(int n) {
        if (n == points_argent) {
            return PremiumLevel.ARGENT;
        }
        if (n > 0 && n < points_or) {
            return PremiumLevel.OR;
        }
        else {
            return PremiumLevel.PLATINE;
        }
    }
}
