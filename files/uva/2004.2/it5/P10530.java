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
	
	static final String HIGH = "too high";
	
	static final String LOW = "too low";
	
	static final String RIGHT = "right on";

	public static void main(String[] args) {
		int numero;
		String comando;
		
		boolean honest = false;
		int min = 1;
		int max = 10;
		
		numero = Integer.parseInt(readLn(10));
		
		while (numero != 0) {
		
			comando = readLn(50);

			if (numero >= min && numero <= max) {
				// processa
				if (comando.equals(RIGHT)) {
					// processa
					if (numero >= min && numero <= max) honest = true;
					
				} else if (comando.equals(HIGH)) {
					
					max = numero - 1;
					
				} else if (comando.equals(LOW)) {
					
					min = numero + 1;
					
				}
			}
			
			if (comando.equals(RIGHT)) {
				if (honest) {
					System.out.println("Stan may be honest");
				} else {
					System.out.println("Stan is dishonest");
				}
				
				// reseta variaveis
				honest = false;
				min = 1;
				max = 10;
			}
			
			numero = Integer.parseInt(readLn(10));
		}

	}
}
