import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner();
		
		while (!sc.isEOF()) {
			int m = sc.getInt();
			int n = sc.getInt();
			
			Elemento[][] array = new Elemento[m + 2][n];
			
			for (int i = 1; i <= m; i++) {
				for (int j = 0; j < n; j++) {
					int elemento = sc.getInt();
					array[i][j] = new Elemento(elemento);
					array[i][j].linha = i;
				}
			}
			
			array[0] = array[array.length - 2];
			array[array.length - 1] = array[1];
			
			for (int j = n - 2; j >= 0; j--) {
				for (int i = 1; i <= m; i++) {
					Elemento a = array[i - 1][j + 1];
					Elemento b = array[i][j + 1];
					Elemento c = array[i + 1][j + 1];
					
					int valorMinimo = Math.min(Math.min(a.valor, b.valor), c.valor);
					
					if (a.linha > b.linha) {
						Elemento aux = a;
						a = b;
						b = c;
						c = aux;
					} else if (c.linha < b.linha) {
						Elemento aux = c;
						c = b;
						b = a;
						a = aux;
					}
					
					if (c.valor == valorMinimo) array[i][j].pred = c;
					if (b.valor == valorMinimo) array[i][j].pred = b;
					if (a.valor == valorMinimo) array[i][j].pred = a;
					
					array[i][j].valor += valorMinimo;
				}
			}
			
			Elemento minimo = array[1][0];
			
			for (int i = 2; i <= m; i++) {
				if (array[i][0].valor < minimo.valor) {
					minimo = array[i][0];
				}
			}
			
			
			System.out.println(monta(minimo).toString().trim());
			System.out.println(minimo.valor);
		}
	}
	
	static StringBuffer monta(Elemento e) {
		StringBuffer sb = new StringBuffer();
		
		while (e != null) {
			sb.append(e.linha).append(" ");
			e = e.pred;
		}
		
		return sb;
	}

}

class Elemento {
	public int valor;
	public int linha;
	public Elemento pred;
	
	public Elemento(int valor) {
		this.valor = valor;
		this.linha = -1;
	}
	
	public String toString() {
		return "l:"+linha + " v:" + valor;
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