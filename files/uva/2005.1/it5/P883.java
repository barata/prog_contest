import java.util.StringTokenizer;
import java.util.Vector;

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
		int nTestes = Integer.parseInt(readLn());
		
		for (int g = 0; g < nTestes; g++) {
			readLn();
			
			int nr = Integer.parseInt(readLn());
			
			Vector figuras = new Vector();
			
			for (int k = 0; k < nr; k++) {
				StringTokenizer tks = new StringTokenizer(readLn());
				
				double x1 = new Double(tks.nextToken()).doubleValue();
				double y1 = new Double(tks.nextToken()).doubleValue();
				double x2 = new Double(tks.nextToken()).doubleValue();
				double y2 = new Double(tks.nextToken()).doubleValue();
				
				figuras.addElement(new Retangulo(Math.min(x1, x2), Math.max(y1, y2), Math.max(x1, x2), Math.min(y1, y2)));
			}
			
			int nl = Integer.parseInt(readLn());
			
			for (int k = 0; k < nl; k++) {
				double y = new Double(readLn()).doubleValue();
				
				Vector filtradas = filtra(figuras, y);
				Vector pontos = new Vector();

				for (int i = 0; i < filtradas.size(); i++) {
					Retangulo ret = (Retangulo) filtradas.elementAt(i);
					
					pontos.addElement(new Ponto(ret.x1, true));
					pontos.addElement(new Ponto(ret.x2, false));
				}
				
				ordena(pontos);
				
				int cont = 0;
				double x = 0;
				double x1 = 0;
				double x2 = 0;
				int max = -1;
				
				for (int i = 0; i < pontos.size(); i++) {
					Ponto p = (Ponto) pontos.elementAt(i);
					
					if (p.inicio) {
						x = p.x;
						cont++;
					} else {
						if (cont > max) {
							x1 = x;
							x2 = p.x;
							max = cont;
						}
						cont--;
					}
				}
				
				if (max > 0) {
					System.out.println(max + " " + round(x1, 2) + " " + round(x2, 2));
				} else {
					System.out.println(0);
				}
				
			}
			
			if (g < nTestes - 1) System.out.println();
		}
	}
	
	static Vector filtra(Vector figuras, double y) {
		Vector res = new Vector();
		
		for (int i = 0; i < figuras.size(); i++) {
			Retangulo ret = (Retangulo) figuras.elementAt(i);
			
			if (y < ret.y1 && y > ret.y2) res.addElement(ret);
		}
		
		return res;
	}
	
	static void ordena(Vector lista) {
		for (int i = 1; i < lista.size(); i++) {
			for (int j = lista.size() - 1; j >= i; j--) {
				Ponto p1 = (Ponto) lista.elementAt(j - 1);
				Ponto p2 = (Ponto) lista.elementAt(j);
				
				if (p1.compareTo(p2) > 0) {
					lista.setElementAt(p2, j - 1);
					lista.setElementAt(p1, j);
				}
			}
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

class Retangulo {
	public double x1;
	public double y1;
	public double x2;
	public double y2;
	
	public Retangulo(double x1, double y1, double x2, double y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

}

class Ponto {
	public double x;
	public boolean inicio;
	
	public Ponto(double x, boolean inicio) {
		this.x = x;
		this.inicio = inicio;
	}
	
	public int compareTo(Object o) {
		Ponto p = (Ponto) o;
		
		long pV = Math.round(p.x * 100000);
		long tV = Math.round(this.x * 100000);
		
		return (int) (tV - pV);
	}

}