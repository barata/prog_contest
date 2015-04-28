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
            if (car == newLine.charAt(0)) 
            System.in.skip(newLine.length() - 1); 
        } catch (java.io.IOException e) { return (null);} 
        if ((car < 0) && (buffer.length() == 0)) return (null); 
        return (buffer.toString()).trim(); 
    }

	public static void main(String[] args) {

		int nTestes = Integer.parseInt(readLn());
		
		for (int g = 0; g < nTestes; g++) {
			
			String texto1 = readLn();
			String texto2 = readLn();

			long numero1 = Long.parseLong(texto1, 2);
			long numero2 = Long.parseLong(texto2, 2);
			
			if (temDivisorComum(numero1, numero2)) {
				System.out.println("Pair #" + (g + 1) + ": All you need is love!");
			} else {
				System.out.println("Pair #" + (g + 1) + ": Love is not all you need!");
			}

		}

	}
	
	static boolean temDivisorComum(long n1, long n2) {
		return gcd(n1, n2) != 1;
	}
	
	static long gcd(long m, long n) {
		if ((m % n) == 0)
			return n;
		else
			return gcd(n, m % n);
	}

}
