import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = new int[] {
                sc.nextInt(),
                sc.nextInt(),
                sc.nextInt(),
                sc.nextInt(),
        };
        Arrays.sort(array);
        if (array[1] + array[2] > array[3] || array[0] + array[1] > array[2]) {
            System.out.println("S");
        } else {
            System.out.println("N");
        }
    }
}
