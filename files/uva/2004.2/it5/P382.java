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
		String linha = readLn(1000);
		StringTokenizer tks = new StringTokenizer(linha);

		int valor = Integer.parseInt(tks.nextToken());
		
		System.out.println("PERFECTION OUTPUT");
		
		while (valor != 0) {

			int soma = somaDivisores(valor);
			String resultado = rightJustify(String.valueOf(valor), 5);

			if (valor == 1) {
				resultado += "  DEFICIENT";
			} else {
				if (soma == valor) {
					resultado += "  PERFECT";
				} else if (soma > valor) {
					resultado += "  ABUNDANT";
				} else {
					resultado += "  DEFICIENT";
				}
			}
			
			System.out.println(resultado);
			

			if (! tks.hasMoreTokens() )  {
				linha = readLn(1000);
				tks = new StringTokenizer(linha);
			}
			valor = Integer.parseInt(tks.nextToken());
		}
		
		System.out.println("END OF OUTPUT");
	}
	
	static int somaDivisores(int numero) {
		int soma = 1;

		for (int i = 2; i <= Math.round(Math.sqrt(numero)); i++) {
			if (numero % i == 0) {
				soma += i;
				if (numero / i != i) {
					soma += numero / i;
				}
			}
		}

		return soma;
	}
	
	static String rightJustify(String linha, int n) {
		return str(' ', n - linha.length()) + linha;
	}
	
	static String str(char ch, int n) {
		String resultado = "";

		for (int i = 0; i < n; i++) {
			resultado += ch;
		}
		
		return resultado;
	}
}
