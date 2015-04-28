
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
	
	static int[] freq, freqPerm;
	static int size;
	
	public static void main(String[] args) {
		int nTestes = Integer.parseInt(readLn());
		
		for (int g = 0; g < nTestes; g++) {
			size = Integer.parseInt(readLn());
			
			freq = new int[256];
			freqPerm = new int[256];
			String linha = readLn();
			
			for (int i = 0; linha.charAt(i) != '#'; i++) {
				freq[linha.charAt(i)]++;
				freqPerm[linha.charAt(i)]++;
			}
			
			int[][] resultado = new int[2][size];
			int fim = size / 2 - 1;

			for (int i = 0; i <= fim; i++) {
				int max1 = getNextFreq();
				int f1 = freq[max1];
				freq[max1] = Integer.MIN_VALUE;
				int max2 = getNextFreq();
				int f2 = freq[max2];
				freq[max2] = Integer.MIN_VALUE;
				
				int indice1 = getMinChar(f1);
				int indice2 = getMaxChar(f2);
				int indice1_aux = getMinChar(f2);
				if (indice1_aux < indice1) {
					indice1 = indice1_aux;
					indice2 = getMaxChar(f1);
					int aux = f1;
					f1 = f2;
					f2 = aux;
				}

				freqPerm[indice1] = Integer.MAX_VALUE;
				resultado[0][i] = f1;
				resultado[1][i] = indice1;
				freqPerm[indice2] = Integer.MAX_VALUE;
				resultado[0][size - i - 1] = f2;
				resultado[1][size - i - 1] = indice2;
			}

			if (size % 2 != 0) {
				int max = getMinChar(freq[getNextFreq()]);
				resultado[0][size / 2] = freqPerm[max];
				resultado[1][size / 2] = max;
			}
			
			for (int i = 0; i < resultado[1].length; i++) {
				System.out.print((char) resultado[1][i]);
				if (i < resultado[1].length - 1) System.out.print(" ");
			}
			System.out.println();
			
			for (int i = 0; i < resultado[0].length; i++) {
				System.out.print(resultado[0][i]);
				if (i < resultado[0].length - 1) System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	static int getMinChar(int f) {
		for (int i = 'A'; i < 'A'+size; i++) {
			if (freqPerm[i] == f) return i;
		}
		return -1;
	}
	
	static int getMaxChar(int f) {
		for (int i = 'A'+size-1; i >= 'A'; i--) {
			if (freqPerm[i] == f) return i;
		}
		return -1;
	}
	
	static int getNextFreq() {
		int indice = 'A';
		
		for (int i = 'B'; i < 'A'+size; i++) {
			if (freq[i] > freq[indice]) indice = i;
		}
		
		return indice;
	}

}