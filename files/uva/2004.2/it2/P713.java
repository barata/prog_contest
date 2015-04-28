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
		int nTestes = Integer.parseInt(readLn(255));
		StringTokenizer tks;
		
		for (int c = 0; c < nTestes; c++) {
			
			tks = new StringTokenizer(readLn(500));
			String numero1 = tks.nextToken();
			String numero2 = tks.nextToken();
			
			numero1 = inverte(numero1);
			numero2 = inverte(numero2);
			
			System.out.println(inverte(soma(numero1, numero2)));
			
		}
	}
	
	static String soma(String n1, String n2) {
		// deixa as duas strings com o mesmo tamanho
		int numeroDeZeros = n1.length() - n2.length();
		if (numeroDeZeros < 0) {
			n1 = str(-1* numeroDeZeros) + n1;
		} else if (numeroDeZeros > 0) {
			n2 = str(numeroDeZeros) + n2;
		}
		
		// soma
		int carry = 0;
		String result = "";
		
		for (int i = n1.length() - 1; i >= 0; i--) {
			int dig1 = Character.getNumericValue(n1.charAt(i));
			int dig2 = Character.getNumericValue(n2.charAt(i));

			int s = dig1 + dig2 + carry;
			
			result = (s % 10) + result;
			carry = s / 10;
		}
		if (carry != 0) {
			result = carry + result;
		}
		
		
		return result;
	}
	
	static String str(int n) {
		String aux = "";
		for (int i = 0; i < n; i++) {
			aux += '0';
		}
		return aux;
	}
	
	static String inverte(String numero) {
		String aux = "";
		
		for (int i = numero.length() - 1; i >= 0; i--) {
			aux += numero.charAt(i);
		}
		
		int primeiroDigitoValido = 0;
		while (primeiroDigitoValido < aux.length() && aux.charAt(primeiroDigitoValido) == '0') {
			primeiroDigitoValido++;
		}
		aux = aux.substring(primeiroDigitoValido, aux.length());
		if (aux.equals("")) aux = "0";

		return aux;
	}

}
