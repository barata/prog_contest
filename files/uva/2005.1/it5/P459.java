
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
	
	static boolean[][] grafo;
	static boolean[] visitado;
	static int[] tempo;
	static int cont;
	
	public static void main(String[] args) {
		int nTestes = Integer.parseInt(readLn());
		
		readLn();
		
		for (int g = 0; g < nTestes; g++) {
			char limite = readLn().charAt(0);
			
			grafo = new boolean[limite - 'A' + 1][limite - 'A' + 1];
			visitado = new boolean[limite - 'A' + 1];
			tempo = new int[limite - 'A' + 1];
			cont = 1;
			
			String linha = readLn();

			while (linha != null && !linha.equals("")) {
				char ch1 = linha.charAt(0);
				char ch2 = linha.charAt(1);
				grafo[ch1 - 'A'][ch2 - 'A'] = true;
				grafo[ch2 - 'A'][ch1 - 'A'] = true;
				
				linha = readLn();
			}

			DFS();
			
			
			visitado = new boolean[limite - 'A' + 1];
			
			System.out.println(CONTA_COMPONENTES());
			if (g < nTestes - 1) System.out.println();
		}

	}
	
	static int CONTA_COMPONENTES() {
		int total = 0;
		int max = extractMax();
		
		while (max != -1) {
			
			DFS_VISIT(max);
			total++;
			
			
			max = extractMax();
		}
		
		return total;
	}

	static void DFS() {
		for (int i = 0; i < grafo.length; i++) {
			if (!visitado[i]) DFS_VISIT(i);
		}
	}

	static void DFS_VISIT(int indice) {
		visitado[indice] = true;
		
		for (int i = 0; i < grafo.length; i++) {
			if (!visitado[i] && grafo[indice][i]) DFS_VISIT(i);
		}
		
		tempo[indice] = (cont++);
	}
	
	static int extractMax() {
		int max = -1;
		int indice = -1;
		
		for (int i = 0; i < tempo.length; i++) {
			if (!visitado[i] && tempo[i] > max) {
				max = tempo[i];
				indice = i;
			}
		}
		
		return indice;
	}

}
