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
            if (car == newLine.charAt(0)) System.in.skip(newLine.length() - 1);
        } catch (java.io.IOException e) { return (null); }
        if ((car < 0) && (buffer.length() == 0)) return (null);
        return (buffer.toString()).trim();
    }

	public static void main(String[] args) {
		String line = readLn();
		
		while (line != null) {
			StringTokenizer tks = new StringTokenizer(line);
			
			int n = Integer.parseInt(tks.nextToken());
			int t = Integer.parseInt(tks.nextToken());
			
			Planet[] planets = new Planet[n];
			double[] angles = new double[n];
			
			for (int i = 0; i < n; i++) {
				tks = new StringTokenizer(readLn());
				
				double r = Integer.parseInt(tks.nextToken());
				double t2 = Integer.parseInt(tks.nextToken());
				
				if (i == 0) planets[i] = new Planet(0, 0, r, 0);
				else planets[i] = new Planet(planets[i - 1].x, planets[i - 1].y, planets[i - 1].x + r, 0);
				
				angles[i] = 2 * Math.PI * (t % t2) / t2;
			}
			
			for (int i = 0; i < angles.length; i++) {
				double dX = planets[i].x;
				double dY = planets[i].y;
				planets[i].rotate(angles[i]);
				dX = planets[i].x - dX;
				dY = planets[i].y - dY;
				
				for (int j = i + 1; j < planets.length; j++) {
					planets[j].cX = planets[j - 1].x;
					planets[j].cY = planets[j - 1].y;
					planets[j].x += dX;
					planets[j].y += dY;
				}
			}
			
			for (int i = 0; i < planets.length; i++) {
				System.out.print(round(planets[i].distancia(), 4));
				if (i < planets.length - 1) System.out.print(" ");
			}
			System.out.println();
			
			
			
			
			line = readLn();
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

class Planet {
	
	public double x, y;
	public double cX, cY;
	
	public Planet(double cX, double cY, double x, double y) {
		this.cX = cX;
		this.cY = cY;
		this.x = x;
		this.y = y;
	}

	public double distancia() {
		return Math.sqrt(this.x * this.x + this.y * this.y);
	}

	public void rotate(double rad) {
		double raio = this.getRaio();
		this.x = this.cX + raio * Math.cos(rad);
		this.y = this.cY + raio * Math.sin(rad);
	}
	
	private double getRaio() {
		double dX = this.cX - this.x;
		double dY = this.cY - this.y;
		return Math.sqrt(dX * dX + dY * dY);
	}
	
}