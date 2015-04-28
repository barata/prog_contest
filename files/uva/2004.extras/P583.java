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
	
	static final int MAX = 46341;
	
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
		Long numero = new Long(readLn());
		long numeroLong = numero.longValue();
		
		Hashtable resp = new Hashtable();
		
		while (numeroLong != 0) {
			
			if (resp.containsKey(numero)) {
				System.out.println(resp.get(numero));
			} else {
				String result;
				if (ehPrimo(Math.abs(numeroLong))) {
					result =  numeroLong + " = ";
					if (numeroLong < 0) result += "-1 x ";
					result += Math.abs(numeroLong);
					resp.put(numero, result);
					System.out.println(result);
				} else {
					result = imprimeFatores(numero.longValue());
					resp.put(numero, result);
					System.out.println(result);
				}
			}
			
			numero = new Long(readLn());
			numeroLong = numero.longValue();
		}
	}

	static String imprimeFatores(long numero) {
		boolean imprimeNegativo = numero < 0;
		
		long parcial = numero;
		if (imprimeNegativo) parcial *= -1;
		int resultado = 0;
		int raiz = (int) Math.round(Math.sqrt(parcial));
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(numero + " = ");
		if (imprimeNegativo) sb.append("-1 x ");
		
		boolean ehPrimeiro = true;
		
		for (int indice = 2; indice <= raiz; indice++) {
		
			while ((parcial % indice) == 0) {
				if (!ehPrimeiro) sb.append(" x ");
				ehPrimeiro = false;
				sb.append(indice);
				parcial /= indice;
			}

		}
		
		if (parcial > 1) {
			sb.append(" x ");
			sb.append(parcial);
		}
		
		return sb.toString();
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
