import java.util.Hashtable;
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
		
		int m = Integer.parseInt(tks.nextToken());
		int n = Integer.parseInt(tks.nextToken());
		
		Hashtable tabela = new Hashtable();
		
		for (int i = 0; i < m; i++) {
			linha = readLn();
			tks = new StringTokenizer(linha);
			
			String palavra = tks.nextToken();
			Integer valor = new Integer(tks.nextToken());
			
			tabela.put(palavra, valor);
		}
		
		for (int i = 0; i < n; i++) {
			linha = readLn();
			
			int soma = 0;
			
			while (!linha.equals(".")) {
				tks = new StringTokenizer(linha);
				while (tks.hasMoreTokens()) {
					String palavra = tks.nextToken();
					
					if (tabela.containsKey(palavra)) {
						soma += ((Integer) tabela.get(palavra)).intValue();
					}
				}
				
				linha = readLn();
			}
			
			System.out.println(soma);
		}

	}
	
	
}
