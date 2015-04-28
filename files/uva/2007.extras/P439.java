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
	
	static int[][] graph = new int[64][64];
	
	static {
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				graph[i][j] = Integer.MAX_VALUE / 2;
			}
		}
		
		for (int l = 0; l < 8; l++) {
			for (int c = 0; c < 8; c++) {
				int jogadaL = l - 1;
				int jogadaC = c - 2;
				if (jogadaL >= 0 && jogadaL < 8 && jogadaC >= 0 && jogadaC < 8) {
					graph[l * 8 + c][jogadaL * 8 + jogadaC] = 1;
				}
				
				jogadaL = l - 2;
				jogadaC = c - 1;
				if (jogadaL >= 0 && jogadaL < 8 && jogadaC >= 0 && jogadaC < 8) {
					graph[l * 8 + c][jogadaL * 8 + jogadaC] = 1;
				}
				
				jogadaL = l - 2;
				jogadaC = c + 1;
				if (jogadaL >= 0 && jogadaL < 8 && jogadaC >= 0 && jogadaC < 8) {
					graph[l * 8 + c][jogadaL * 8 + jogadaC] = 1;
				}
				
				jogadaL = l - 1;
				jogadaC = c + 2;
				if (jogadaL >= 0 && jogadaL < 8 && jogadaC >= 0 && jogadaC < 8) {
					graph[l * 8 + c][jogadaL * 8 + jogadaC] = 1;
				}
				
				jogadaL = l + 1;
				jogadaC = c + 2;
				if (jogadaL >= 0 && jogadaL < 8 && jogadaC >= 0 && jogadaC < 8) {
					graph[l * 8 + c][jogadaL * 8 + jogadaC] = 1;
				}
				
				jogadaL = l + 2;
				jogadaC = c + 1;
				if (jogadaL >= 0 && jogadaL < 8 && jogadaC >= 0 && jogadaC < 8) {
					graph[l * 8 + c][jogadaL * 8 + jogadaC] = 1;
				}
				
				jogadaL = l + 2;
				jogadaC = c - 1;
				if (jogadaL >= 0 && jogadaL < 8 && jogadaC >= 0 && jogadaC < 8) {
					graph[l * 8 + c][jogadaL * 8 + jogadaC] = 1;
				}
				
				jogadaL = l + 1;
				jogadaC = c - 2;
				if (jogadaL >= 0 && jogadaL < 8 && jogadaC >= 0 && jogadaC < 8) {
					graph[l * 8 + c][jogadaL * 8 + jogadaC] = 1;
				}
			}
		}
		
		FLOYD_WARSHALL(graph);
	}
	
	static void FLOYD_WARSHALL(int[][] array) {
		for (int k = 0; k < array.length; k++) {
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length; j++) {
					if (array[i][k] + array[k][j] < array[i][j]) {
						array[i][j] = array[i][k] + array[k][j];
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		String line = readLn();
		
		while (line != null) {
			StringTokenizer tks = new StringTokenizer(line);
			String pos1 = tks.nextToken();
			String pos2 = tks.nextToken();

			if (pos1.equals(pos2)) {
				System.out.println("To get from "+pos1+" to "+pos2+" takes 0 knight moves.");
			} else {
				int l1 = Character.getNumericValue(pos1.charAt(1)) -1 ;
				int c1 = pos1.charAt(0) - 'a';

				int l2 = Character.getNumericValue(pos2.charAt(1)) - 1;
				int c2 = pos2.charAt(0) - 'a';

				System.out.println("To get from "+pos1+" to "+pos2+" takes "+graph[l1 * 8 + c1][l2 * 8 + c2]+" knight moves.");
			}


			line = readLn();
		}
	}

}
