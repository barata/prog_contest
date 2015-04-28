
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
		int n = Integer.parseInt(readLn());
		
		while (n != 0) {
			int m = Integer.parseInt(readLn());
			
			char[][] matriz = new char[n][m];
			
			for (int i = 0; i < n; i++) {
				String linha = readLn();
				linha.getChars(0, linha.length(), matriz[i], 0);
			}
			
			int cont = 0;
			
			for (int i1 = 0; i1 < matriz.length; i1++) {
				for (int j1 = 0; j1 < matriz[i1].length; j1++) {
					
					for (int i2 = i1; i2 < matriz.length; i2++) {
						for (int j2 = j1; j2 < matriz[i2].length; j2++) {
							boolean somenteUM = true;
							
							for (int i = i1; somenteUM && i <= i2; i++) {
								for (int j = j1; somenteUM && j <= j2; j++) {
									if (matriz[i][j] != '1') somenteUM = false;
								}
							}
							
							if (somenteUM) cont++;
						}
					}
					
				}
			}
			
			
			
			
			
			System.out.println(cont);
			
			
			
			n = Integer.parseInt(readLn());
		}
	}

}
