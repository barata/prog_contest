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

	static char[] caracteres;
	
	static {
		caracteres = new char[256];
		
		caracteres[' '] = ' ';
		
		caracteres['e'] = 'q';
		caracteres['d'] = 'a';
		caracteres['c'] = 'z';
		caracteres['r'] = 'w';
		caracteres['f'] = 's';
		caracteres['v'] = 'x';
		caracteres['t'] = 'e';
		caracteres['g'] = 'd';
		caracteres['b'] = 'c';
		caracteres['y'] = 'r';
		caracteres['h'] = 'f';
		caracteres['n'] = 'v';
		caracteres['u'] = 't';
		caracteres['j'] = 'g';
		caracteres['m'] = 'b';
		caracteres['i'] = 'y';
		caracteres['k'] = 'h';
		caracteres[','] = 'n';
		caracteres['o'] = 'u';
		caracteres['l'] = 'j';
		caracteres['.'] = 'm';
		caracteres['p'] = 'i';
		caracteres[';'] = 'k';
		caracteres['/'] = ',';
		
		caracteres['['] = 'o';
		caracteres[']'] = 'p';
		caracteres['\\'] = '[';
		caracteres['\''] = 'l';
		
		caracteres['2'] = '`';
		caracteres['3'] = '1';
		caracteres['4'] = '2';
		caracteres['5'] = '3';
		caracteres['6'] = '4';
		caracteres['7'] = '5';
		caracteres['8'] = '6';
		caracteres['9'] = '7';
		caracteres['0'] = '8';
		caracteres['-'] = '9';
		caracteres['='] = '0';
	}

	public static void main(String[] args) {
		String linha = readLn(10000000);
		
		System.out.println(traduz(linha));
	}

	private static String traduz(String linha) {
		linha = linha.toLowerCase();
		String result = "";
		for (int i = 0; i < linha.length(); i++) {
			result += caracteres[linha.charAt(i)];
		}
		return result;
	}
}
