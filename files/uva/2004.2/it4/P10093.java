import java.io.IOException;

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

	static byte[] mapa = new byte[ 256 ];

	static {
	
		for (int i = 0; i < mapa.length; i++) {
			mapa[ i ] = 0;
		}
	
		mapa['0'] = 0;
		mapa['1'] = 1;
		mapa['2'] = 2;
		mapa['3'] = 3;
		mapa['4'] = 4;
		mapa['5'] = 5;
		mapa['6'] = 6;
		mapa['7'] = 7;
		mapa['8'] = 8;
		mapa['9'] = 9;
		mapa['A'] = 10;
		mapa['B'] = 11;
		mapa['C'] = 12;
		mapa['D'] = 13;
		mapa['E'] = 14;
		mapa['F'] = 15;
		mapa['G'] = 16;
		mapa['H'] = 17;
		mapa['I'] = 18;
		mapa['J'] = 19;
		mapa['K'] = 20;
		mapa['L'] = 21;
		mapa['M'] = 22;
		mapa['N'] = 23;
		mapa['O'] = 24;
		mapa['P'] = 25;
		mapa['Q'] = 26;
		mapa['R'] = 27;
		mapa['S'] = 28;
		mapa['T'] = 29;
		mapa['U'] = 30;
		mapa['V'] = 31;
		mapa['W'] = 32;
		mapa['X'] = 33;
		mapa['Y'] = 34;
		mapa['Z'] = 35;
		mapa['a'] = 36;
		mapa['b'] = 37;
		mapa['c'] = 38;
		mapa['d'] = 39;
		mapa['e'] = 40;
		mapa['f'] = 41;
		mapa['g'] = 42;
		mapa['h'] = 43;
		mapa['i'] = 44;
		mapa['j'] = 45;
		mapa['k'] = 46;
		mapa['l'] = 47;
		mapa['m'] = 48;
		mapa['n'] = 49;
		mapa['o'] = 50;
		mapa['p'] = 51;
		mapa['q'] = 52;
		mapa['r'] = 53;
		mapa['s'] = 54;
		mapa['t'] = 55;
		mapa['u'] = 56;
		mapa['v'] = 57;
		mapa['w'] = 58;
		mapa['x'] = 59;
		mapa['y'] = 60;
		mapa['z'] = 61;
	
	}

	public static void main(String args[]) {

		String linha = readLn(10000);
		
		while (linha != null) {
			int base = 0;
			long soma = 0;

			// acha a menor base possivel e a soma dos digitos
			for (int i = 0; i < linha.length(); i++) {
				char ch = linha.charAt(i);
				
				int valor = mapa[ch];
				if (valor > base) {
					base = valor;
				}
				soma += valor;
			}
		
			
			if (base == 0) {
				System.out.println("2");
			} else {
				boolean achou = false;
				
				int i = 0;
				for (i = base; !achou && i <= 61; i++) {
					if (soma % i == 0) achou = true;
				}

				if (achou) {
					System.out.println(i);
				} else {
					System.out.println("such number is impossible!");
				}
			}
				
			linha = readLn(10000);
		}
	}

}