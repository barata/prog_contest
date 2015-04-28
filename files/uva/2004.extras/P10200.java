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
	
	static final double EPS = 0.0000001;
	
	static final int MAX = 10001;

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
				t.put(new Integer(i), "s");
			} else {
				t.put(new Integer(i), "");
			}
		}
		
	}

	public static void main(String[] args) {
		String linha = readLn();
		
		while (linha != null) {
			StringTokenizer tks = new StringTokenizer(linha);
			
			int a = Integer.parseInt(tks.nextToken());
			int b = Integer.parseInt(tks.nextToken());
			
			long qntTotal = b - (a - 1);
			
			long qntFormula = 0;
			
			for (int i = a; i <= b; i++) {
				if (ehPrimo(formula(i))) qntFormula++;
			}

			System.out.println(round(qntFormula * 100.0D / qntTotal, 2));
			
			linha = readLn();
		}
	}

	static int formula(int n) {
		return n * n + n + 41;
	}

	static boolean ehPrimo(int numero) {
		Integer intN = new Integer(numero);
		if (t.containsKey(intN)) {
			String valor = (String) t.get(intN);
			return (valor.equals("s"));
		}
		
		for (int i = 0; numerosPrimos[i] <= Math.sqrt(numero) && i < cont; i++) {
			if (numero % numerosPrimos[i] == 0) {
				t.put(intN, "");
				return false;
			}
		}
		t.put(intN, "s");
		return true;
	}
	
	static String round(double valor, int casas) {
		valor += EPS;
		long numero = Math.round(valor * Math.pow(10, casas));
		
		String retorno = "" + (numero / (long) Math.pow(10, casas));
		retorno += ".";
		String resto = "" + (numero % (long) Math.pow(10, casas));
		resto = str('0', casas - resto.length()) + resto;
		retorno += resto;
		
		return retorno;
	}
	
	static String str(char ch, int n) {
		String resultado = "";
		for (int i = 0; i < n; i++) {
			resultado += ch;
		}
		return resultado;
	}

}
