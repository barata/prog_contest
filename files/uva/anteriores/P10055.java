/* @BEGIN_OF_SOURCE_CODE */
/* @JUDGE_ID: 39715JC 10055 JAVA "" */

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
		
		
		while (linha != null && !linha.equals("")) {
			StringTokenizer tokens = new StringTokenizer(linha);
		
			long a = Long.parseLong(tokens.nextToken());
			long b = Long.parseLong(tokens.nextToken());
			
			System.out.println(Math.abs(a - b));

			linha = ReadLn(255);
		}
	
	}
	
	public static void main(String args[]) {

		Main app = new Main();
		app.solucao();

	}

}
/* @END_OF_SOURCE_CODE */