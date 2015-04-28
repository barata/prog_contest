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
		
		while (linha != null) {
			StringTokenizer tks = new StringTokenizer(linha);
			
			String palavra1 = tks.nextToken();
			String palavra2 = tks.nextToken();
			
			int i = 0;
			int j = 0;
			
			while (i < palavra1.length() && j < palavra2.length()) {
				
				if (palavra1.charAt(i) == palavra2.charAt(j)) i++;
				j++;
				
			}

			if (i == palavra1.length()) System.out.println("Yes");
			else System.out.println("No");
			
			linha = readLn();
		}

	}

}
