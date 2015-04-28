import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner();
		
		int N = sc.getInt();
		
		for (int g = 0; g < N; g++) {
			int n = sc.getInt();
			
			Ponto[] pontos = new Ponto[n];

			for (int i = 0; i < n; i++) {
				double x = sc.getDouble();
				double y = sc.getDouble();
				
				pontos[i] = new Ponto(x, y);
			}

			double[][] grafo = new double[n][n];

			for (int i = 0; i < grafo.length; i++) {
				for (int j = 0; j < grafo.length; j++) {
					double dist = pontos[i].distancia(pontos[j]);
					if (Math.round(dist * 10000) <= 100000) {
						grafo[i][j] = dist;
					} else {
						grafo[i][j] = Double.MAX_VALUE;
					}
				}
			}
			
			FLOYD_WARSHALL(grafo);

			double max = -1;
			boolean ok = true;
			
			for (int i = 0; ok && i < grafo.length; i++) {
				for (int j = 0; ok && j < grafo.length; j++) {
					if (grafo[i][j] == Double.MAX_VALUE) {
						ok = false;
					} else {
						max = Math.max(max, grafo[i][j]);
					}
				}
			}
			
			System.out.println("Case #" + (g+1) + ":");
			if (ok) System.out.println(round(max, 4));
			else System.out.println("Send Kurdy");
			System.out.println();
		}

	}
	
	static void FLOYD_WARSHALL(double[][] array) {
		for (int k = 0; k < array.length; k++) {
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length; j++) {
					if (array[i][k] + array[k][j] < array[i][j]) {
						array[i][j] = array[i][k] + array[k][j];
					}
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

class Ponto {
	public double x;
	public double y;
	
	public Ponto(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double distancia(Ponto p) {
		double dX = this.x - p.x;
		double dY = this.y - p.y;
		
		return Math.sqrt(dX * dX + dY * dY);
	}
}

class Scanner {

    StringTokenizer st = null;
    String next = null;

    Scanner() {
        next = Reader.readLn();
    }

    int getInt() {
        read();
        return Integer.parseInt(st.nextToken());
    }

    double getDouble() {
        read();
        return new Double(st.nextToken()).doubleValue();
    }

    String getString() {
        read();
        return st.nextToken();
    }

    boolean isEOF() {
        return (st == null && next == null) || (st != null && !st.hasMoreTokens() && next == null);
    }

    private void read() {
        if(st == null) {
                st = new StringTokenizer(next);
                next = Reader.readLn();
        }

        while(! st.hasMoreTokens()) {
                st = new StringTokenizer(next);
                next = Reader.readLn();
        }
    }

}

class Reader {
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
}