import java.util.Scanner;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            int l = Integer.parseInt(sc.nextLine());
            StringTokenizer tks = new StringTokenizer(sc.nextLine());

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < l; i++) {
                int v = Integer.parseInt(tks.nextToken());
                max = Math.max(max, v);
            }

            System.out.println(max / 10 + 1);
        }
    }
}
