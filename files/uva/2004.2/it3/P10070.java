/* @BEGIN_OF_SOURCE_CODE */
/* @JUDGE_ID: 39715JC 10070 JAVA "" */

import java.io.IOException;

class Main {

	static String readLn (int maxLg)  // utility function to read from stdin
	{
		byte lin[] = new byte [maxLg];
		int lg = 0, car = -1;
		String line = "";

		try
		{
			while (lg < maxLg)
			{
				car = System.in.read();
				if ((car < 0) || (car == '\n')) break;
				lin [lg++] += car;
			}
		}
		catch (IOException e)
		{
			return (null);
		}

		if ((car < 0) && (lg == 0)) return (null);  // eof
		return (new String (lin, 0, lg).trim());
	}

	boolean isLeap(String ano) {
	
		return (div4(ano) && !div100(ano)) || div400(ano);
	
	}

	boolean isHuluculu(String ano) {
	
		return div15(ano);
	
	}

	boolean isBulukulu(String ano) {
	
		return div55(ano) && isLeap(ano);
	
	}
	
	boolean div4(String numero) {
		int doisUltimosDigitos = Integer.parseInt(numero.substring(numero.length() - 2, numero.length()));
		return doisUltimosDigitos % 4 == 0;
	}
	
	boolean div100(String numero) {
		return numero.charAt(numero.length() - 2) == '0' && numero.charAt(numero.length() - 1) == '0';
	}
	
	boolean div400(String numero) {
		return div100(numero) && div4(numero.substring(0, numero.length() - 2));
	}
	
	boolean div15(String numero) {
		if (numero.charAt(numero.length() - 1) != '0' && numero.charAt(numero.length() - 1) != '5') return false;
		
		int soma = 0;
		for (int i = 0; i < numero.length(); i++) {
			soma += Character.getNumericValue(numero.charAt(i));
		}
		return soma % 3 == 0;
	}
	
	boolean div55(String numero) {
		if (numero.charAt(numero.length() - 1) != '0' && numero.charAt(numero.length() - 1) != '5') return false;
		
		int somaPares = 0;
		int somaImpares = 0;
		for (int i = 0; i < numero.length(); i++) {
			int valor = Character.getNumericValue(numero.charAt(i));
			if (i % 2 == 0) somaPares += valor;
			else somaImpares += valor;
		}
		return Math.abs(somaPares - somaImpares) % 11 == 0;
	}

	void solucao() {
	
		String numero = readLn(1000000);
		boolean pulaLinha = false;
		
		while (numero != null) {
		
			if (!numero.equals("")) {

				if (pulaLinha) System.out.println();
				
				if (isLeap(numero)) {
					System.out.println("This is leap year.");
				}
				if (isHuluculu(numero)) {
					System.out.println("This is huluculu festival year.");
				}
				if (isBulukulu(numero)) {
					System.out.println("This is bulukulu festival year.");
				}
				if (!isLeap(numero) && !isHuluculu(numero) && !isBulukulu(numero)) {
					System.out.println("This is an ordinary year.");
				}
				
				pulaLinha = true;

			}
			
			
			numero = readLn(1000000);

		}
	
	}

	public static void main(String args[]) {

		Main app = new Main();
		app.solucao();

	}

}
/* @END_OF_SOURCE_CODE */