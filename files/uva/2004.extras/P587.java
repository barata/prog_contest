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
		
		int nTeste = 1;
		
		while (!linha.equals("END")) {
			StringTokenizer tks = new StringTokenizer(linha, ",.");
			
			double x = 0;
			double y = 0;
			
			while (tks.hasMoreTokens()) {
				String token = tks.nextToken();
				
				x += getSteps(token) * Math.cos(getAngle(token));
				y += getSteps(token) * Math.sin(getAngle(token));
			}
			
			System.out.println("Map #" + (nTeste++));
			System.out.println("The treasure is located at (" + round(x, 3) + "," + round(y, 3) + ").");
			System.out.println("The distance to the treasure is " + round(Math.sqrt(x * x + y * y), 3) + ".");
			System.out.println();
			
			
			linha = readLn();
		}
	}

	static int getSteps(String token) {
		return Integer.parseInt(token.substring(0, getLimit(token)));
	}
	
	static double getAngle(String token) {
		String legend = token.substring(getLimit(token));
		
		if (legend.equals("E")) return 0;
		if (legend.equals("NE")) return Math.PI / 4;
		if (legend.equals("N")) return Math.PI / 2;
		if (legend.equals("NW")) return 3 * Math.PI / 4;
		if (legend.equals("W")) return Math.PI;
		if (legend.equals("SW")) return 5 * Math.PI / 4;
		if (legend.equals("S")) return 3 * Math.PI / 2;
		if (legend.equals("SE")) return 7 * Math.PI / 4;
		
		else while (true);
	}
	
	static int getLimit(String token) {
		int cont = 0;

		for (cont = 0; cont < token.length(); cont++) {
			if (!Character.isDigit(token.charAt(cont)))
				break;
		}

		return cont;
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
