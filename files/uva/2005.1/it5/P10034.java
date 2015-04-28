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
			
			int n = Integer.parseInt(readLn());
			
			Vector grafo = new Vector(n);
			
			for (int i = 0; i < n; i++) {
				StringTokenizer tks = new StringTokenizer(readLn());
				
				grafo.addElement(new No(new Double(tks.nextToken()).doubleValue(), new Double(tks.nextToken()).doubleValue()));
			}
			
			System.out.println(round(MST(grafo), 2));
			
			if (g < nTestes - 1) System.out.println();
		}
	}

	static double MST(Vector grafo) {
		double soma = 0;
		
		No no = null;
		if (!grafo.isEmpty()) {
			no = (No) grafo.elementAt(0);
			no.d = 0;
		}
		
		while (!grafo.isEmpty()) {
			no = extractMin(grafo);
			soma += no.d;
			
			for (int i = 0; i < grafo.size(); i++) {
				No current = (No) grafo.elementAt(i);
				double dist = distancia(no, current);
				
				if (dist < current.d) {
					current.d = dist;
				}
			}
		}
		
		
		return soma;
	}
	
	static No extractMin(Vector grafo) {
		No min = new No(0, 0);
		min.d = Double.MAX_VALUE;
		int indice = -1;
		
		for (int i = 0; i < grafo.size(); i++) {
			No current = (No) grafo.elementAt(i);
			
			if (current.d < min.d) {
				min = current;
				indice = i;
			}
		}
		
		grafo.removeElementAt(indice);
		return min;
	}
	
	static double distancia(No no1, No no2) {
		double deltaX = no1.x - no2.x;
		double deltaY = no1.y - no2.y;
		
		return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
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
class No {
	
	public double x;
	public double y;
	public double d;
	
	public No(double x, double y) {
		this.x = x;
		this.y = y;
		this.d = Double.MAX_VALUE;
	}
	
}