/* @BEGIN_OF_SOURCE_CODE */
/* @JUDGE_ID: 39715JC 10050 JAVA "" */

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
		int numeroDeTestes = Integer.parseInt(tokens.nextToken());
		
		for (int i = 0; i < numeroDeTestes; i++) {
		
			linha = ReadLn(255);
			tokens = new StringTokenizer(linha);
			int numeroDeDias = Integer.parseInt(tokens.nextToken());
			linha = ReadLn(255);
			tokens = new StringTokenizer(linha);
			int numeroDeFestas = Integer.parseInt(tokens.nextToken());
			
			boolean[] dias = new boolean[ numeroDeDias ];
			// inicializa
			for (int j = 0; j < dias.length; j++) {
				dias[ j ] = false;
			}
			
			for (int j = 0; j < numeroDeFestas; j++) {
			
				linha = ReadLn(255);
				tokens = new StringTokenizer(linha);
				int intervalo = Integer.parseInt(tokens.nextToken());
				
				// processa
				for (int k = intervalo; k > 0 && k <= numeroDeDias; k += intervalo) {
				
					if ((k - 1) % 7 + 1 != 6 && (k - 1) % 7 + 1 != 7) {
						dias[ k - 1 ] = true;
					}
				
				}
			
			}
			
			// imprime resultado
			int count = 0;
			for (int j = 0; j < dias.length; j++) {
			
				if (dias[ j ] == true) {
					count++;
				}
			
			}
			System.out.println(count);
		
		}

	}
	
	public static void main(String args[]) {

		Main app = new Main();
		app.solucao();

	}

}
/* @END_OF_SOURCE_CODE */