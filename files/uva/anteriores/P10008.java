/* @BEGIN_OF_SOURCE_CODE */
/* @JUDGE_ID: 39715JC 10008 JAVA "" */

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
		int[][] somas = new int[ 256 ][ 2 ];
		
		// zera o array
		for (int i = 0; i < somas.length; i++) {
		
			somas[ i ][ 0 ] = 0;
			somas[ i ][ 1 ] = 0;
		
		}
		
		// processa as linha
		for (int i = 0; i < numeroDeTestes; i++) {
		
			linha = ReadLn(255);
			
			for (int j = 0; j < linha.length(); j++) {
			
				char letra = Character.toLowerCase(linha.charAt(j));
				
				if (letra >= 'a' && letra <= 'z') {
					somas[ letra ][ 0 ] = letra;
					somas[ letra ][ 1 ]++;
				}
			
			}
			
		}
		
		// ordena
		for (int i = 1; i < somas.length; i++) {
			for (int j = somas.length - 1; j >= i; j--) {
				
				if (somas[ j - 1 ][ 1 ] < somas[ j ][ 1 ]) {
				
					int[] aux = somas[ j - 1 ];
					somas[ j - 1 ] = somas[ j ];
					somas[ j ] = aux;
				
				}
				
			}
		}
		
		// imprime
		for (int i = 0; i < somas.length; i++) {
			if (somas[ i ][ 1 ] != 0) {
				System.out.println(Character.toUpperCase((char) somas[ i ][ 0 ]) + " " + somas[ i ][ 1 ]);
			}
		}
	}

	public static void main(String args[]) {

		Main app = new Main();
		app.solucao();

	}

}
/* @END_OF_SOURCE_CODE */