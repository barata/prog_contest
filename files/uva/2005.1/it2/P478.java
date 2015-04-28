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
			double x1;
			double y1;
			double x2;
			double y2;
			double x3;
			double y3;
			
			switch (tipo) {
				case 'r':
					x1 = new Double(tks.nextToken()).doubleValue();
					y1 = new Double(tks.nextToken()).doubleValue();
					x2 = new Double(tks.nextToken()).doubleValue();
					y2 = new Double(tks.nextToken()).doubleValue();
					
					figuras.addElement(new Retangulo(x1, y1, x2, y2));
					break;
				case 'c':
					x1 = new Double(tks.nextToken()).doubleValue();
					y1 = new Double(tks.nextToken()).doubleValue();
					double raio = new Double(tks.nextToken()).doubleValue();
					
					figuras.addElement(new Circulo(x1, y1, raio));
					break;
				case 't':
					x1 = new Double(tks.nextToken()).doubleValue();
					y1 = new Double(tks.nextToken()).doubleValue();
					x2 = new Double(tks.nextToken()).doubleValue();
					y2 = new Double(tks.nextToken()).doubleValue();
					x3 = new Double(tks.nextToken()).doubleValue();
					y3 = new Double(tks.nextToken()).doubleValue();
					
					figuras.addElement(new Triangulo(x1, y1, x2, y2, x3, y3));
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

class Triangulo implements Figura {

	public Ponto p1;
	public Ponto p2;
	public Ponto p3;

	public Triangulo(double x1, double y1, double x2, double y2, double x3, double y3) {
		this(new Ponto(x1, y1), new Ponto(x2, y2), new Ponto(x3, y3));
	}
	
	public Triangulo(Ponto p1, Ponto p2, Ponto p3) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}

	public boolean contains(Ponto p) {
		long area1 = norm(getArea(p, p1, p2), 6);
		long area2 = norm(getArea(p, p2, p3), 6);
		long area3 = norm(getArea(p, p1, p3), 6);
		
		if (area1 == 0 || area2 == 0 || area3 == 0) return false;
		
		return area1 + area2 + area3 == norm(this.getArea(), 6);
	}
	
	private long norm(double valor, int casas) {
		return Math.round(valor * Math.pow(10, casas));
	}
	
	public double getArea() {
		return Math.abs(p1.x * p2.y + p1.y * p3.x + p2.x * p3.y - p3.x * p2.y - p3.y * p1.x - p2.x * p1.y) / 2.0;
	}
	
	public static double getArea(Ponto p1, Ponto p2, Ponto p3) {
		return Math.abs(p1.x * p2.y + p1.y * p3.x + p2.x * p3.y - p3.x * p2.y - p3.y * p1.x - p2.x * p1.y) / 2.0;
	}

}