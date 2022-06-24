import java.util.Scanner;

class Main {

    private static final int[][] m = new int[15][15];

    static {
        int i = 1;
        for (int row = 0; row < m.length; row++) {
            int j = i;
            for (int col = 0; col < m[row].length; col++) {
                m[row][col] = j;
                j *= 2;
            }

            i *= 2;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        while ((n = sc.nextInt()) != 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j > 0) System.out.print(" ");
                    System.out.print(rJustify(m[i][j], String.valueOf((int) Math.pow(4, n - 1)).length()));
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    private static String rJustify(int n, int size) {
        StringBuffer buf = new StringBuffer(String.valueOf(n));
        int nSpaces = Math.max(0, size - buf.length());
        for (int i = 0; i < nSpaces; i++) {
            buf.insert(0, ' ');
        }
        return buf.toString();
    }
}
