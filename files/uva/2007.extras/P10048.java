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
		
		int c = Integer.parseInt(tks.nextToken());
		int s = Integer.parseInt(tks.nextToken());
		int q = Integer.parseInt(tks.nextToken());
		
		int nTest = 0;
		boolean firstCase = true;
		
		while (c != 0 || s != 0 || q != 0) {

			int[][] graph = new int[c + 1][c + 1];
			
			for (int i = 0; i < graph.length; i++) {
				for (int j = 0; j < graph[i].length; j++) {
					graph[i][j] = Integer.MAX_VALUE;
				}
			}

			for (int i = 0; i < s; i++) {
				tks = new StringTokenizer(readLn());

				int c1 = Integer.parseInt(tks.nextToken());
				int c2 = Integer.parseInt(tks.nextToken());
				int d = Integer.parseInt(tks.nextToken());

				graph[c1][c2] = d;
				graph[c2][c1] = d;
			}

			FLOYD_WARSHALL(graph);
			
			if (!firstCase) System.out.println();
			else firstCase = false;
			
			System.out.println("Case #" + (++nTest));

			for (int i = 0; i < q; i++) {
				tks = new StringTokenizer(readLn());

				int c1 = Integer.parseInt(tks.nextToken());
				int c2 = Integer.parseInt(tks.nextToken());

				if (graph[c1][c2] == Integer.MAX_VALUE) {
					System.out.println("no path");
				} else {
					System.out.println(graph[c1][c2]);
				}
			}
			
			
			
			
			
			tks = new StringTokenizer(readLn());
			
			c = Integer.parseInt(tks.nextToken());
			s = Integer.parseInt(tks.nextToken());
			q = Integer.parseInt(tks.nextToken());
		}
	}
	
	static void FLOYD_WARSHALL(int[][] array) {
		for (int k = 1; k < array.length; k++) {
			for (int i = 1; i < array.length; i++) {
				for (int j = 1; j < array.length; j++) {
					array[i][j] = Math.min(array[i][j], Math.max(array[i][k], array[k][j]));
				}
			}
		}
	}

}
