import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            if (v < min) {
                min = v;
                minIndex = i;
            }
        }

        System.out.println(minIndex + 1);
    }
}
