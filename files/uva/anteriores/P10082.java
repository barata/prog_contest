/* @BEGIN_OF_SOURCE_CODE */
/* @JUDGE_ID: 39715JC 10082 JAVA "" */

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

	static char[] mapa = new char[ 256 ];

	static {
	
		// inicializa
		for (int i = 0; i < mapa.length; i++) {
			mapa[ i ] = 0;
		}
	
		// linha 1
		mapa[ '1' ] = '`';
		mapa[ '2' ] = '1';
		mapa[ '3' ] = '2';
		mapa[ '4' ] = '3';
		mapa[ '5' ] = '4';
		mapa[ '6' ] = '5';
		mapa[ '7' ] = '6';
		mapa[ '8' ] = '7';
		mapa[ '9' ] = '8';
		mapa[ '0' ] = '9';
		mapa[ '-' ] = '0';
		mapa[ '=' ] = '-';
	
		// linha 2
		mapa[ 'W' ] = 'Q';
		mapa[ 'E' ] = 'W';
		mapa[ 'R' ] = 'E';
		mapa[ 'T' ] = 'R';
		mapa[ 'Y' ] = 'T';
		mapa[ 'U' ] = 'Y';
		mapa[ 'I' ] = 'U';
		mapa[ 'O' ] = 'I';
		mapa[ 'P' ] = 'O';
		mapa[ '[' ] = 'P';
		mapa[ ']' ] = '[';
		mapa[ '\\' ] = ']';
		
		// linha 3
		mapa[ 'S' ] = 'A';
		mapa[ 'D' ] = 'S';
		mapa[ 'F' ] = 'D';
		mapa[ 'G' ] = 'F';
		mapa[ 'H' ] = 'G';
		mapa[ 'J' ] = 'H';
		mapa[ 'K' ] = 'J';
		mapa[ 'L' ] = 'K';
		mapa[ ';' ] = 'L';
		mapa[ '\'' ] = ';';
		
		// linha 4
		mapa[ 'X' ] = 'Z';
		mapa[ 'C' ] = 'X';
		mapa[ 'V' ] = 'C';
		mapa[ 'B' ] = 'V';
		mapa[ 'N' ] = 'B';
		mapa[ 'M' ] = 'N';
		mapa[ ',' ] = 'M';
		mapa[ '.' ] = ',';
		mapa[ '/' ] = '.';

	}

	void solucao() {

		String linha = ReadLn(255);
		
		while (linha != null & !linha.equals("")) {
		
			for (int i = 0; i < linha.length(); i++) {
			
				char c = linha.charAt(i);
				if (mapa[ c ] != 0) {
					System.out.print(mapa[ c ]);
				}
				else {
					System.out.print(c);
				}
			
			}
			System.out.println();
			
			linha = ReadLn(255);
		
		}

	}
	
	public static void main(String args[]) {

		Main app = new Main();
		app.solucao();

	}

}
/* @END_OF_SOURCE_CODE */