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
		int numero = Integer.parseInt(readLn(8));
		
		while (numero != 0) {
			
			int result = 0;
			
			for (int i = 2; i <= numero; i++) {
				
				if (numero % i == 0 && ehPrimo(i)) result++;

			}
			
			System.out.println(numero + " : " + result);
			
			numero = Integer.parseInt(readLn(8));
		}
	}
	
	static boolean ehPrimo(int numero) {
		for (int i = 2; i <= Math.sqrt(numero); i++) {
			if (numero % i == 0) return false;
		}
		return true;
	}

}
