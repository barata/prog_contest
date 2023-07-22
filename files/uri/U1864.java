import java.util.Scanner;

class Main {

    private static final String TEXT = "LIFE IS NOT A PROBLEM TO BE SOLVED";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(TEXT.substring(0, n));
    }
}
