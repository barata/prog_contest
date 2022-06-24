import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a;
        while ((a = sc.nextInt()) != 0) {
            int b = sc.nextInt();
            int c = sc.nextInt();

            int res = (int) Math.sqrt(a * b * 100.0 / c);
            System.out.println(res);
        }
    }
}
