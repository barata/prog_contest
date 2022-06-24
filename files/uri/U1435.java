import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;

        while ((n = sc.nextInt()) != 0) {
            int delta = 1;
            int line = 0;
            for (int i = 1; i <= n; i++) {
                if (i <= (n + 1) / 2) line++;
                else if (i > n / 2 + 1) line--;

                for (int column = 1; column <= n; column++) {
                    if (column < line) {
                        System.out.printf("%3d", column);
                    } else if (column > n + 1 - line) {
                        System.out.printf("%3d", (n + 1 - column));
                    } else {
                        System.out.printf("%3d", line);
                    }
                    if (column < n) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }

            System.out.println();
        }
    }
}