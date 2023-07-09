import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

class Main {

    private static final Set<String> rules = new HashSet<>();

    static {
        rules.add("tesoura papel");
        rules.add("papel pedra");
        rules.add("pedra lagarto");
        rules.add("lagarto Spock");
        rules.add("Spock tesoura");
        rules.add("tesoura lagarto");
        rules.add("lagarto papel");
        rules.add("papel Spock");
        rules.add("Spock pedra");
        rules.add("pedra tesoura");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= t; i++) {
            String line = sc.nextLine();
            StringTokenizer tks = new StringTokenizer(line);
            String p1 = tks.nextToken();
            String p2 = tks.nextToken();

            if (p1.equals(p2)) {
                System.out.println("Caso #" + i + ": De novo!");
            } else if (rules.contains(line)) {
                System.out.println("Caso #" + i + ": Bazinga!");
            } else {
                System.out.println("Caso #" + i + ": Raj trapaceou!");
            }
        }
    }
}
