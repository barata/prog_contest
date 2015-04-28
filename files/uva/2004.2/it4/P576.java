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
		String linha = readLn(255);
		StringTokenizer tks = new StringTokenizer(linha, "/");
		
		String parte1 = tks.nextToken();
		String parte2 = tks.nextToken();
		String parte3 = tks.nextToken();
		
		while (!parte1.equals("e") || !parte2.equals("o") || !parte3.equals("i")) {
			
			
			int sib1 = contaSilabas(parte1);
			int sib2 = contaSilabas(parte2);
			int sib3 = contaSilabas(parte3);
			
			if (sib1 != 5) {
				System.out.println("1");
			} else if (sib2 != 7) {
				System.out.println("2");
			} else if (sib3 != 5) {
				System.out.println("3");
			} else {
				System.out.println("Y");
			}
			
			
			
			
			linha = readLn(255);
			tks = new StringTokenizer(linha, "/");
			
			parte1 = tks.nextToken();
			parte2 = tks.nextToken();
			parte3 = tks.nextToken();
		}
	}
	
	static int contaSilabas(String linha) {
		int cont = 0;
		boolean achou = false;
		
		for (int i = 0; i < linha.length(); i++) {
			char ch = linha.charAt(i);
			
			if (!achou && ehVogal(ch)) {
				cont++;
				achou = true;
			}
			
			if (!ehVogal(ch)) achou = false;
			
		}
		
		
		return cont;
	}
	
	static boolean ehVogal(char ch) {
		return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'y';
	}
	
}
