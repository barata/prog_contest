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
		int nTests = Integer.parseInt(readLn());
		
		for (int g = 1; g <= nTests; g++) {
			int[] costs = new int[256];
			
			// first line
			StringTokenizer tks = new StringTokenizer(readLn());
			for (char c = '0'; c <= '8'; c++) {
				costs[c] = Integer.parseInt(tks.nextToken());
			}
			
			// second line
			tks = new StringTokenizer(readLn());
			costs['9'] = Integer.parseInt(tks.nextToken());
			for (char c = 'a'; c <= 'h'; c++) {
				costs[c] = Integer.parseInt(tks.nextToken());
			}
			
			// third line
			tks = new StringTokenizer(readLn());
			for (char c = 'i'; c <= 'q'; c++) {
				costs[c] = Integer.parseInt(tks.nextToken());
			}
			
			// forth line
			tks = new StringTokenizer(readLn());
			for (char c = 'r'; c <= 'z'; c++) {
				costs[c] = Integer.parseInt(tks.nextToken());
			}
			
			System.out.println("Case " + g + ":");
			
			int nQueries = Integer.parseInt(readLn());
			
			for (int i = 0; i < nQueries; i++) {
				StringBuffer sb = null;
				int cheapest = Integer.MAX_VALUE;
				
				int n = Integer.parseInt(readLn());
				
				for (int base = 2; base <= 36; base++) {
					String conv = Integer.toString(n, base);
					int cost = calculateCost(costs, conv);
					if (cost < cheapest) {
						cheapest = cost;
						sb = new StringBuffer();
						sb.append(" ").append(base);
					} else if (cost == cheapest) {
						sb.append(" ").append(base);
					}
				}
				
				System.out.println("Cheapest base(s) for number " + n + ":" + sb);
			}
			
			if (g < nTests) System.out.println();
		}
	}
	
	static int calculateCost(int[] costs, String number) {
		int cost = 0;
		
		for (int i = 0; i < number.length(); i++) {
			cost += costs[number.charAt(i)];
		}
		
		return cost;
	}

}
