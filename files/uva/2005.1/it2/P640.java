
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
	
	static final int MAX = 1000000;
	
	public static void main(String[] args) {
		boolean[] numeros = new boolean[MAX + 1];
		
		for (int i = 0; i <= MAX; i++) {
			int generated = generate(i);
			if (generated <= MAX) numeros[generated] = true;
		}
		
		for (int i = 0; i < numeros.length; i++) {
			if (!numeros[i]) System.out.println(i);
		}
	}
	
	static int generate(int n) {
		return n + somaDigitos(n);
	}
	
	static int somaDigitos(int numero) {
		int resultado = 0;
		
		while (numero != 0) {
			resultado += numero % 10;
			numero /= 10;
		}
		
		return resultado;
	}

}
