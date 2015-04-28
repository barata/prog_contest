/* @BEGIN_OF_SOURCE_CODE */
/* @JUDGE_ID: 39715JC 706 JAVA "" */

import java.util.*;
import java.io.*;

class Main {

	// numeros
	private char numeros[][][] = {
		{
			{ ' ', '-', ' ' },
			{ '|', ' ', '|' },
			{ ' ', ' ', ' ' },       // 0
			{ '|', ' ', '|' },
			{ ' ', '-', ' ' }
		},
		{
			{ ' ', ' ', ' ' },
			{ ' ', ' ', '|' },
			{ ' ', ' ', ' ' },       // 1
			{ ' ', ' ', '|' },
			{ ' ', ' ', ' ' }
		},
		{
			{ ' ', '-', ' ' },
			{ ' ', ' ', '|' },
			{ ' ', '-', ' ' },       // 2
			{ '|', ' ', ' ' },
			{ ' ', '-', ' ' }
		},
		{
			{ ' ', '-', ' ' },
			{ ' ', ' ', '|' },
			{ ' ', '-', ' ' },       // 3
			{ ' ', ' ', '|' },
			{ ' ', '-', ' ' }
		},
		{
			{ ' ', ' ', ' ' },
			{ '|', ' ', '|' },
			{ ' ', '-', ' ' },       // 4
			{ ' ', ' ', '|' },
			{ ' ', ' ', ' ' }
		},
		{
			{ ' ', '-', ' ' },
			{ '|', ' ', ' ' },
			{ ' ', '-', ' ' },       // 5
			{ ' ', ' ', '|' },
			{ ' ', '-', ' ' }
		},
		{
			{ ' ', '-', ' ' },
			{ '|', ' ', ' ' },
			{ ' ', '-', ' ' },       // 6
			{ '|', ' ', '|' },
			{ ' ', '-', ' ' }
		},
		{
			{ ' ', '-', ' ' },
			{ ' ', ' ', '|' },
			{ ' ', ' ', ' ' },       // 7
			{ ' ', ' ', '|' },
			{ ' ', ' ', ' ' }
		},
		{
			{ ' ', '-', ' ' },
			{ '|', ' ', '|' },
			{ ' ', '-', ' ' },       // 8
			{ '|', ' ', '|' },
			{ ' ', '-', ' ' }
		},
		{
			{ ' ', '-', ' ' },
			{ '|', ' ', '|' },
			{ ' ', '-', ' ' },       // 9
			{ ' ', ' ', '|' },
			{ ' ', '-', ' ' }
		}
	};

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

		String linha = ReadLn(200);
		StringTokenizer tokens = new StringTokenizer(linha);
		int size = Integer.parseInt(tokens.nextToken());
		String number = tokens.nextToken();
		
		// remove os zeros do inicio do numero
		number = String.valueOf(Integer.parseInt(number));

		while (size != 0 || Integer.parseInt(number) != 0) {
			/* processa */

			// primeira linha
			for (int i = 0; i < number.length(); i++) {

				System.out.print(" ");
				for (int j = 0; j < size; j++) {
					System.out.print(numeros[Character.getNumericValue(number.charAt(i))][0][1]);
				}
				System.out.print(" ");
				if (i < number.length() - 1) {
					System.out.print(" ");
				}

			}
			System.out.println("");
			// "segunda" linha
			for (int k = 0; k < size; k++) {
				for (int i = 0; i < number.length(); i++) {
	
					System.out.print(numeros[Character.getNumericValue(number.charAt(i))][1][0]);
					for (int j = 0; j < size; j++) {
						System.out.print(" ");
					}
					System.out.print(numeros[Character.getNumericValue(number.charAt(i))][1][2]);
					if (i < number.length() - 1) {
						System.out.print(" ");
					}
				}
				System.out.println("");
			}
			// linha do meio
			for (int i = 0; i < number.length(); i++) {

				System.out.print(" ");
				for (int j = 0; j < size; j++) {

					System.out.print(numeros[Character.getNumericValue(number.charAt(i))][2][1]);
					//System.out.println(number.charAt(i));

				}
				System.out.print(" ");
				if (i < number.length() - 1) {
					System.out.print(" ");
				}

			}
			System.out.println("");
			// "quarta" linha
			for (int k = 0; k < size; k++) {
				for (int i = 0; i < number.length(); i++) {
	
					System.out.print(numeros[Character.getNumericValue(number.charAt(i))][3][0]);
					for (int j = 0; j < size; j++) {
						System.out.print(" ");
					}
					System.out.print(numeros[Character.getNumericValue(number.charAt(i))][3][2]);
					if (i < number.length() - 1) {
						System.out.print(" ");
					}
				}
				System.out.println("");
			}
			// ultima linha
			for (int i = 0; i < number.length(); i++) {

				System.out.print(" ");
				for (int j = 0; j < size; j++) {

					System.out.print(numeros[Character.getNumericValue(number.charAt(i))][4][1]);

				}
				System.out.print(" ");
				if (i < number.length() - 1) {
					System.out.print(" ");
				}

			}
			System.out.println("");

			// re-leitura
			linha = ReadLn(200);
			tokens = new StringTokenizer(linha);
			size = Integer.parseInt(tokens.nextToken());
			number = tokens.nextToken();

			// espacamento
			//if (size != 0 && Integer.parseInt(number) != 0) {
				System.out.println("");
			//}
		}

	}

	public static void main(String args[]) {
		Main app = new Main();
		app.solucao();
	}

}
/* @END_OF_SOURCE_CODE */