import java.io.IOException;

class Main {

	static String readLn (int maxLg)   {
        byte lin[] = new byte [maxLg];
        int lg = 0, car = -1;
        String line = "";
        try {
            while (lg < maxLg) {
                car = System.in.read();
                if ((car < 0) || (car == '\n')) break;
                lin [lg++] += car;
        }}
        catch (IOException e) { return (null); }
        if ((car < 0) && (lg == 0)) return (null);  // eof
        return (new String (lin, 0, lg)).trim();
    }

	public static void main(String[] args) {
		String linha = readLn(10);
		
		while (linha != null && !linha.equals("")) {
			int numero = Integer.parseInt(linha);
			
			processa(numero);
			
			linha = readLn(10);
		}
	}
	
	static void processa(int numero) {
		
		if (!ehPrimo(numero)) {
			System.out.println(numero + " is not prime.");
		} else {
			int invNum = inverte(numero);
			if (invNum != numero && ehPrimo(inverte(numero))) {
				System.out.println(numero + " is emirp.");
			} else {
				System.out.println(numero + " is prime.");
			}
		}

	}
	
	static int inverte(int numero) {
		String n = String.valueOf(numero);
		String result = "";
		
		for (int i = n.length()- 1; i >= 0; i--) {
			result += n.charAt(i);
		}
		
		return Integer.parseInt(result);
	}

	static boolean ehPrimo(int numero) {
		for (int i = 2; i <= Math.sqrt(numero); i++) {
			if (numero % i == 0) return false;
		}
		return true;
	}

}
