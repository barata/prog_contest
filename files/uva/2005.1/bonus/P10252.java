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
		String a = readLn();
		
		while (a != null) {
			String b = readLn();
			
			System.out.println(inter(mark(a), mark(b)));
			
			
			a = readLn();
		}
	}
	
	static int[] mark(String str) {
		int[] result = new int[256];
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			result[ch]++;
		}
		
		return result;
	}
	
	static String inter(int[] a, int[] b) {
		String result = "";
		
		for (int i = 0; i < 256; i++) {
			if (a[i] > 0 && b[i] > 0) {
				result += str((char) i, Math.min(a[i], b[i]));
			}
		}
		
		return result;
	}
	
	static String str(char ch, int n) {
		String result = "";
		
		for (int i = 0; i < n; i++) {
			result += ch;
		}
		
		return result;
	}

}
