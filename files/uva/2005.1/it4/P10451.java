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
		StringTokenizer tks = new StringTokenizer(readLn());
		
		int nTeste = 0;
		
		int n = Integer.parseInt(tks.nextToken());
		double A = new Double(tks.nextToken()).doubleValue();
		
		while (n >= 3) {
			
			double area = A / n;
			double cos = Math.cos(Math.PI / n);
			
			double menorRaio = Math.sqrt((area * cos) / Math.sqrt(1 - cos * cos));
			double maiorRaio = menorRaio / cos;
			
			double maiorArea = Math.PI * maiorRaio * maiorRaio;
			double menorArea = Math.PI * menorRaio * menorRaio;
		
			
			
			System.out.println("Case " + (++nTeste) + ": " + round(maiorArea - A, 5) + " " + round(A - menorArea, 5));
			
			
			tks = new StringTokenizer(readLn());
			
			n = Integer.parseInt(tks.nextToken());
			A = new Double(tks.nextToken()).doubleValue();
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
