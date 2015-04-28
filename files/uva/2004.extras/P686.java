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
		int n = Integer.parseInt(readLn());
		
		while (n != 0) {
			
			int cont = 0;
			
			if (ehPrimo(n - 2)) cont++;
			
			for (int i = 3; i <= n / 2; i += 2) {

				if (ehPrimo(i) && ehPrimo(n - i)) {
					cont++;
				}
				
			}
			
			System.out.println(cont);
			
			
			n = Integer.parseInt(readLn());
		}
	}
	
	static boolean ehPrimo(int n) {
		long raiz = Math.round(Math.sqrt(n));
		
		for (int i = 2; i <= raiz; i++) {
			if (n % i == 0) return false;
		}
		
		return true;
	}

}
