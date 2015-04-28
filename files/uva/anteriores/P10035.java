/* @BEGIN_OF_SOURCE_CODE */
/* @JUDGE_ID: 39715JC 10035 JAVA "" */

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

		String numero1 = tokens.nextToken();
		String numero2 = tokens.nextToken();

		int[][] tabela = new int[ 2 ][ 10 ];
		
		while (!numero1.equals("0") || !numero2.equals("0")) {
		
			// zera tabela
			for (int i = 0; i < tabela[0].length; i++) {
				tabela[ 0 ][ i ] = 0;
				tabela[ 1 ][ i ] = 0;
			}
			
			// passa o numero 1
			for (int i = numero1.length() - 1; i >= 0; i--) {
				tabela[ 0 ][ numero1.length() - 1 - i ] = Character.getNumericValue(numero1.charAt(i));
			}
			
			// passa o numero 2
			for (int i = numero2.length() - 1; i >= 0; i--) {
				tabela[ 1 ][ numero2.length() - 1 - i ] = Character.getNumericValue(numero2.charAt(i));
			}
			
			// imprime
			int count = 0;
			int vaiUm = 0;
			
			for (int i = 0; i < tabela[0].length; i++) {

					int soma = tabela[ 0 ][ i ] + tabela[ 1 ][ i ] + vaiUm;
					tabela[ 1 ][ i ] = soma % 10;
					vaiUm = soma / 10;

					if (vaiUm == 1) {
						count++;
					}
			}
			
			if (count == 0) {
				System.out.print("No carry operation");
			}
			else {
				System.out.print(count + " carry operation");
				if (count > 1) {
					System.out.print("s");
				}
			}
			System.out.println(".");

			linha = ReadLn(255);
			tokens = new StringTokenizer(linha);

			numero1 = tokens.nextToken();
			numero2 = tokens.nextToken();
		}

	}

	public static void main(String args[]) {

		Main app = new Main();
		app.solucao();

	}

}
/* @END_OF_SOURCE_CODE */