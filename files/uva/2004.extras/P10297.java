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
		StringTokenizer tks = new StringTokenizer(linha);
		
		int D = Integer.parseInt(tks.nextToken());
		int V = Integer.parseInt(tks.nextToken());
		
		while (D != 0 || V != 0) {
			
			System.out.println(round(Math.pow(D * D * D - 6 * V / Math.PI, 1.0 / 3), 3));
			
			
			
			linha = readLn();
			tks = new StringTokenizer(linha);
			
			D = Integer.parseInt(tks.nextToken());
			V = Integer.parseInt(tks.nextToken());
		}
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
