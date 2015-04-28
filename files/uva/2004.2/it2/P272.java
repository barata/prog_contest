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
	
	static int count = 0;

	public static void main(String[] args) {
		String linha = readLn(1000);
		
		
		while (linha != null) {
			
			String result = "";
			
			for (int i = 0; i < linha.length(); i++) {
				if (linha.charAt(i) == '\"') {
					result += getNextChar();
				} else {
					result += linha.charAt(i);
				}
			}
			
			System.out.println(result);
			
			linha = readLn(1000);
		}
	}
	
	static String getNextChar() {
		String result = "";
		
		if (count == 0) result = "``";
		if (count == 1) result = "''";
		
		count = (count + 1) % 2;
		
		return result;
	}
}
