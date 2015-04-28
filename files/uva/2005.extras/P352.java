import java.util.Vector;

class Main {

	static Vector pixels;

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
		
		int nTeste = 0;
		
		while (linha != null) {
			int size = Integer.parseInt(linha);
			
			Pixel[][] matriz = new Pixel[size + 2][size + 2];
			
			for (int i = 1; i <= size; i++) {
				linha = readLn();
				
				for (int j = 0; j < size; j++) {
					char ch = linha.charAt(j);
					
					if (ch == '1') {
						matriz[i][j + 1] = new Pixel(i, j + 1);
					}
				}
			}
			
			DFS(matriz);

			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz.length; j++) {
					if (matriz[i][j] != null) matriz[i][j].visitado = false;
				}
			}
			
			System.out.println("Image number "+(++nTeste)+" contains "+MST(matriz)+" war eagles.");
			
			
			
			linha = readLn();
		}
	}
	
	static void DFS(Pixel[][] matriz) {
		pixels = new Vector();
		for (int i = 1; i < matriz.length - 1; i++) {
			for (int j = 1; j < matriz.length - 1; j++) {
				DFS(matriz, i, j);
			}
		}
	}

	static void DFS(Pixel[][] matriz, int i, int j) {
		if (matriz[i][j] == null || matriz[i][j].visitado) return;
		
		matriz[i][j].visitado = true;
		
		
		if (matriz[i - 1][j - 1] != null && !matriz[i - 1][j - 1].visitado) DFS(matriz, i - 1, j - 1);
		if (matriz[i - 1][j] != null && !matriz[i - 1][j].visitado) DFS(matriz, i - 1, j);
		if (matriz[i - 1][j + 1] != null && !matriz[i - 1][j + 1].visitado) DFS(matriz, i - 1, j + 1);
		if (matriz[i][j - 1] != null && !matriz[i][j - 1].visitado) DFS(matriz, i, j - 1);
		if (matriz[i][j + 1] != null && !matriz[i][j + 1].visitado) DFS(matriz, i, j + 1);
		if (matriz[i + 1][j - 1] != null && !matriz[i + 1][j - 1].visitado) DFS(matriz, i + 1, j - 1);
		if (matriz[i + 1][j] != null && !matriz[i + 1][j].visitado) DFS(matriz, i + 1, j);
		if (matriz[i + 1][j + 1] != null && !matriz[i + 1][j + 1].visitado) DFS(matriz, i + 1, j + 1);
		
		pixels.addElement(matriz[i][j]);
	}
	
	static int MST(Pixel[][] matriz) {
		int cont = 0;
		
		for (int i = 0; i < pixels.size(); i++) {
			Pixel aux = (Pixel) pixels.elementAt(i);
			
			if (!aux.visitado) {
				cont++;
				DFS(matriz, aux.i, aux.j);
			}
			
		}
		
		return cont;
	}

}

class Pixel {
	public int i, j;
	public boolean visitado = false;
	
	public Pixel(int i, int j) {
		this.i = i;
		this.j = j;
	}
}