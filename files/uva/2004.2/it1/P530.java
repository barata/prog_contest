import java.io.IOException;
import java.util.StringTokenizer;

class Main {

	static String readLn(int maxLg) { // utility function to read from stdin
		byte lin[] = new byte[maxLg];
		int lg = 0, car = -1;
		String line = "";

		try {
			while (lg < maxLg) {
				car = System.in.read();
				if ((car < 0) || (car == '\n'))
					break;
				lin[lg++] += car;
			}
		} catch (IOException e) {
			return (null);
		}

		if ((car < 0) && (lg == 0))
			return (null); // eof
		return (new String(lin, 0, lg)).trim();
	}

	public static void main(String[] args) {
		String linha;
		StringTokenizer tks;

		linha = readLn(255);
		
		while (! linha.equals("0 0") ) {
			
			tks = new StringTokenizer(linha);
			long n = Long.parseLong(tks.nextToken());
			long k = Long.parseLong(tks.nextToken());
			
			System.out.println(Math.round(calcula(n, k)));
			
			linha = readLn(255);
		}
	}
	
	static double calcula(double n, double k) {
		if (n == k || k == 0) return 1;
		if (k == 1) return n;
		
		k = Math.min(k, n - k);

		double result = 1;
		for (double i = 1; i <= k; i++) {
			result *= n;
			result /= i;
			n--;
		}
		return result;
	}

}
