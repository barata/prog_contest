
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
	
	static long[] fibo = new long[51];
	
	static {
		fibo(50);
	}

	public static void main(String[] args) {
		String linha = readLn();
		
		int nTestes = Integer.parseInt(linha);
		
		for (int g = 1; g <= nTestes; g++) {
			linha = readLn();
			
			System.out.println("Scenario #" + g + ":");
			System.out.println(fibo[Integer.parseInt(linha)]);
			System.out.println();
		}
	}
	
	static void fibo(int n) {
		long a = 2;
		long b = 3;
		
		fibo[1] = a;
		
		for (int i = 1; i < n; i++) {
			long c = a  + b;
			a = b;
			b = c;
			
			fibo[i + 1] = a;
		}
	}

}
