import java.util.Vector;

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
		int nTestes = Integer.parseInt(readLn());
		
		readLn();
		
		for (int g = 0; g < nTestes; g++) {
			
			String linha = readLn();
			
			Vector numeros = new Vector();
			
			while (linha != null && !linha.equals("")) {
				
				numeros.addElement(new Integer(linha));
				
				linha = readLn();
			}
			
			int[] length = new int[numeros.size()];
			int[] predecessor = new int[numeros.size()];
			
			int maxIndice = LIS(numeros, length, predecessor);
			
			System.out.println("Max hits: " + length[maxIndice]);
			PRINT_LIS(numeros, predecessor, maxIndice);
			
			if (g < nTestes - 1) System.out.println();
		}
	}

	static void PRINT_LIS(Vector numeros, int[] predecessor, int indice) {
		if (indice >= 0) {
			PRINT_LIS(numeros, predecessor, predecessor[indice]);
			System.out.println(numeros.elementAt(indice));
		}
	}

	static int LIS(Vector numeros, int[] length, int[] predecessor) {
		for (int i = 0; i < length.length; i++) {
			length[i] = 1;
			predecessor[i] = -1;
		}
		
		int max = 0;
		int maxIndice = 0;
		
		for (int i = 0; i < numeros.size() - 1; i++) {
			int a = ((Integer) numeros.elementAt(i)).intValue();
			for (int j = i + 1; j < numeros.size(); j++) {
				int b = ((Integer) numeros.elementAt(j)).intValue();

				if (b > a && length[i] + 1 > length[j]) {
					length[j] = length[i] + 1;
					predecessor[j] = i;
					
					if (length[j] > max) {
						max = length[j];
						maxIndice = j;
					}
				}
			}
		}
		
		return maxIndice;
	}

}
