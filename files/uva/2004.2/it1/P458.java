import java.io.IOException;

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
		
		while (linha != null && !linha.equals("")) {
			
			decoder(linha);
			
			
			linha = readLn(255);
		}
	}
	
	static void decoder(String linha) {
		for (int i = 0; i < linha.length(); i++) {
			System.out.print((char) ((int) linha.charAt(i) - 7));
		}
		System.out.println();
	}
}
