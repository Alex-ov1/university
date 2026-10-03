public class MemberMain {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("ERROR");
            return;
        }

        Member member = new Member(args[0]);

        if (args.length >= 2) {
            try {
                int i = Integer.parseInt(args[1]);
                member.addPoints(i);
            } catch(NumberFormatException error) {
                System.out.println("Le second argument n'est pas un entier");

            }
        }

        System.out.println(member);
        System.out.println(member.getLevel());
        System.out.println("Le membre est platine: "+member.isPlatine());

        Member timoleon = new Member("timoleon");

        java.util.Random alea = new java.util.Random();
        int nb = alea.nextInt(2500);
        timoleon.addPoints(nb);

        System.out.println(timoleon);

        if (member.isEquals(timoleon)) {
            System.out.println("Ils sont égaux");
        }
        else {
            System.out.println("Ils ne sont pas égaux");
        }

        System.out.println("Le membre 1 a plus de points que timoleon: "+member.greatherThan(timoleon));
    }
}
