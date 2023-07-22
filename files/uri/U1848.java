import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i ++) {
            int sum = 0;

            String line;
            while (!"caw caw".equals(line = sc.nextLine())) {
                if (line.charAt(0) == '*') {
                    sum += 4;
                }
                if (line.charAt(1) == '*') {
                    sum += 2;
                }
                if (line.charAt(2) == '*') {
                    sum += 1;
                }
            }

            System.out.println(sum);
        }
    }
}
