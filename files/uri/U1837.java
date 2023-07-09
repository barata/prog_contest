import java.util.Scanner;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            StringTokenizer tks = new StringTokenizer(sc.nextLine());
            int a = Integer.parseInt(tks.nextToken());
            int b = Integer.parseInt(tks.nextToken());

            int q = a / b;
            int r = a - b * q;

            if (r < 0) {
                System.out.println(a == 0 ? 0 : q + ((a / Math.abs(a)) * (b / Math.abs(b))) + " " + (Math.abs(b) + r));
            } else {
                System.out.println(q + " " + r);
            }
        }
    }
}
