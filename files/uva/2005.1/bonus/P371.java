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
		String linha = readLn();
		StringTokenizer tks = new StringTokenizer(linha);
		
		long a = Long.parseLong(tks.nextToken());
		long b = Long.parseLong(tks.nextToken());
		
		while (a != 0 || b != 0) {
			
			long inicio = Math.min(a, b);
			long fim = Math.max(a, b);

			long indice = inicio;
			long max = function(indice);

			for (long i = inicio + 1; i <= fim; i++) {
				long aux = function(i);

				if (aux > max) {
					indice = i;
					max = aux;
				}
			}
			
			System.out.println("Between " + inicio + " and " + fim + ", " + indice + " generates the longest sequence of " + max + " values.");
			
			
			
			
			linha = readLn();
			tks = new StringTokenizer(linha);
			
			a = Long.parseLong(tks.nextToken());
			b = Long.parseLong(tks.nextToken());
		}
	}
	
	static long function(long n) {
		long cont = 0;
		
		do {
			
			if (n % 2 == 0) n /= 2;
			else n = 3 * n + 1;
			
			cont++;
			
		} while (n != 1);
		
		return cont;
	}

}
