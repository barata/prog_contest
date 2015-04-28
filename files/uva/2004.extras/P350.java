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
		
		int nTeste = 0;
		
		int z = Integer.parseInt(tks.nextToken());
		int i = Integer.parseInt(tks.nextToken());
		int m = Integer.parseInt(tks.nextToken());
		int l = Integer.parseInt(tks.nextToken());
		
		while (z != 0 || i != 0 || m != 0 || l != 0) {
			
			boolean[] array = new boolean[m];
			int cont = 0;
			
			l = (z * l + i) % m;
			
			while (! array[l] ) {
				array[l] = true;
				cont++;
				
				l = (z * l + i) % m;
			}
			
			System.out.println("Case " + (++nTeste) + ": " + cont);
			
			
			
			
			linha = readLn();
			tks = new StringTokenizer(linha);
			
			z = Integer.parseInt(tks.nextToken());
			i = Integer.parseInt(tks.nextToken());
			m = Integer.parseInt(tks.nextToken());
			l = Integer.parseInt(tks.nextToken());
		}
	}

}
