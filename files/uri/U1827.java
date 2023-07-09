import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            int n = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == n / 2 && j == n / 2) {
                        System.out.print("4");
                    } else if (i >= n / 3 && j >= n / 3
                    && i < n - n / 3 && j < n - n / 3) {
                        System.out.print("1");
                    } else if (i == j) {
                        System.out.print("2");
                    } else if (i == n - j - 1) {
                        System.out.print("3");
                    } else {
                        System.out.print("0");
                    }
                }
                System.out.println();
            }

            System.out.println();
        }
    }
}
