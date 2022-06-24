import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;

        while ((n = sc.nextInt()) != 0) {
            int[][] array = new int[n][n];

            for (int startingPoint = 0; startingPoint <= (n - 1) / 2; startingPoint++) {
                int v = 0;

                for (int i = startingPoint; i < n - startingPoint; i++) {
                    array[startingPoint][i] = ++v;
                    array[i][startingPoint] = v;
                }
                for (int i = startingPoint + 1; i < n - startingPoint; i++) {
                    array[i][n - startingPoint - 1] = --v;
                    array[n - startingPoint - 1][i] = v;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.printf("%3d", array[i][j]);
                    if (j < n - 1) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }

            System.out.println();
        }
    }
}
