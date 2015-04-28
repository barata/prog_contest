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
		
		int h = Integer.parseInt(tks.nextToken());
		double u = Integer.parseInt(tks.nextToken());
		int d = Integer.parseInt(tks.nextToken());
		int f = Integer.parseInt(tks.nextToken());
		
		while (h != 0) {
			
			int dia = 0;
			
			double posicao = 0;
			double fatorDeslize = u * f / 100.0;
			
			while (posicao >= 0) {
				dia++;
				
				posicao += u;
				if (posicao > h) break;
				posicao -= d;
				
				u -= fatorDeslize;
				if (u < 0) u = 0;
			}
			
			if (posicao < 0) System.out.println("failure on day " + dia);
			else System.out.println("success on day " + dia);
			
			
			
			linha = readLn();
			tks = new StringTokenizer(linha);
			
			h = Integer.parseInt(tks.nextToken());
			u = Integer.parseInt(tks.nextToken());
			d = Integer.parseInt(tks.nextToken());
			f = Integer.parseInt(tks.nextToken());
		}
	}

}
