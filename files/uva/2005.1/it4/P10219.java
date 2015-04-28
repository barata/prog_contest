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
		
		while (linha != null) {
			StringTokenizer tks = new StringTokenizer(linha);
			
			int n = Integer.parseInt(tks.nextToken());
			int k = Integer.parseInt(tks.nextToken());
			k = Math.max(n - k, k);
			int d = n - k;
			
			double soma = 0;
			
			for (int i = n; i > k; i--) {
				
				soma += log10(i);
				soma -= log10(d);
				if (d > 1) d--;
				
			}
			
			int resultado = (int) Math.floor(soma) + 1;
			
			System.out.println(resultado);
			
			
			
			linha = readLn();
		}
	}
	
	static double log10(int valor) {
		return Math.log(valor) / Math.log(10);
	}

}
