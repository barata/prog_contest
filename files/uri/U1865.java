import java.util.Scanner;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer tks = new StringTokenizer(sc.nextLine());
            String name = tks.nextToken();

            System.out.println("Thor".equals(name) ? "Y" : "N");
        }
    }
}
