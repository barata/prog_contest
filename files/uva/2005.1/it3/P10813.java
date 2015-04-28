import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) {
		int nTestes = Integer.parseInt(Reader.readLn());
		
		int[][] matriz = new int[5][5];
		boolean[][] marks = new boolean[5][5];
		marks[2][2] = true;
		
		Scanner scan = new Scanner();
		
		for (int g = 0; g < nTestes; g++) {
			
			
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (i == 2 && j == 2) continue;
					
					int valor = scan.getInt();
					matriz[i][j] = valor;
					marks[i][j] = false;
				}
			}
			
			int resultado = -1;
			
			for (int i = 1; i <= 75; i++) {
				int valor = scan.getInt();
				
				marcar(matriz, marks, valor);
				
				if (resultado == -1 && ganhou(marks)) resultado = i;
			}
			
			System.out.println("BINGO after " + resultado + " numbers announced");
		}
	}

	static boolean ganhou(boolean[][] marks) {
		if (marks[0][0] && marks[1][1] && marks[3][3] && marks[4][4]) return true;
		if (marks[0][4] && marks[1][3] && marks[3][1] && marks[4][0]) return true;
		
		for (int i = 0; i < 5; i++) {
			boolean ganhou = true;
			for (int j = 0; j < 5; j++) {
				if (marks[i][j] == false) ganhou = false;
			}
			if (ganhou) return true;
		}
		
		for (int j = 0; j < 5; j++) {
			boolean ganhou = true;
			for (int i = 0; i < 5; i++) {
				if (marks[i][j] == false) ganhou = false;
			}
			if (ganhou) return true;
		}
		
		return false;
	}

	static void marcar(int[][] matriz, boolean[][] marks, int valor) {
		int coluna = (valor - 1) / 15;
		
		for (int i = 0; i < 5; i++) {
			if (matriz[i][coluna] == valor) {
				marks[i][coluna] = true;
			}
		}
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