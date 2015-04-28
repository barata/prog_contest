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
			
			int step = Integer.parseInt(tks.nextToken());
			int mod = Integer.parseInt(tks.nextToken());
			
			boolean[] array = new boolean[mod];
			
			int posicao = 0;
			array[posicao] = true;
			
			posicao = (posicao + step) % mod;
			
			while (! array[posicao] ) {
				array[posicao] = true;
				
				posicao = (posicao + step) % mod;
			}
			
			String resultado = "Good Choice";
			
			for (int i = 0; i < array.length; i++) {
				if (! array[i] ) {
					resultado = "Bad Choice";
					break;
				}
			}
			
			System.out.println(formata(step, 10) + formata(mod, 10) + "    " + resultado);
			System.out.println();
			
			linha = readLn();
		}
	}
	
	static String formata(int numero, int espaco) {
		String n = "" + numero;
		
		return str(' ', espaco - n.length()) + n;
	}
	
	static String str(char ch, int n) {
		String resultado = "";
		for (int i = 0; i < n; i++) {
			resultado += ch;
		}
		return resultado;
	}
}
