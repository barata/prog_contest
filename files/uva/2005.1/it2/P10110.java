
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
		long n = Long.parseLong(readLn());
		
		while (n != 0) {
			
			long raiz = Math.round(Math.sqrt(n));
			
			if (raiz * raiz == n) System.out.println("yes");
			else System.out.println("no");
			
			
			
			
			n = Long.parseLong(readLn());
		}

	}
	
}