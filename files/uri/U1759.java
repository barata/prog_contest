import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            int n = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < n; i++) {
                if (i > 0) System.out.print(" ");
                System.out.print("Ho");
            }
            System.out.println("!");
        }
    }
}
