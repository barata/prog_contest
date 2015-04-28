
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
        return (buffer.toString()); 
    }
	
	public static void main(String[] args) {
		String palavra1 = readLn();
		
		int nTestes = 0;
		
		while (!palavra1.startsWith("#")) {
			String palavra2 = readLn();
			
			int[][] lcs = LCS_LENGTH(palavra1, palavra2);
			
			System.out.println("Case #" + (++nTestes) + ": you can visit at most " + lcs[palavra1.length()][palavra2.length()] + " cities.");
			
			
			
			palavra1 = readLn();
		}
	}
	
	static int[][] LCS_LENGTH(String palavra1, String palavra2) {
		int m = palavra1.length();
		int n = palavra2.length();
		
		int[][] c = new int[m + 1][n + 1];
		
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
			
				if (palavra1.charAt(i - 1) == palavra2.charAt(j - 1)) {
					c[i][j] = c[i - 1][j - 1] + 1;
				} else if (c[i - 1][j] >= c[i][j - 1]) {
					c[i][j] = c[i - 1][j];
				} else {
					c[i][j] = c[i][j - 1];
				}
				
			}
		}
		
		return c;
	}

}
