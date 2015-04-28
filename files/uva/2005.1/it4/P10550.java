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
		StringTokenizer tks = new StringTokenizer(linha);

		int n = Integer.parseInt(tks.nextToken());
		int a = Integer.parseInt(tks.nextToken());
		int b = Integer.parseInt(tks.nextToken());
		int c = Integer.parseInt(tks.nextToken());
		
		while (n != 0 || a != 0 || b != 0 || c != 0) {
			
			double total = 720;
			
			total += toAngulo(calculaDistancia(n, a, true));
			total += 360;
			total += toAngulo(calculaDistancia(a, b, false));
			total += toAngulo(calculaDistancia(b, c, true));
			
			
			System.out.println(Math.round(total));
			
			
			
			linha = readLn();
			tks = new StringTokenizer(linha);
			
			n = Integer.parseInt(tks.nextToken());
			a = Integer.parseInt(tks.nextToken());
			b = Integer.parseInt(tks.nextToken());
			c = Integer.parseInt(tks.nextToken());
		}
	}
	
	static int calculaDistancia(int a, int b, boolean clockwise) {
		if (clockwise) {
			if (a > b) return a - b;
			else if (a < b) return 40 - (b - a);
			else return 0;
		} else {
			if (a > b) return 40 - (a - b);
			else if (a < b) return b - a;
			else return 0;
		}
	}

	static double toAngulo(int valor) {
		return 360.0 / 40 * valor;
	}
}
