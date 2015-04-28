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
	
	static long[] termos = new long[50001];
	
	static {
		
		termos[1] = 1;
		
		for (int i = 2; i < termos.length; i++) {
			
			termos[i] = termos[i - 1] + Math.round(Math.pow(i, 3));
			
		}

	}

	public static void main(String[] args) {
		String linha = readLn();
		
		while (linha != null) {
			int x = Integer.parseInt(linha);
			
			System.out.println(termos[x]);
			
			linha = readLn();
		}
	}
}
