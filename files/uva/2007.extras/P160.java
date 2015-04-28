
class Main {

	static String readLn() {
        String newLine = System.getProperty("line.separator");
        StringBuffer buffer = new StringBuffer();
        int car = -1;
        try {
            car = System.in.read();
            while ((car > 0) && (car != newLine.charAt(0))) {
                buffer.append((char)car);
                car = System.in.read();
            }
            if (car == newLine.charAt(0))
            System.in.skip(newLine.length() - 1);
        } catch (java.io.IOException e) { return (null);}
        if ((car < 0) && (buffer.length() == 0)) return (null);
        return (buffer.toString()).trim();
    }

	static boolean[] primes = new boolean[101];
	
	static {
		int i, j;

		for (i = 0; i < primes.length; i++) {
			primes[i] = false;
		}

		primes[2] = true;
		primes[3] = true;

		for (i = 5; i < primes.length; i += 2) {
			for (j = 3; j * j <= i; j += 2)
				if (i % j == 0) break;
			if (i % j != 0) primes[i] = true;
		}
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(readLn());
		
		while (n != 0) {
			int[] count = new int[primes.length];
			
			for (int fat = n; fat >= 2; fat--) {
				int nFat = fat;

				for (int i = 2; i < primes.length; i++) {
					if (primes[i]) {

						while (nFat % i == 0) {
							count[i]++;
							nFat /= i;
						}
					}
				}
			}
			
			System.out.print(rjust(Integer.toString(n), 3) + "! =");
			int accum = 1;
			for (int i = 2; i <= n; i++) {
				if (primes[i]) {
					if (accum % 16 == 0) System.out.print("\n      ");
					System.out.print(rjust(Integer.toString(count[i]), 3));
					accum++;
				}
			}
			System.out.println();
			
			
			n = Integer.parseInt(readLn());
		}
	}

	static String rjust(String str, int casas) {
	    return str(' ', casas - str.length()) + str;
	}
	
	static String str(char ch, int n) {
	    String resultado = "";
	    for (int i = 0; i < n; i++) {
	        resultado += ch;
	    }
	    return resultado;
	}

}
