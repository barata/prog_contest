
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
			
			double l = new Double(linha).doubleValue();
			
			l *= Math.sin(toRadians(108)) / Math.sin(toRadians(63));
			
			System.out.println(round(l, 10));
			
			
			linha = readLn();
		}
	}
	
	static double toRadians(double grau) {
		return grau * Math.PI / 180;
	}
	
	static String round(double valor, int casas) {
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
