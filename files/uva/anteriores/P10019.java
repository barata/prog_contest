/* @BEGIN_OF_SOURCE_CODE */
/* @JUDGE_ID: 39715JC 10019 JAVA "" */

import java.util.*;
import java.io.*;

class Main {

	static String ReadLn (int maxLg)  // utility function to read from stdin
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
		return (new String (lin, 0, lg));
	}

	int numeroDeUms(int numero) {
	
		if (numero >= 2) {
			return numeroDeUms(numero / 2) + numero % 2;
		}
		return numero % 2;
	
	}

	int processaComoHexa(int numero) {
	
		String linha = String.valueOf(numero);
		int count = 0;
		for (int i = 0; i < linha.length(); i++) {
			count += numeroDeUms(Character.getNumericValue(linha.charAt(i)));
		}
		return count;
	
	}

	void solucao() {

		String linha = ReadLn(255);
		StringTokenizer tokens = new StringTokenizer(linha);
		int numeroDeCasos = Integer.parseInt(tokens.nextToken());
		
		for (int i = 0; i < numeroDeCasos; i++) {
		
			linha = ReadLn(255);
			tokens = new StringTokenizer(linha);
			int valor = Integer.parseInt(tokens.nextToken());
			
			System.out.println(numeroDeUms(valor) + " " + processaComoHexa(valor));
		
		}

	}

	public static void main(String args[]) {

		Main app = new Main();
		app.solucao();

	}

}
/* @END_OF_SOURCE_CODE */