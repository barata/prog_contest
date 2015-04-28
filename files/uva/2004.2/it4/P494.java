import java.io.IOException;

class Main {

	static String readLn(int maxLg) { // utility function to read from stdin
		byte lin[] = new byte[maxLg];
		int lg = 0, car = -1;

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
		String linha = readLn(1000);
		
		while (linha != null) {
			
			int cont = 0;
			boolean lendo = false;
			
			for (int i = 0; i < linha.length(); i++) {
				char ch = Character.toLowerCase(linha.charAt(i));
				
				if (!lendo) {
					if (ch >= 'a' && ch <= 'z') {
						cont++;
						lendo = true;
					}
				} else {
					if (!(ch >= 'a' && ch <= 'z')) {
						lendo = false;
					}
				}
			}
			
			System.out.println(cont);
			
			
			linha = readLn(1000);
		}
	}
}
