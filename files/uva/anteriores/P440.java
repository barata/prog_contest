import java.util.*;
import java.io.*;

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
		return (new String (lin, 0, lg)).trim();
	}

	static Integer[] numeros = new Integer[ 150 ];
	
	static {

		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = new Integer(i + 1);
		}

	}

	public static void main(String[] args) {
	
		String linha;

		linha = readLn(255);

		while (! linha.equals("0") ) {
		
			int n = Integer.parseInt(linha);
			
			for (int m = 2; true; m++) {

				Vector lista = new Vector();

				for (int i = 0; i < n; i++) {
					lista.addElement(numeros[i]);
				}
				
				int indice = 0;

				while (lista.size() != 1) {
				
					lista.removeElementAt(indice);
					indice--;
					indice = (indice + m) % lista.size();
				
				}

				int ultimoElemento = ((Integer) lista.elementAt(0)).intValue();

				if (ultimoElemento == 2) {
					System.out.println(m);
					break;
				}

			}
			
			linha = readLn(255);
		
		}
	
	}

}