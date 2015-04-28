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
			
		// le figuras
		Vector figuras = new Vector();
		
		String linha = readLn();
		while (!linha.equals("*")) {
			StringTokenizer tks = new StringTokenizer(linha);
			
			char tipo = tks.nextToken().charAt(0);
			
			switch (tipo) {
				case 'r':
					double x1 = new Double(tks.nextToken()).doubleValue();
					double y1 = new Double(tks.nextToken()).doubleValue();
					double x2 = new Double(tks.nextToken()).doubleValue();
					double y2 = new Double(tks.nextToken()).doubleValue();
					
					figuras.addElement(new Retangulo(x1, y1, x2, y2));
					break;
				case 'c':
					double x = new Double(tks.nextToken()).doubleValue();
					double y = new Double(tks.nextToken()).doubleValue();
					double raio = new Double(tks.nextToken()).doubleValue();
					
					figuras.addElement(new Circulo(x, y, raio));
					break;
			}
			
			
			linha = readLn();
		}
		
		// le pontos
		Vector pontos = new Vector();
		
		linha = readLn();
		while (!linha.equals("9999.9 9999.9")) {
			StringTokenizer tks = new StringTokenizer(linha);
			
			double x1 = new Double(tks.nextToken()).doubleValue();
			double y1 = new Double(tks.nextToken()).doubleValue();
			
			pontos.addElement(new Ponto(x1, y1));
			
			linha = readLn();
		}
		
		for (int i = 0; i < pontos.size(); i++) {
			Ponto p = (Ponto) pontos.elementAt(i);
			boolean estaContido = false;
			
			for (int j = 0; j < figuras.size(); j++) {
				Figura fig = (Figura) figuras.elementAt(j);
				
				if (fig.contains(p)) {
					estaContido = true;
					System.out.println("Point " + (i + 1) + " is contained in figure " + (j + 1));
				}
			}
			
			if (!estaContido) {
				System.out.println("Point " + (i + 1) + " is not contained in any figure");
			}
		}

	}

}

interface Figura {
	public boolean contains(Ponto p);
}

class Ponto {
	public double x;
	public double y;
	
	public Ponto(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double distancia(Ponto p) {
		return this.distancia(p.x, p.y);
	}

	public double distancia(double x, double y) {
		double dX = this.x - x;
		double dY = this.y - y;
		
		return Math.sqrt(dX * dX + dY * dY);
	}
}

class Retangulo implements Figura {
	public Ponto upperLeft;
	public Ponto lowerRight;
	
	public Retangulo(double x1, double y1, double x2, double y2) {
		this(new Ponto(x1, y1), new Ponto(x2, y2));
	}
	
	public Retangulo(Ponto upperLeft, Ponto lowerRight) {
		this.upperLeft = upperLeft;
		this.lowerRight = lowerRight;
	}
	
	public boolean contains(Ponto p) {
		return p.x > this.upperLeft.x && p.x < this.lowerRight.x && p.y > this.lowerRight.y && p.y < this.upperLeft.y;
	}
}

class Circulo implements Figura {
	public Ponto centro;
	public double raio;
	
	public Circulo(double x, double y, double raio) {
		this(new Ponto(x, y), raio);
	}
	
	public Circulo(Ponto centro, double raio) {
		this.centro = centro;
		this.raio = raio;
	}
	
	public boolean contains(Ponto p) {
		return this.centro.distancia(p) < this.raio;
	}
}