
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
		String i = Integer.toBinaryString(Integer.parseInt(readLn()));
		
		while (! "0".equals(i) ) {
			System.out.println("The parity of "+i+" is "+countOnes(i)+" (mod 2).");
		
			i = Integer.toBinaryString(Integer.parseInt(readLn()));
		}
	}
	
	static int countOnes(String s) {
		int total = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') total++;
		}
		
		return total;
	}

}
