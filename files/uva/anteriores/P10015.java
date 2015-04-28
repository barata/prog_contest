/* @BEGIN_OF_SOURCE_CODE */
/* @JUDGE_ID: 39715JC 10015 JAVA "" */

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

	void solucao() {
		String linha = ReadLn(255);
		StringTokenizer tokens = new StringTokenizer(linha);
		int numeroDePessoas = Integer.parseInt(tokens.nextToken());
		
		while (numeroDePessoas != 0) {
			
			int numeroPrimo = 2;
			boolean[] pessoas = new boolean[ numeroDePessoas ];
			// inicializa array
			for (int i = 0; i < pessoas.length; i++) {
				pessoas[ i ] = true;
			}
			
			int pessoasRestantes = numeroDePessoas;
			int count = -1;
			// processa array
			while (pessoasRestantes > 1) {
				if (ehPrimo(numeroPrimo)) {
				
					// percorre as pessoas
					int passos = numeroPrimo;

					while (passos > 0) {

						count = (count + 1) % numeroDePessoas;

						if (pessoas[ count ] == true) {
							passos--;
						}

					}
					pessoas[ count ] = false;
					pessoasRestantes--;
				
				}
				numeroPrimo++;
			}
			
			int resposta = -1;
			// resultado
			for (int i = 0; i < pessoas.length; i++) {

				if (pessoas[ i ] == true) {
					resposta = i + 1;
					break;
				}
			
			}
			System.out.println(resposta);
		
			// redefinicao da variavel
			linha = ReadLn(255);
			tokens = new StringTokenizer(linha);
			numeroDePessoas = Integer.parseInt(tokens.nextToken());
		}
		
	}
	
	boolean ehPrimo(int numero) {
	
		for (int i = 2; i <= Math.sqrt(numero); i++) {
		
			if (numero % i == 0) {
				return false;
			}
		
		}
		return true;
	
	}

	public static void main(String args[]) {

		Main app = new Main();
		app.solucao();

	}

}
/* @END_OF_SOURCE_CODE */