import java.io.IOException;

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
		String linha = readLn(255);
		
		while (linha != null && !linha.equals("")) {
			int numero = Integer.parseInt(linha);
			
			int dividendo = 1;
			int resto = 0;
			int resultado = 0;
			
			do {
				
				resto = dividendo % numero;
				dividendo = resto * 10 + 1;
				resultado++;
				
			} while (resto != 0);
			
			System.out.println(resultado);
			
			linha = readLn(255);
		}
	}

}
