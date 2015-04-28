
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
		String linha = readLn();
		
		while (linha != null) {
			Dado dado1 = new Dado(linha.substring(0, 6));
			Dado dado2 = new Dado(linha.substring(6));
			
			boolean achou = false;
			
			for (int i = 0; !achou && i < 4; i++) {
				dado2.rotacionaX();
				
				for (int j = 0; !achou && j < 4; j++) {
					dado2.rotacionaY();
					
					for (int k = 0; !achou && k < 4; k++) {
						dado2.rotacionaZ();
						
						if (dado1.equals(dado2)) {
							achou = true;
						}
					}
				}
			}
			
			System.out.println(achou ? "TRUE" : "FALSE");
			
			
			
			linha = readLn();
		}
	}

}
class Dado {
	public char frente;
	public char tras;
	public char esq;
	public char dir;
	public char cima;
	public char baixo;

	public Dado(String string) {
		this.cima = string.charAt(0);
		this.frente = string.charAt(1);
		this.esq = string.charAt(2);
		this.dir = string.charAt(3);
		this.tras = string.charAt(4);
		this.baixo = string.charAt(5);
	}
	
	public void rotacionaX() {
		char aux = this.cima;
		this.cima = this.esq;
		this.esq = this.baixo;
		this.baixo = this.dir;
		this.dir = aux;
	}
	
	public void rotacionaY() {
		char aux = this.cima;
		this.cima = this.frente;
		this.frente = this.baixo;
		this.baixo = this.tras;
		this.tras = aux;
	}
	
	public void rotacionaZ() {
		char aux = this.frente;
		this.frente = this.esq;
		this.esq = this.tras;
		this.tras = this.dir;
		this.dir = aux;
	}
	
	public boolean equals(Object o) {
		Dado d = (Dado) o;
		
		return this.toString().equals(d.toString());
	}
	
	public String toString() {
		return new StringBuffer().append(this.cima).append(this.frente).append(this.esq).
			append(this.dir).append(this.tras).append(this.baixo).toString();
	}
	
}