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
		int nTestes = Integer.parseInt(readLn());
		
		for (int i = 0; i < nTestes; i++) {
			
			int nFarms = Integer.parseInt(readLn());
			int soma = 0;
			
			for (int j = 0; j < nFarms; j++) {
				StringTokenizer tks = new StringTokenizer(readLn());
				
				int terreno = Integer.parseInt(tks.nextToken());
				tks.nextToken();
				int valor = Integer.parseInt(tks.nextToken());
				
				soma += terreno * valor;
				
			}
			
			System.out.println(soma);
			
		}
	}
}
