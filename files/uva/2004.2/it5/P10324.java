import java.io.IOException;
import java.util.StringTokenizer;

class Main {

	static String readLn(int maxLg) { // utility function to read from stdin
		byte lin[] = new byte[maxLg];
		int lg = 0, car = -1;

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
		int caso = 0;
		
		String numero = readLn(1000001);
		
		while (numero != null && !numero.equals("")) {
			
			// carrega valores
			int[] calculos = new int[numero.length()];
			
			calculos[0] = 1;
			
			for (int i = 1; i < numero.length(); i++) {
				
				if (numero.charAt(i - 1) == numero.charAt(i)) {
					calculos[i] = calculos[i - 1] + 1;
				} else {
					calculos[i] = 1;
				}
				
			}

			System.out.println("Case " + (++caso) + ":");
			
			// le intervalos
			int intervalos = Integer.parseInt(readLn(255));
			
			for (int i = 0; i < intervalos; i++) {
				linha = readLn(255);
				tks = new StringTokenizer(linha);
				
				int a = Integer.parseInt(tks.nextToken());
				int b = Integer.parseInt(tks.nextToken());
				
				int inicio = Math.min(a, b);
				int fim = Math.max(a, b);
				
				// processa
				if (calculos[fim] - calculos[inicio] == fim - inicio) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
				
			}
			
			
			numero = readLn(1000001);
		}
	}
}
