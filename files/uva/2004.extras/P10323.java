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
		String linha = readLn();
		
		while (linha != null) {
			
			long n = Long.parseLong(linha);
			
			if (n < 0) {
				
				if (n % 2 == 0) System.out.println("Underflow!");
				else System.out.println("Overflow!");
				
			} else {
			
				if (n < 8) System.out.println("Underflow!");
				else if (n > 13) System.out.println("Overflow!");
				else System.out.println(fat(n));
			
			}
			
			linha = readLn();
		}
	}

	private static long fat(long n) {
		long resultado = 1;
		
		for (long i = 2; i <= n; i++) {
			resultado *= i;
		}
		
		return resultado;
	}

}
