import java.io.IOException;

class Main {

	static String readLn (int maxLg)   {
        byte lin[] = new byte [maxLg];
        int lg = 0, car = -1;
        String line = "";
        try {
            while (lg < maxLg) {
                car = System.in.read();
                if ((car < 0) || (car == '\n')) break;
                lin [lg++] += car;
        }}
        catch (IOException e) { return (null); }
        if ((car < 0) && (lg == 0)) return (null);  // eof
        return (new String (lin, 0, lg)).trim();
    }

	public static void main(String[] args) {

		long a, b, c, d;
		long cubo_a, cubo_b, cubo_c, cubo_d;
		
		for (a = 6; a <= 200; a++) {
			cubo_a = a * a * a;
			for (b = 2; (cubo_b = b * b * b) < cubo_a; b++) {
				for (c = b + 1; (cubo_c = c * c * c) < cubo_a - cubo_b; c++) {
					cubo_d = cubo_a - cubo_b - cubo_c;
					d = Math.round(Math.pow(cubo_d,  1 / 3d));

					if (cubo_d > cubo_c && cubo_d == d * d * d)
						System.out.println("Cube = " + a + ", Triple = (" + b + "," + c + "," + d + ")");
				}
			}
		}

	}

}
