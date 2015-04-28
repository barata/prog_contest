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

	public static void main( String[ ] args ) {
		String linha = readLn();
		
		while (linha != null) {
			StringTokenizer tks = new StringTokenizer(linha);
		
			int[] polinomio = new int[tks.countTokens()];
			
			for (int i = polinomio.length - 1; i >= 0; i--) {
				polinomio[i] = Integer.parseInt(tks.nextToken());
			}
			
			StringBuffer sb = new StringBuffer();
			tks = new StringTokenizer(readLn());
			
			while (tks.hasMoreTokens()) {
				int valor = Integer.parseInt(tks.nextToken());
				
				sb.append(avaliar(polinomio, valor));
				if (tks.hasMoreTokens()) sb.append(" ");
			}
			
			System.out.println(sb);
			
			
			
			linha = readLn();
		}
	}

	static int avaliar(int[] polinomio, int valor) {
		int resultado = 0;
		
		for (int i = 0; i < polinomio.length; i++) {
			resultado += polinomio[i] * (int) Math.round(Math.pow(valor, i));
		}
		
		return resultado;
	}

}
