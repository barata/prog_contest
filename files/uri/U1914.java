import java.util.Scanner;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));

        int qt = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < qt; i++) {
            StringTokenizer tks = new StringTokenizer(sc.nextLine());
            String p1 = tks.nextToken();
            String v = tks.nextToken();
            String p2 = tks.nextToken();
            String par, impar;
            if ("PAR".equals(v)) {
                par = p1;
                impar = p2;
            } else {
                par = p2;
                impar = p1;
            }

            tks = new StringTokenizer(sc.nextLine());
            int sum = Integer.parseInt(tks.nextToken()) + Integer.parseInt(tks.nextToken());
            System.out.println((sum & 0x01) == 0 ? par : impar);
        }
    }
}
