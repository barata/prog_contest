import java.util.Hashtable;

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
	
	static Hashtable tabela;

	public static void main(String[] args) {
		String linha = readLn();
		
		while (linha != null) {
			int b = Integer.parseInt(linha);
			int p = Integer.parseInt(readLn());
			int m = Integer.parseInt(readLn());
			
			tabela = new Hashtable();
			
			System.out.println(potencia(b, p, m));
			
			
			readLn();
			linha = readLn();
		}
	}
	
	static int potencia(int b, int p, int m) {
		if (tabela.containsKey(new Integer(p))) {
			return ((Integer) tabela.get(new Integer(p))).intValue();
		}
		
		if (p == 0) return 1;
		if (p == 1) return b;
		
		int valor = ((potencia(b, (p / 2) + (p % 2), m) % m) * (potencia(b, p / 2, m) % m)) % m;
		tabela.put(new Integer(p), new Integer(valor));
		
		return valor;
	}

}
