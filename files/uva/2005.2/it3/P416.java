
class Main {

	static String readLn() {
        String newLine = System.getProperty("line.separator");
        StringBuffer buffer = new StringBuffer();
        int car = -1;
        try {
            car = System.in.read();
            while ((car > 0) && (car != newLine.charAt(0))) {
                buffer.append((char)car);
                car = System.in.read();
            }
            if (car == newLine.charAt(0)) System.in.skip(newLine.length() - 1);
        } catch (java.io.IOException e) { return (null); }
        if ((car < 0) && (buffer.length() == 0)) return (null);
        return (buffer.toString()).trim();
    }
	
	static String[] numerosCompletos = new String[10];
	
	static {
		numerosCompletos[0] = "YYYYYYN";
		numerosCompletos[1] = "NYYNNNN";
		numerosCompletos[2] = "YYNYYNY";
		numerosCompletos[3] = "YYYYNNY";
		numerosCompletos[4] = "NYYNNYY";
		numerosCompletos[5] = "YNYYNYY";
		numerosCompletos[6] = "YNYYYYY";
		numerosCompletos[7] = "YYYNNNN";
		numerosCompletos[8] = "YYYYYYY";
		numerosCompletos[9] = "YYYYNYY";
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(readLn());
		
		while (n != 0) {

			String[] digitos = new String[n];
			
			for (int i = 0; i < digitos.length; i++) {
				digitos[i] = readLn();
			}
			
			boolean completou = true;
			
			for (int i = 9; i >= n - 1; i--) {
				completou = true;
				boolean[] mask = new boolean[7];
				
				for (int j = i; j > i - n; j--) {
					if (burnOn(digitos[i - j], mask)) {
						completou = false;
						break;
					}
					
					if (match(digitos[i - j], numerosCompletos[j])) {
						mark(digitos[i - j], numerosCompletos[j], mask);
					} else {
						completou = false;
						break;
					}
				}
				
				if (completou) break;
			}
			
			if (completou) System.out.println("MATCH");
			else System.out.println("MISMATCH");
			
			
			
			
			n = Integer.parseInt(readLn());
		}
	}
	
	static boolean burnOn(String estado, boolean[] mask) {
		for (int i = 0; i < estado.length(); i++) {
			if (estado.charAt(i) == 'Y' && mask[i]) return true;
		}
		return false;
	}

	static void mark(String estado, String numeroCompleto, boolean[] mask) {
		for (int i = 0; i < numeroCompleto.length(); i++) {
			if (numeroCompleto.charAt(i) == 'Y' && estado.charAt(i) != 'Y') mask[i] = true;
		}
	}

	static boolean match(String estado, String numeroCompleto) {
		for (int i = 0; i < estado.length(); i++) {
			if (estado.charAt(i) == 'Y' && numeroCompleto.charAt(i) != 'Y') return false;
		}
		return true;
	}

}
