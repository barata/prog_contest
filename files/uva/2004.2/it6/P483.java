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
		String linha;
		StringTokenizer tks;
		
		linha = readLn();
		
		while (linha != null) {
			tks = new StringTokenizer(linha);
			
			
			while (tks.hasMoreTokens()) {
				System.out.print(inverte(tks.nextToken()));
				
				if (tks.hasMoreTokens()) System.out.print(" ");
			}
			
			System.out.println();
			
			linha = readLn();
		}
	}
	
	static String inverte(String palavra) {
		String resultado = "";
		
		for (int i = palavra.length() - 1; i >= 0; i--) {
			resultado += palavra.charAt(i);
		}
		
		return resultado;
	}
}
