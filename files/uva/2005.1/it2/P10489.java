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
		
		int nTestes = Integer.parseInt(linha);
		
		for (int g = 0; g < nTestes; g++) {
			linha = readLn();
			StringTokenizer tks = new StringTokenizer(linha);
			
			int n = Integer.parseInt(tks.nextToken());
			int b = Integer.parseInt(tks.nextToken());
			
			int resultado = 0;
			
			for (int i = 0; i < b; i++) {
				linha = readLn();
				tks = new StringTokenizer(linha);

				int k = Integer.parseInt(tks.nextToken());
				int parcial = 1;
				
				for (int j = 0; j < k; j++) {
					int valor = Integer.parseInt(tks.nextToken());
					
					parcial = (parcial * valor) % n;
				}
				
				resultado = (resultado + parcial) % n;
			}
			
			System.out.println(resultado);
		}
	}

}
