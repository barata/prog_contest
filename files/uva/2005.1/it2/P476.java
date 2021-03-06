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
			
		// le retangulos
		Vector retangulos = new Vector();
		
		String linha = readLn();
		while (!linha.equals("*")) {
			StringTokenizer tks = new StringTokenizer(linha);
			
			tks.nextToken();
			double x1 = new Double(tks.nextToken()).doubleValue();
			double y1 = new Double(tks.nextToken()).doubleValue();
			double x2 = new Double(tks.nextToken()).doubleValue();
			double y2 = new Double(tks.nextToken()).doubleValue();
			
			retangulos.addElement(new Retangulo(x1, y1, x2, y2));
			
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
			
			for (int j = 0; j < retangulos.size(); j++) {
				Retangulo r = (Retangulo) retangulos.elementAt(j);
				
				if (r.contains(p)) {
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

class Ponto {
	public double x;
	public double y;
	
	public Ponto(double x, double y) {
		this.x = x;
		this.y = y;
	}
}

class Retangulo {
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