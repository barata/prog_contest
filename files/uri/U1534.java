import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i + j == n - 1) System.out.print("2");
                    else if (i == j) System.out.print("1");
                    else System.out.print("3");
                }
                System.out.println();
            }
        }
    }
}
