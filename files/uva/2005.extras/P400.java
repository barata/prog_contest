
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
        return (buffer.toString()); 
    }
	
	public static void main(String[] args) {
		String linha = readLn();
		
		while (linha != null) {
			int numberOfWords = Integer.parseInt(linha);
			String[] words = new String[numberOfWords];
			int longestLength = 0;

			for (int i = 0; i < numberOfWords; i++) {
				words[i] = readLn();
				longestLength = Math.max(longestLength, words[i].length());
			}
			
			ordena(words);

			int columnLength = Math.min(60, longestLength + 2);
			int numberOfColumns = 62 / columnLength;
			int numberOfLines = numberOfWords / numberOfColumns;
			if (numberOfWords % numberOfColumns != 0) numberOfLines++;

			String[][] table = new String[numberOfLines][numberOfColumns];
			
			for (int k = 0; k < numberOfWords; k++) {
				table[k % numberOfLines][k / numberOfLines] = words[k];
			}

			StringBuffer sb = new StringBuffer();
			
			sb.append(str("-", 60)).append("\n");
			
			for (int i = 0; i < table.length; i++) {
				for (int j = 0; j < table[i].length; j++) {
					if (table[i][j] == null) continue;
					else {
						if (j == table[i].length - 1) sb.append(formata(table[i][j], columnLength - 2));
						else sb.append(formata(table[i][j], columnLength));
					}
				}
				sb.append("\n");
			}
			
			System.out.print(sb);
			
			
			linha = readLn();
		}
	}

	static void ordena(String[] list) {
		for (int i = 1; i < list.length; i++) {
			for (int j = list.length - 1; j >= i; j--) {
				if (list[j - 1].compareTo(list[j]) > 0) {
					String aux = list[j - 1];
					list[j - 1] = list[j];
					list[j] = aux;
				}
			}
		}
	}
	
	static String formata(String text, int size) {
		return text + str(" ", size - text.length());
	}
	
	static String str(String ch, int n) {
		StringBuffer resultado = new StringBuffer();
		for (int i = 0; i < n; i++) {
			resultado.append(ch);
		}
		return resultado.toString();
	}

}
