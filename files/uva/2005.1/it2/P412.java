import java.util.Vector;

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
		int n = Integer.parseInt(readLn());
		
		while (n != 0) {
			
			int[] conjunto = new int[n];
			
			for (int i = 0; i < n; i++) {
				conjunto[i] = Integer.parseInt(readLn());
			}
			
			Vector pares = new Vector();
			
			for (int i = 0; i < conjunto.length - 1; i++) {
				for (int j = i + 1; j < conjunto.length; j++) {
					pares.addElement(new Par(conjunto[i], conjunto[j]));
				}
			}
			
			int resultado = contaPares(pares);
			
			if (resultado == 0) {
				System.out.println("No estimate for this data set.");
			} else {
				double pi = Math.sqrt(6.0 * pares.size() / resultado);
				
				System.out.println(round(pi, 6));
			}
			
			
			n = Integer.parseInt(readLn());
		}
	}
	
	static int contaPares(Vector pares) {
		int cont = 0;
		
		for (int i = 0; i < pares.size(); i++) {
			Par p = (Par) pares.elementAt(i);
			
			if (!temDivisorComum(p.valor1, p.valor2)) cont++;
		}
		
		return cont;
	}
	
	static boolean temDivisorComum(long n1, long n2) {
		return gcd(n1, n2) != 1;
	}
	
	static long gcd(long m, long n) {
		if ((m % n) == 0)
			return n;
		else
			return gcd(n, m % n);
	}

	static String round(double valor, int casas) {
		long numero = Math.round(valor * Math.pow(10, casas));
		
		String retorno;
		if (numero < 0) retorno = "-";
		else retorno = "";
		retorno += (Math.abs(numero) / (long) Math.pow(10, casas));
		retorno += ".";
		String resto = "" + (Math.abs(numero) % (long) Math.pow(10, casas));
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

class Par {
	public int valor1;
	public int valor2;
	
	public Par(int valor1, int valor2) {
		this.valor1 = valor1;
		this.valor2 = valor2;
	}
	
	public boolean equals(Object o) {
		if (!(o instanceof Par)) return false;
		
		Par p = (Par) o;
		return (this.valor1 == p.valor1 && this.valor2 == p.valor2);
	}
}