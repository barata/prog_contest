import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        boolean happy = true;

        if (a > b && b <= c) {
            happy = true;
        } else if (a < b && b >= c) {
            happy = false;
        } else if (a < b && b < c && b - a > c - b) {
            happy = false;
        } else if (a < b && b < c && b - a <= c - b) {
            happy = true;
        } else if (a > b && b > c && a - b > b - c) {
            happy = true;
        } else if (a > b && b > c && a - b <= b - c) {
            happy = false;
        } else if (a == b) {
            happy = b < c;
        }

        System.out.println(happy ? ":)" : ":(");
    }
}
