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
		int nCases = Integer.parseInt(readLn());
		
		for (int g = 0; g < nCases; g++) {
			readLn();
			
			int nTests = Integer.parseInt(readLn());
			int size = Integer.parseInt(readLn());
			
			for (int i = 0; i < nTests; i++) {
				StringTokenizer tks = new StringTokenizer(readLn());
				
				int x1 = Integer.parseInt(tks.nextToken());
				int y1 = Integer.parseInt(tks.nextToken());
				int x2 = Integer.parseInt(tks.nextToken());
				int y2 = Integer.parseInt(tks.nextToken());
				
				float x = (y2 + x2 + x1 - y1) / 2f;
				float y = x - x1 + y1;
				
				int xRound = Math.round(x);
				int yRound = Math.round(y);
				
				if (Math.abs(x - xRound) > 0.0000001 || Math.abs(y - yRound) > 0.0000001) {
					System.out.println("no move");
				} else {
					if (x1 == x2 && y1 == y2) {
						System.out.println("0");
					} else {
						if ((xRound == x1 && yRound == y1) || (xRound == x2 && yRound == y2)) {
							System.out.println("1");
						} else {
							System.out.println("2");
						}
					}
				}
			}
		}

	}

}
