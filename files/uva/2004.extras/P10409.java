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

		int n = Integer.parseInt(readLn());
		
		String linha;
		
		while (n != 0) {
			
			Dado dado = new Dado();
			
			for (int i = 0; i < n; i++) {
				linha = readLn();
				
				if (linha.equals("north")) dado.north();
				else if (linha.equals("south")) dado.south();
				else if (linha.equals("east")) dado.east();
				else if (linha.equals("west")) dado.west();
			}
			
			System.out.println(dado.getTop());
			
			
			n = Integer.parseInt(readLn());
		}
	}

}
class Dado {
	
	private int cima;
	private int baixo;
	private int frente;
	private int tras;
	private int esquerda;
	private int direita;
	
	public Dado() {
		this.cima = 1;
		this.frente = 2;
		this.esquerda = 3;
		
		this.baixo = 7 - this.cima;
		this.tras = 7 - this.frente;
		this.direita = 7 - this.esquerda;
	}
	
	public int getTop() {
		return this.cima;
	}
	
	public void north() {
		int aux = this.cima;
		this.cima = this.tras;
		this.tras = this.baixo;
		this.baixo = this.frente;
		this.frente = aux;
	}
	
	public void south() {
		int aux = this.cima;
		this.cima = this.frente;
		this.frente = this.baixo;
		this.baixo = this.tras;
		this.tras = aux;
	}
	
	public void east() {
		int aux = this.cima;
		this.cima = this.esquerda;
		this.esquerda = this.baixo;
		this.baixo = this.direita;
		this.direita = aux;
	}
	
	public void west() {
		int aux = this.cima;
		this.cima = this.direita;
		this.direita = this.baixo;
		this.baixo = this.esquerda;
		this.esquerda = aux;
	}
	
}