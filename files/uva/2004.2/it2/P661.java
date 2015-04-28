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
		int count = 1;
		
		linha = readLn(255);
		tks = new StringTokenizer(linha);
		
		int n = Integer.parseInt(tks.nextToken());
		int m = Integer.parseInt(tks.nextToken());
		int c = Integer.parseInt(tks.nextToken());
		
		while (n != 0 || m != 0 || c != 0) {
			
			int[] array = new int[n + 1];
			int potenciaParcial = 0;
			int maiorPotencia = 0;
			boolean queimou = false;
			
			for (int i = 1; i < array.length; i++) {
				linha = readLn(255);
				array[i] = Integer.parseInt(linha);
			}
			
			for (int i = 0; i < m; i++) {
				linha = readLn(255);
				int dispositivo = Integer.parseInt(linha);
				
				if (potenciaParcial + array[dispositivo] > c) {
					queimou = true;
				}

				if (!queimou) {
					if (potenciaParcial + array[dispositivo] > maiorPotencia) maiorPotencia = potenciaParcial + array[dispositivo];
					potenciaParcial += array[dispositivo];
					array[dispositivo] *= -1;
				}
			}
			
			System.out.println("Sequence " + (count++));
			if (queimou) {
				System.out.println("Fuse was blown.\n");
			}
			else {
				System.out.println("Fuse was not blown.");
				System.out.println("Maximal power consumption was " + maiorPotencia + " amperes.\n");
			}
			
			
			
			
			linha = readLn(255);
			tks = new StringTokenizer(linha);
			
			n = Integer.parseInt(tks.nextToken());
			m = Integer.parseInt(tks.nextToken());
			c = Integer.parseInt(tks.nextToken());
		}
	}
}
