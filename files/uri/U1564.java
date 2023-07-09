import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line;
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            int n = Integer.parseInt(line);
            if (n == 0) {
                System.out.println("vai ter copa!");
            } else {
                System.out.println("vai ter duas!");
            }
        }
    }
}
