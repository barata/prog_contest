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
		String linha = readLn();
		
		while (linha != null) {
			StringTokenizer tks = new StringTokenizer(linha);
			
			int nPalavras = Integer.parseInt(tks.nextToken());
			int nLetras = Integer.parseInt(tks.nextToken());
			
			char[][] array = new char[nPalavras][nLetras];
			
			for (int i = 0; i < nPalavras; i++) {
				linha = readLn();
				
				for (int j = 0; j < nLetras; j++) {
					array[i][j] = linha.charAt(j);
				}
			}
			
			ordena(array);
			
			for (int i = 0; i < array.length; i++) {
				System.out.println(new String(array[i]));
			}
			
			
			
			linha = readLn();
		}
	}
	
	static void ordena(char[][] array) {
		for (int i = 0; i < array.length - 1; i++) {
			
			for (int j = i + 1; j < array.length; j++) {
				
				if (contaDiferencas(array[i], array[j]) == 1) {
					
					while (j > i + 1) {
						char[] aux = array[j];
						array[j] = array[j - 1];
						array[j - 1] = aux;
						j--;
					}
					
					break;
					
				}
				
			}
			
		}
	}
	
	static int contaDiferencas(char[] array1, char[] array2) {
		int cont = 0;
		for (int i = 0; i < array1.length; i++) {
			if (array1[i] != array2[i]) cont++;
		}
		return cont;
	}

}
