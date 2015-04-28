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
		String line = readLn();
		
		while (line != null) {
			int n = Integer.parseInt(line);
			
			double[][][] table = new double[n][n][n + 1];
			int[][][] pred = new int[n][n][n + 1];
			
			// inicializacao
			for (int i = 0; i < n; i++) {
				table[i][i][1] = 1;
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					pred[i][j][1] = i;
				}
			}
			
			// leitura dos dados
			for (int i = 0; i < n; i++) {
				line = readLn();
				StringTokenizer tks = new StringTokenizer(line);
				
				for (int j = 0; j < n; j++) {
					if (i == j) continue;
					
					table[i][j][1] = new Double(tks.nextToken()).doubleValue();
				}
			}
			
			int steps, firstNode = -1;
			boolean achou = false;
			
			for (steps = 2; steps <= n; steps++) {
				for (int k = 0; k < n; k++) {
					for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++) {
							double tmp = table[i][k][steps - 1] * table[k][j][1];
							if (tmp > table[i][j][steps]) {
								table[i][j][steps] = tmp;
								pred[i][j][steps] = k;
							}
						}
					}
				}
			}
			
			for (steps = 2; steps <= n; steps++) {
				for (int i = 0; !achou && i < n; i++) {
					if (table[i][i][steps] > 1.01) {
						firstNode = i;
						achou = true;
					}
				}
				if (achou) break;
			}

			if (firstNode == -1) {
				System.out.println("no arbitrage sequence exists");
			} else {
				System.out.println(printBack(firstNode, firstNode, steps, pred));
			}
			
			
			
			
			line = readLn();
		}
	}
	
	static StringBuffer printBack(int i, int j, int steps, int[][][] pred) {
	   if (steps==0) return new StringBuffer("" + (i + 1));
	   else return printBack(i, pred[i][j][steps], steps-1, pred).append(" ").append(j + 1);
	} 

}
