import java.util.StringTokenizer;

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
			StringTokenizer tks = new StringTokenizer(readLn());
			
			long a = Long.parseLong(tks.nextToken());
			long b = Long.parseLong(tks.nextToken());
			
			long n = 0;
			int max = 0;
			
			for (long i = a; i <= b; i++) {
				int aux = contaDivisores(i);
				if (aux > max) {
					max = aux;
					n = i;
				}
			}
			
			System.out.println("Between " + a + " and " + b + ", " + n + " has a maximum of " + max + " divisors.");
		}
	}
	
	static int contaDivisores(long numero) {
		int cont = 1;

		long sqrt = Math.round(Math.sqrt(numero));
		for (int i = 2; i <= sqrt; i++) {
			if (numero % i == 0) cont++;
		}
		
		cont *= 2;
		if (sqrt * sqrt == numero) {
			cont--;
		}

		return cont;
	}

}
