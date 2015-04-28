
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
			int m = Integer.parseInt(linha);
			
			int[][] matriz = new int[m][m];
			
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < m; i++) {
				sb.append(readLn());
			}
			
			StringBuffer sbFinal = new StringBuffer();
			for (int i = 0; i < sb.length(); i++) {
				char ch = sb.charAt(i);
				if (ch == '1' || ch == '2' || ch == '3') {
					sbFinal.append(ch);
				}
			}
			
			for (int i = 0; i < m * m; i++) {
				int l = i / m;
				int c = i % m;
				
				matriz[l][c] = Character.getNumericValue(sbFinal.charAt(i));
			}
			
			int max = 0;
			
			for (int i1 = 0; i1 < matriz.length; i1++) {
				for (int j1 = 0; j1 < matriz[i1].length; j1++) {
					
					if (matriz[i1][j1] == 1) {
						int min = Integer.MAX_VALUE;
						
						for (int i2 = 0; i2 < matriz.length; i2++) {
							for (int j2 = 0; j2 < matriz[i2].length; j2++) {
								
								if (matriz[i2][j2] == 3) {
									min = Math.min(min, Math.abs(i1 - i2) + Math.abs(j1 - j2));
								}
								
							}
						}
					
						max = Math.max(max, min);
					}
					
				}
			}
			
			System.out.println(max);
			
			
			
			
			linha = readLn();
		}
	}

}
