import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        BigDecimal n = new BigDecimal(line);

        if (n.equals(BigDecimal.ZERO) && line.startsWith("-")) {
            System.out.println("-0.0000E+00");
            return;
        }

        int round = Math.max(0, n.precision() - n.scale() + 4);
        n = n.round(new MathContext(round));
        int exponent = 0;

        if (n.abs().compareTo(BigDecimal.ONE) >= 0) {
            int p = n.precision() - n.scale() - 1;
            exponent += p;
            n = n.movePointLeft(p);
        } else {
            int p = n.scale() - n.precision() + 1;
            exponent -= p;
            n = n.movePointRight(p);
        }

        System.out.println((n.signum() < 0 ? "" : "+") + String.format("%.4f", n.doubleValue()) + "E" + (exponent < 0 ? "-" : "+") + String.format("%02d", Math.abs(exponent)));
    }
}
