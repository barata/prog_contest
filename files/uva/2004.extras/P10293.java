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
        return (buffer.toString()); 
    }

	public static void main(String[] args) {
		String linha = readLn();
		
		while (linha != null) {
			
			// <-- inicio de um caso
			StringBuffer sb = new StringBuffer();
			
			// carrega todo o texto
			while (!linha.equals("#")) {
				
				sb.append(linha);
				
				if (!linha.endsWith("-")) {
					sb.append(" ");
				}
				
				linha = readLn();
			}
			
			// conta as palavras
			StringTokenizer tks = new StringTokenizer(sb.toString(), " ?!,.");
			int[] freq = new int[31];
			
			while (tks.hasMoreTokens()) {
				freq[contaLetras(tks.nextToken())]++;
			}
			
			// <-- fim de um caso
			for (int i = 0; i < freq.length; i++) {
				if (freq[i] > 0) System.out.println(i + " " + freq[i]);
			}
			
			System.out.println();
			
			linha = readLn();
		}
	}
	
	static int contaLetras(String palavra) {
		int cont = 0;
		for (int i = 0; i < palavra.length(); i++) {
			char ch = palavra.charAt(i);
			if (ch != '\'' && ch != '-') cont++;
		}
		return cont;
	}
}
