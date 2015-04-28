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
	
	static final int MAX = 31623;
	
	static int[] numerosPrimos = new int[MAX];
	
	static int cont;
	
	static Hashtable t;
	
	static {
		t = new Hashtable();
		
		boolean[] primos = new boolean[MAX];
		
		int i, j;

		primos[2] = true;
		primos[3] = true;

		for (i = 5; i < MAX; i += 2) {
			for (j = 3; j * j <= i; j += 2)
				if (i % j == 0)
					break;
			if (i % j != 0)
				primos[i] = true;
		}
		
		cont = 0;
		
		for (i = 2; i < MAX; i++) {
			if (primos[i]) {
				numerosPrimos[cont++] = i;
				t.put(new Long(i), "s");
			} else {
				t.put(new Long(i), "");
			}
		}
		
	}

	public static void main(String[] args) {
		int nTestes = Integer.parseInt(readLn());
		
		Hashtable resp = new Hashtable();
		
		for (int g = 0; g < nTestes; g++) {

			Long numero = new Long(readLn());
			
			if (resp.containsKey(numero)) {
				System.out.println(resp.get(numero));
			} else {
				long numeroLong = numero.longValue();
				
				numeroLong++;
				while (ehPrimo(numeroLong)) {
					numeroLong++;
				}
				
				while (somaDigitos(numeroLong) != somaFatores(numeroLong)) {
					numeroLong++;
					while (ehPrimo(numeroLong)) {
						numeroLong++;
					}
				}
				
				resp.put(numero, new Long(numeroLong));
				
				System.out.println(numeroLong);
			}
			
		}
	}

	static int somaDigitos(long numero) {
		int resultado = 0;
		
		while (numero != 0) {
			resultado += numero % 10;
			numero /= 10;
		}
		
		return resultado;
	}

	static int somaFatores(long numero) {
		long parcial = numero;
		int resultado = 0;
		int raiz = (int) Math.round(Math.sqrt(numero));
		
		for (int indice = 2; indice <= raiz; indice++) {
		
			while ((parcial % indice) == 0) {
				resultado += somaDigitos(indice);
				parcial /= indice;
			}

		}
		
		if (parcial > 1) {
			resultado += somaDigitos(parcial);
		}

		return resultado;
	}

	static boolean ehPrimo(long numero) {
		Long longN = new Long(numero);
		
		if (t.containsKey(longN)) {
			String valor = (String) t.get(longN);
			return (valor.equals("s"));
		}
		
		for (int i = 0; numerosPrimos[i] <= Math.sqrt(numero) && i < cont; i++) {
			if (numero % numerosPrimos[i] == 0) {
				t.put(longN, "");
				return false;
			}
		}
		t.put(longN, "s");
		return true;
	}
}
