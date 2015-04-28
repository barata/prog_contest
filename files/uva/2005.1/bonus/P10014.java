
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
		int nCasos = Integer.parseInt(linha);
		
		for (int a = 0; a < nCasos; a++) {
			// skip a line
			readLn();
			
			int n = Integer.parseInt(readLn());
			double first = new Double(readLn()).doubleValue();
			double last = new Double(readLn()).doubleValue();
			
			// calc
			double somatorio = 0;
			
			for (int i = 0; i < n; i++) {
				double valor = new Double(readLn()).doubleValue();
				
				somatorio += (n - i) * valor;
			}
			
			double a1 = ((n * first + last) - 2 * somatorio) / (n + 1);
			
			System.out.println(round(a1, 2));
			
			if (a < nCasos - 1) System.out.println();

		}

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
