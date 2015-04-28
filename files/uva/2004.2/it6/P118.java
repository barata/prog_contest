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
		try {
		String linha;
		StringTokenizer tks;
		
		linha = readLn();
		tks = new StringTokenizer(linha);
		
		int largura = Integer.parseInt(tks.nextToken());
		int altura = Integer.parseInt(tks.nextToken());
		
		Tabuleiro tab = new Tabuleiro(largura, altura);
		
		linha = readLn();
		
		while (linha != null) {
			tks = new StringTokenizer(linha);
			
			int xIni = Integer.parseInt(tks.nextToken());
			int yIni = Integer.parseInt(tks.nextToken());
			char direcao = tks.nextToken().charAt(0);
			
			boolean lost = false;
			
			tab.configuraRobo(xIni, yIni, direcao);
			
			String comandos = readLn();
			for (int i = 0; !lost && i < comandos.length(); i++) {
				if (! tab.executaComando(comandos.charAt(i)) ) {
					lost = true;
				}
			}
			
			String resultado = tab.x + " " + tab.y + " " + tab.getDirecao();
			if (lost) resultado += " LOST";
			
			System.out.println(resultado);
			
			
			linha = readLn();
		}
		} catch (Exception e) { while(true); }
	}

}
class Tabuleiro {

	private boolean[][] mask;
	
	private int sizeX;
	private int sizeY;
	
	public int x;
	public int y;
	private double angulo;

	public Tabuleiro(int x, int y) {
		this.sizeX = x + 1;
		this.sizeY = y + 1;
		this.mask = new boolean[y + 1][x + 1];
	}
	
	public void configuraRobo(int x, int y, char direcao) {
		this.x = x;
		this.y = y;
		this.angulo = getAngulo(direcao);
	}
	
	public char getDirecao() {
		int ang = (int) Math.round(toDegrees(this.angulo));

		switch (ang) {
			case 0: return 'E';
			case 90: return 'N';
			case 180: return 'W';
			case 270: return 'S';
		}
		return 'N';
	}
	
	private double getAngulo(char direcao) {
		switch (direcao) {
			case 'E': return 0;
			case 'N': return toRadians(90);
			case 'W': return toRadians(180);
			case 'S': return toRadians(270);
		}
		return 0;
	}
	
	public boolean executaComando(char codigo) {
		switch (codigo) {
			case 'L':
				this.angulo = toRadians((toDegrees(this.angulo) + 90) % 360);
				break;
			case 'R':
				this.angulo = toRadians((toDegrees(this.angulo) + 360 - 90) % 360);
				break;
			case 'F':
				int deltaX = (int) Math.cos(this.angulo);
				int deltaY = (int) Math.sin(this.angulo);

				if ( (y + deltaY < 0 || y + deltaY >= this.sizeY) || (x + deltaX < 0 || x + deltaX >= this.sizeX)) {
					if (! this.mask[y][x] ) {
						this.mask[y][x] = true;
						return false;
					}
				} else {
					x += deltaX;
					y += deltaY;
				}
				break;
		}
		return true;
	}
	
	static double toDegrees(double r) {
		return r * 180 / Math.PI;
	}
	
	static double toRadians(double d) {
		return Math.PI * d / 180;
	}
}