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
		long l = Long.parseLong(tks.nextToken());
		
		int nTeste = 0;
		
		while (a >= 0 && l >= 0) {
			
			System.out.println("Case " + (++nTeste) + ": A = " + a + ", limit = " + l + ", number of terms = " + executa(a, l));
			
			
			
			linha = readLn();
			tks = new StringTokenizer(linha);
			
			a = Long.parseLong(tks.nextToken());
			l = Long.parseLong(tks.nextToken());
		}
	}

	static long executa(long a, long l) {
		long cont = 0;
		
		while (a != 1 && a <= l) {
			if (a % 2 == 0) a /= 2;
			else a = 3 * a + 1;
			
			cont++;
		}
		
		if (a == 1) cont++;
		
		return cont;
	}
}
