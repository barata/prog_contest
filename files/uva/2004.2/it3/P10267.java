import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

class Main {

	static String readLn(int maxLg) { // utility function to read from stdin
		byte lin[] = new byte[maxLg];
		int lg = 0, car = -1;
		String line = "";

		try {
			while (lg < maxLg) {
				car = System.in.read();
				if ((car < 0) || (car == '\n'))
					break;
				lin[lg++] += car;
			}
		} catch (IOException e) {
			return (null);
		}

		if ((car < 0) && (lg == 0))
			return (null); // eof
		return (new String(lin, 0, lg)).trim();
	}

	void limpaPainel() {
		preenchePainel(1, 1, m, n, 'O');
	}

	void preenchePainel(int x1, int y1, int x2, int y2, char valor) {
		int _x1 = Math.min(x1, x2);
		int _x2 = Math.max(x1, x2);
		int _y1 = Math.min(y1, y2);
		int _y2 = Math.max(y1, y2);
		for (int i = _x1; i <= _x2; i++){
			for (int j = _y1; j <= _y2; j++) {
				preenchePixel(i, j, valor);
			}
		}

	}

	void preenchePixel(int x, int y, char valor) {
		painel[y - 1][x - 1] = valor;
	}
	
	char getPixel(int x, int y) {
		return painel[y - 1][x - 1];
	}

	void preencheColuna(int coluna, int y1, int y2, char valor) {
		int _y1 = Math.min(y1, y2);
		int _y2 = Math.max(y1, y2);
		for (int i = _y1; i <= _y2; i++) {
			preenchePixel(coluna, i, valor);
		}
	}

	void preencheLinha(int x1, int x2, int linha, char valor) {
		int _x1 = Math.min(x1, x2);
		int _x2 = Math.max(x1, x2);
		for (int i = _x1; i <= _x2; i++) {
			preenchePixel(i, linha, valor);
		}
	}

	void balde(int x, int y, char valor, char alvo) {
		boolean mask[][] = new boolean[250][250];

		Vector list = new Vector();
		list.addElement(new Pixel(x, y));
		mask[y - 1][x - 1] = true;
		
		while (! list.isEmpty() ) {
			Pixel aux = (Pixel) list.elementAt(0);
			list.removeElement(aux);
			
			preenchePixel(aux.x, aux.y, valor);
			
			if (aux.y > 1 && !mask[aux.y - 2][aux.x - 1] && getPixel(aux.x, aux.y - 1) == alvo) {
				list.addElement(new Pixel(aux.x, aux.y - 1));
				mask[aux.y - 2][aux.x - 1] = true;
			}
			if (aux.x < m && !mask[aux.y - 1][aux.x] && getPixel(aux.x + 1, aux.y) == alvo) {
				list.addElement(new Pixel(aux.x + 1, aux.y));
				mask[aux.y - 1][aux.x] = true;
			}
			if (aux.y < n && !mask[aux.y][aux.x - 1] && getPixel(aux.x, aux.y + 1) == alvo) {
				list.addElement(new Pixel(aux.x, aux.y + 1));
				mask[aux.y][aux.x - 1] = true;
			}
			if (aux.x > 1 && !mask[aux.y - 1][aux.x - 2] && getPixel(aux.x - 1, aux.y) == alvo) {
				list.addElement(new Pixel(aux.x - 1, aux.y));
				mask[aux.y - 1][aux.x - 2] = true;
			}
		}

	}
	
	void balde(int x, int y, char valor) {
		char alvo = getPixel(x, y);
		
		if (valor != alvo)
			balde(x, y, valor, alvo);
	}

	void imprime() {

		for (int j = 0; j < n; j++){
			for (int i = 0; i < m; i++) {
				System.out.print(painel[j][i]);
			}
			System.out.println("");
		}

	}

	int m = 0;
	int n = 0;
	char[][] painel = new char[250][250];

	void solucao() {

		String linha;
		StringTokenizer tokens;
		
		linha = readLn(255);

		while (linha != null && !linha.equals("X")) {
			int x1, x2, y1, y2;
			char c;

			tokens = new StringTokenizer(linha);
			// processa
			char comando = tokens.nextToken().charAt(0);
			switch (comando) {
				case 'I':
					m = Integer.parseInt(tokens.nextToken());
					n = Integer.parseInt(tokens.nextToken());
					limpaPainel();
					break;
				case 'C':
					limpaPainel();
					break;
				case 'L':
					x1 = Integer.parseInt(tokens.nextToken());
					y1 = Integer.parseInt(tokens.nextToken());
					c = tokens.nextToken().charAt(0);
					preenchePixel(x1, y1, c);
					break;
				case 'V':
					x1 = Integer.parseInt(tokens.nextToken());
					y1 = Integer.parseInt(tokens.nextToken());
					y2 = Integer.parseInt(tokens.nextToken());
					c = tokens.nextToken().charAt(0);
					preencheColuna(x1, y1, y2, c);
					break;
				case 'H':
					x1 = Integer.parseInt(tokens.nextToken());
					x2 = Integer.parseInt(tokens.nextToken());
					y1 = Integer.parseInt(tokens.nextToken());
					c = tokens.nextToken().charAt(0);
					preencheLinha(x1, x2, y1, c);
					break;
				case 'K':
					x1 = Integer.parseInt(tokens.nextToken());
					y1 = Integer.parseInt(tokens.nextToken());
					x2 = Integer.parseInt(tokens.nextToken());
					y2 = Integer.parseInt(tokens.nextToken());
					c = tokens.nextToken().charAt(0);
					preenchePainel(x1, y1, x2, y2, c);
					break;
				case 'F':
					x1 = Integer.parseInt(tokens.nextToken());
					y1 = Integer.parseInt(tokens.nextToken());
					c = tokens.nextToken().charAt(0);
					balde(x1, y1, c);
					break;
				case 'S':
					String nome = tokens.nextToken();
					System.out.println(nome);
					imprime();
			}
			
			linha = readLn(255);
		}

	}

	public static void main(String args[]) {

		Main app = new Main();
		app.solucao();

	}

}
class Pixel {
	public int x;
	public int y;
	
	public Pixel(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}