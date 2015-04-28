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
		StringTokenizer tks = new StringTokenizer(linha, ":");
		
		int h = Integer.parseInt(tks.nextToken());
		int m = Integer.parseInt(tks.nextToken());
		
		while (h != 0 || m != 0) {
			
			double angulo = Math.abs(6 * m - (30 * h + m / 2.0));
			angulo %= 360;
			if (angulo > 180) angulo = 360 - angulo;
			
			System.out.println(round(angulo, 3));
			
			
			linha = readLn();
			tks = new StringTokenizer(linha, ":");
			
			h = Integer.parseInt(tks.nextToken());
			m = Integer.parseInt(tks.nextToken());
		}
	}
	
	static String round(double valor, int casas) {
		long numero = (long) (valor * Math.pow(10, casas));
		
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
