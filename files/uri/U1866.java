import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();

        for (int i = 0; i < c; i++) {
            int n = sc.nextInt();

            System.out.println(n % 2);
        }
    }
}
