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
		
		boolean deveImprimir = false;
		
		int qnt = Integer.parseInt(tks.nextToken());
		
		while (qnt != 0) {
			
			int[] array = new int[qnt];
			
			for (int i = 0; i < qnt; i++) {
				array[i] = Integer.parseInt(tks.nextToken());
			}
			
			if (deveImprimir) System.out.println();
			
			for (int a = 0; a <= qnt - 6; a++) {
				for (int b = a + 1; b <= qnt - 5; b++) {
					for (int c = b + 1; c <= qnt - 4; c++) {
						for (int d = c + 1; d <= qnt - 3; d++) {
							for (int e = d + 1; e <= qnt - 2; e++) {
								for (int f = e + 1; f <= qnt - 1; f++) {
									System.out.println(array[a] + " " + array[b] + " " + array[c] + " " + array[d] + " " + array[e] + " " + array[f]);
								}
							}
						}
					}
				}
			}
			
			deveImprimir = true;
			
			linha = readLn();
			tks = new StringTokenizer(linha);
			
			qnt = Integer.parseInt(tks.nextToken());
		}
		
	}
}
