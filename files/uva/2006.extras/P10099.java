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
            if (car == newLine.charAt(0)) System.in.skip(newLine.length() - 1);
        } catch (java.io.IOException e) { return (null); }
        if ((car < 0) && (buffer.length() == 0)) return (null);
        return (buffer.toString()).trim();
    }

	public static void main(String[] args) {
		StringTokenizer tks = new StringTokenizer(readLn());
		
		int count = 0;
		
		int n = Integer.parseInt(tks.nextToken());
		int r = Integer.parseInt(tks.nextToken());
		
		while (n != 0 || r != 0) {
			
			int[][] matriz = new int[n + 1][n + 1];
			
			for (int i = 0; i < r; i++) {
				tks = new StringTokenizer(readLn());
				
				int c1 = Integer.parseInt(tks.nextToken());
				int c2 = Integer.parseInt(tks.nextToken());
				int p = Integer.parseInt(tks.nextToken());
				
				matriz[c1][c2] = p;
				matriz[c2][c1] = p;
			}
			
			FLOYD_WARSHALL(matriz);
			
			
			tks = new StringTokenizer(readLn());
			
			int s = Integer.parseInt(tks.nextToken());
			int d = Integer.parseInt(tks.nextToken());
			int t = Integer.parseInt(tks.nextToken());
			
			int limit = matriz[s][d] - 1; // removing the driver
			int min = t / limit;
			if (t % limit != 0) min++;
			
			System.out.println("Scenario #" + (++count));
			System.out.println("Minimum Number of Trips = " + min);
			System.out.println();
			
			
			tks = new StringTokenizer(readLn());
			
			n = Integer.parseInt(tks.nextToken());
			r = Integer.parseInt(tks.nextToken());
		}
	}

	static void FLOYD_WARSHALL(int[][] array) {
		for (int k = 1; k < array.length; k++) {
			for (int i = 1; i < array.length; i++) {
				for (int j = 1; j < array.length; j++) {
					array[i][j] = Math.max(array[i][j], Math.min(array[i][k], array[k][j]));
				}
			}
		}
	}

}
