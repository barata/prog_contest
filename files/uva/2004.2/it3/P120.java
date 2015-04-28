import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

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
		String linha = readLn(255);
		StringTokenizer tks;
		Vector pilha;
		
		while (linha != null) {
			pilha = new Vector();
			
			tks = new StringTokenizer(linha);
			while (tks.hasMoreTokens()) {
				pilha.addElement(new Integer(tks.nextToken()));
			}
			
			System.out.println(linha);
			
			int cont = pilha.size() - 1;
			while (cont > 0) {
				int elemento = ((Integer) pilha.elementAt(cont)).intValue();
				int maior = getMaior(pilha, cont);
				int positionDoMaior = getPosition(maior, pilha);

				if (elemento != maior) {
					if (positionDoMaior != 0) {
						inverte(pilha, positionDoMaior);
					}
					inverte(pilha, cont);
				}
				cont--;
			}
			
			System.out.println("0");
			
			
			linha = readLn(255);
		}
	}
	
	static void imprime(Vector lista) {
		for (int i = 0; i < lista.size(); i++) {
			System.out.print(" " + lista.elementAt(i));
		}
		System.out.println();
	}
	
	static void inverte(Vector pilha, int inicio) {
		int tamanhoDaPilha = inicio + 1;
		
		for (int i = 0; i < tamanhoDaPilha / 2; i++) {
			Object o1 = pilha.elementAt(i);
			Object o2 = pilha.elementAt(tamanhoDaPilha - (i + 1));
			
			pilha.setElementAt(o1, tamanhoDaPilha - (i + 1));
			pilha.setElementAt(o2, i);
		}

		System.out.print((pilha.size() - inicio) + " ");
	}
	
	static int getMaior(Vector lista, int fim) {
		int maior = 0;
		for (int i = 0; i <= fim; i++) {
			int aux = ((Integer) lista.elementAt(i)).intValue();
			maior = Math.max(maior, aux);
		}
		return maior;
	}
	
	static int getPosition(int valor, Vector lista) {
		for (int i = 0; i < lista.size(); i++) {
			int aux = ((Integer) lista.elementAt(i)).intValue();
			if (valor == aux) return i;
		}
		return -1;
	}
}
