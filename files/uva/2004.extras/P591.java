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
		int nBlocos = Integer.parseInt(linha);
		
		int nTeste = 0;
		
		while (nBlocos != 0) {
			
			int[] tamanhos = new int[nBlocos];
			
			linha = readLn();
			StringTokenizer tks = new StringTokenizer(linha);
			
			int soma = 0;
			
			for (int i = 0; i < nBlocos; i++) {
				tamanhos[i] = Integer.parseInt(tks.nextToken());
				soma += tamanhos[i];
			}
			
			int media = soma / nBlocos;
			
			int cont = 0;
			
			for (int i = 0; i < nBlocos; i++) {
				if (tamanhos[i] > media) cont += tamanhos[i] - media;
			}
			
			System.out.println("Set #" + (++nTeste));
			System.out.println("The minimum number of moves is " + cont + ".\n");
			
			
			linha = readLn();
			nBlocos = Integer.parseInt(linha);
		}
	}
}
