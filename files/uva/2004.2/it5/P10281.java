import java.io.IOException;
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
        return (buffer.toString());
    }

	public static void main(String[] args) {
		String linha = readLn();
		StringTokenizer tks = new StringTokenizer(linha);
		
		String tempoStr = tks.nextToken().trim();
		int tempoInicial = getTempo(tempoStr);
		int velocidade = 0;
		if (tks.hasMoreTokens()) {
			velocidade = Integer.parseInt(tks.nextToken());
		} else {
			System.out.println(tempoStr + " 0.00 km");
		}
		double distancia = 0;
		
		
		linha = readLn();
		
		while (linha != null) {
			
			tks = new StringTokenizer(linha);
			tempoStr = tks.nextToken();
			int tempoFinal = getTempo(tempoStr);
			
			distancia += (tempoFinal - tempoInicial) * velocidade / 3600d;
			
			if (tks.hasMoreTokens()) {

				velocidade = Integer.parseInt(tks.nextToken());

			} else {
				
				System.out.println(tempoStr + " " + round(distancia) + " km");
				
			}
			
			tempoInicial = tempoFinal;
			
			linha = readLn();
		}
	}
	
	static String round(double numero) {
		String resultado = "";
		
		int aux = (int) Math.round(numero * 100);
		
		resultado += aux / 100;
		resultado += ".";
		String resto = "" + (aux % 100);
		if (resto.length() == 1) resto = "0" + resto;
		
		return resultado + resto;
	}
	
	static int getTempo(String valor) {
		StringTokenizer tks = new StringTokenizer(valor, ":");
		
		int resultado = Integer.parseInt(tks.nextToken()) * 3600;
		resultado += Integer.parseInt(tks.nextToken()) * 60;
		resultado += Integer.parseInt(tks.nextToken());
		
		return resultado;
	}

}