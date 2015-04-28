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
			int numero = Integer.parseInt(linha);
			
			int p1 = numero & 255;
			int p2 = numero & (255 << 8);
			int p3 = numero & (255 << 16);
			int p4 = numero & (255 << 24);
			
			p1 = p1 << 24;
			p2 = p2 << 8;
			p3 = p3 >>> 8;
			p4 = p4 >>> 24;
			
			System.out.println(numero + " converts to " + (p1 + p2 + p3 + p4));
			
			linha = readLn(255);
		}
	}
}
