import java.io.IOException;
import java.util.StringTokenizer;

class Main {

	static String readLn(int maxLg) { // utility function to read from stdin
		byte lin[] = new byte[maxLg];
		int lg = 0, car = -1;
		String line = "";

		try {
			while (lg < maxLg) {
				car = System.in.read();
				if ((car < 0) || (car == '\n'))
					break;
				lin[lg++] += car;
			}
		} catch (IOException e) {
			return (null);
		}

		if ((car < 0) && (lg == 0))
			return (null); // eof
		return (new String(lin, 0, lg)).trim();
	}

	public static void main(String[] args) {
		int nTestes = Integer.parseInt(readLn(255));
		
		for (int g = 0; g < nTestes; g++) {
			
			int tamanho = Integer.parseInt(readLn(255));
			int[] vagoes = new int[tamanho];
			StringTokenizer tks = new StringTokenizer(readLn(255));
			
			for (int i = 0; i < tamanho; i++) {
				int valor = Integer.parseInt(tks.nextToken());
				
				vagoes[i] = valor;
			}
			
			System.out.println("Optimal train swapping takes " + ordena(vagoes) + " swaps.");
			
		}
	}
	
	static int ordena(int[] array) {
		int cont = 0;
		for (int i = 1; i < array.length; i++) {
			for (int j = array.length - 1; j >= i; j--) {
				if (array[j - 1] > array[j]) {
					int aux = array[j - 1];
					array[j - 1] = array[j];
					array[j] = aux;
					
					cont++;
				}
			}
		}
		return cont;
	}
}
