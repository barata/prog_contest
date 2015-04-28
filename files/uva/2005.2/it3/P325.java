
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
		
		while (!"*".equals(linha)) {
			
			Automato auto = new Automato(0);
			boolean achouEstadoMorto = false;
			
			for (int i = 0; i < linha.length(); i++) {
				if (! auto.andar(linha.charAt(i)) ) {
					achouEstadoMorto = true;
					break;
				}
			}
			
			
			if (achouEstadoMorto) {
				System.out.println(linha + " is illegal.");
			} else {
				if (auto.estado == 3 || auto.estado == 7) {
					System.out.println(linha + " is legal.");
				} else {
					System.out.println(linha + " is illegal.");
				}
			}
			
			
			
			
			linha = readLn();
		}
	}

}
class Automato {
	
	public static String[][] grafo = new String[8][8];
	
	static {
		grafo[0][4] = "+-";
		grafo[4][1] = "0123456789";
		grafo[0][1] = "0123456789";
		grafo[1][1] = "0123456789";
		grafo[1][2] = ".";
		grafo[2][3] = "0123456789";
		grafo[3][3] = "0123456789";
		grafo[1][5] = "Ee";
		grafo[3][5] = "Ee";
		grafo[5][6] = "+-";
		grafo[5][7] = "0123456789";
		grafo[6][7] = "0123456789";
		grafo[7][7] = "0123456789";
	}
	
	public int estado;
	
	public Automato(int estadoInicial) {
		this.estado = estadoInicial;
	}
	
	public boolean andar(char ch) {
		for (int i = 0; i < grafo[this.estado].length; i++) {
			if (grafo[this.estado][i] != null && grafo[this.estado][i].indexOf(ch) >= 0) {
				this.estado = i;
				return true;
			}
		}
		return false;
	}
	
}