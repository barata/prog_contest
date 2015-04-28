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
		try{
		String linha;
		
		linha = readLn();
		
		while (linha != null) {
			StringTokenizer tks = new StringTokenizer(linha);
			
			int d = Integer.parseInt(tks.nextToken()) + 6440;
			double angulo = Integer.parseInt(tks.nextToken());
			String tipo = tks.nextToken();
			
			if (tipo.equals("min")) {
				angulo /= 60;
			}
			
			angulo = angulo % 360;
			if (angulo > 180) angulo = 360 - angulo;
			angulo = toRadians(angulo);
			
			double arc = d * angulo;
			double chord = 2 * d * Math.sin(angulo / 2);

			System.out.println(round(arc, 1000000) + " " + round(chord, 1000000));
			
			
			linha = readLn();
		}
		} catch (Exception e) {while(true);}
	}
	
	static String round(double valor, int casas) {
		long numero = Math.round(valor * casas);

		String retorno = "" + numero / casas;
		retorno += ".";
		String resto = "" + (numero % casas);
		resto = str('0', 6 - resto.length()) + resto;
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
	
	static double toRadians(double valor) {
		return valor * Math.PI / 180;
	}
}
