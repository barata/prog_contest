import java.io.IOException;
import java.util.Stack;
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
	
	static int cont;
	
	static Stack[] pinos = new Stack[3];
	
	static int numeroDeJogadas;

	public static void main(String[] args) {
		String linha;
		StringTokenizer tks;
		
		linha = readLn(255);
		tks = new StringTokenizer(linha);
		
		int nCase = 0;
		
		pinos[0] = new Stack();
		pinos[1] = new Stack();
		pinos[2] = new Stack();
		
		int numeroDeDiscos = Integer.parseInt(tks.nextToken());
		numeroDeJogadas = Integer.parseInt(tks.nextToken());
		
		while (numeroDeDiscos != 0 || numeroDeJogadas != 0) {
			
			reset(numeroDeDiscos);
			
			nCase++;
			
			System.out.println("Problem #" + nCase + "\n");
			
			try {
				solucao(numeroDeDiscos, 0, 2, 1);
			} catch (RuntimeException e) {}
			if (numeroDeJogadas > 0) {
				imprimePinos(pinos);
				System.out.println();
			}
			
			
			linha = readLn(255);
			tks = new StringTokenizer(linha);
			
			numeroDeDiscos = Integer.parseInt(tks.nextToken());
			numeroDeJogadas = Integer.parseInt(tks.nextToken());
		}
	}
	
	static void reset(int nDiscos) {
		cont = 0;
		
		for (int i = 0; i < pinos.length; i++) {
			pinos[i].removeAllElements();
		}
		
		for (int i = nDiscos; i >= 1; i--) {
			pinos[0].push(new Integer(i));
		}
	}
	
	static void imprimePinos(Stack[] pinos) {
		System.out.print("A=>");
		if (!pinos[0].empty()) {
			System.out.print("  ");
			for (int i = 0; i < pinos[0].size(); i++) {
				System.out.print(" " + pinos[0].elementAt(i));
			}
		}
		System.out.println();
		
		System.out.print("B=>");
		if (!pinos[1].empty()) {
			System.out.print("  ");
			for (int i = 0; i < pinos[1].size(); i++) {
				System.out.print(" " + pinos[1].elementAt(i));
			}
		}
		System.out.println();
		
		System.out.print("C=>");
		if (!pinos[2].empty()) {
			System.out.print("  ");
			for (int i = 0; i < pinos[2].size(); i++) {
				System.out.print(" " + pinos[2].elementAt(i));
			}
		}
		System.out.println();
	}
	
	static void processaMovimento(int o, int d) {
		imprimePinos(pinos);
		System.out.println();
		pinos[d].push(pinos[o].pop());
	}
	
	static void solucao(int n, int o, int d, int a) {
		if (n == 1) {
			++cont;
			processaMovimento(o, d);
			if (cont >= numeroDeJogadas) throw new RuntimeException();
		} else {
			solucao(n - 1, o, a, d);
			++cont;
			processaMovimento(o, d);
			if (cont >= numeroDeJogadas) throw new RuntimeException();
			solucao(n - 1, a, d, o);
		}
	}
}
