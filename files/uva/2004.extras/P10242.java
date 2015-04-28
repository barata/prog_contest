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
		
		while (linha != null) {
			StringTokenizer tks = new StringTokenizer(linha);
			
			Ponto[] pontos = new Ponto[4];
			
			Ponto vertice = null, ponto1 = null, ponto2 = null;
			
			// monta os pontos
			for (int k = 0; k < 4; k++) {
				double x = new Double(tks.nextToken()).doubleValue();
				double y = new Double(tks.nextToken()).doubleValue();
				
				pontos[k] = new Ponto(x, y);
			}
			
			// busca o vertice
			for (int i = 0; i < 3; i++) {
				Ponto a = pontos[i];
				for (int j = i + 1; j < 4; j++) {
					Ponto b = pontos[j];
					
					if (a.equals(b)) {
						vertice = a;
						break;
					}
				}
			}
			
			// busca os pontos restantes
			boolean achou = false;
			for (int i = 0; i < 4; i++) {
				Ponto a = pontos[i];
				
				if (!vertice.equals(a)) {
					if (achou) ponto2 = a;
					else {
						ponto1 = a;
						achou = true;
					}
				}
			}
			
			double x1 = ponto1.x - vertice.x;
			double y1 = ponto1.y - vertice.y;
			double x2 = ponto2.x - vertice.x;
			double y2 = ponto2.y - vertice.y;
			double x = x1 + x2 + vertice.x;
			double y = y1 + y2 + vertice.y;
			
			System.out.println(round(x, 3) + " " + round(y, 3));
			
			
			linha = readLn();
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
class Ponto {
	
	public double x;
	public double y;

	public Ponto(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Object o) {
		if (!(o instanceof Ponto)) return false;
		
		Ponto p = (Ponto) o;
		return p.x == this.x && p.y == this.y;
	}

}