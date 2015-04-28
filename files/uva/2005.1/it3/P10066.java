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
		StringTokenizer tks = new StringTokenizer(readLn());
		
		int caso = 0;
		
		int i = Integer.parseInt(tks.nextToken());
		int j = Integer.parseInt(tks.nextToken());
		
		while (i != 0 || j != 0) {
			
			int[] array1 = new int[i];
			int[] array2 = new int[j];
			
			tks = new StringTokenizer(readLn());
			
			for (int k = 0; k < array1.length; k++) {
				array1[k] = Integer.parseInt(tks.nextToken());
			}
			
			tks = new StringTokenizer(readLn());
			
			for (int k = 0; k < array2.length; k++) {
				array2[k] = Integer.parseInt(tks.nextToken());
			}
			
			System.out.println("Twin Towers #" + (++caso));
			System.out.println("Number of Tiles : " + LCS_LENGTH(array1, array2));
			System.out.println();
			
			
			tks = new StringTokenizer(readLn());
			
			i = Integer.parseInt(tks.nextToken());
			j = Integer.parseInt(tks.nextToken());
		}
	}
	
	static int LCS_LENGTH(int[] array1, int[] array2) {
		int m = array1.length;
		int n = array2.length;
		
		int[][] c = new int[m + 1][n + 1];
		
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
			
				if (array1[i - 1] == array2[j - 1]) {
					c[i][j] = c[i - 1][j - 1] + 1;
				} else {
					c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
				}
				
			}
		}
		
		return c[m][n];
	}

}
