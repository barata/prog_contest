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
		StringTokenizer tks = new StringTokenizer(linha);
		
		int w = Integer.parseInt(tks.nextToken());
		int h = Integer.parseInt(tks.nextToken());
		int n = Integer.parseInt(tks.nextToken());
		
		while (w != 0 || h != 0 || n != 0) {
			
			boolean[][] array = new boolean[h + 1][w + 1];
			
			for (int g = 0; g < n; g++) {
				
				linha = readLn();
				tks = new StringTokenizer(linha);
				
				int x1 = Integer.parseInt(tks.nextToken());
				int y1 = Integer.parseInt(tks.nextToken());
				int x2 = Integer.parseInt(tks.nextToken());
				int y2 = Integer.parseInt(tks.nextToken());
				
				int xIni = Math.min(x1, x2);
				int xFim = Math.max(x1, x2);
				int yIni = Math.min(y1, y2);
				int yFim = Math.max(y1, y2);
				
				for (int i = xIni; i <= xFim; i++) {
					for (int j = yIni; j <= yFim; j++) {
						array[j][i] = true;
					}
				}
			}
			
			int resultado = conta(array);
			
			switch (resultado) {
				case 0:
					System.out.println("There is no empty spots.");
					break;
				case 1:
					System.out.println("There is one empty spot.");
					break;
				default:
					System.out.println("There are " + resultado + " empty spots.");
					break;
			}
			
			readLn();
			
			
			
			linha = readLn();
			tks = new StringTokenizer(linha);
			
			w = Integer.parseInt(tks.nextToken());
			h = Integer.parseInt(tks.nextToken());
			n = Integer.parseInt(tks.nextToken());
		}
	}

	static int conta(boolean[][] array) {
		int cont = 0;
		
		for (int i = 1; i < array.length; i++) {
			for (int j = 1; j <array[i].length; j++) {
				if (!array[i][j]) cont++;
			}
		}
		
		return cont;
	}
}
