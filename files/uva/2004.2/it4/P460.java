import java.io.IOException;
import java.util.StringTokenizer;

class Main {

	static String readLn(int maxLg) { // utility function to read from stdin
		byte lin[] = new byte[maxLg];
		int lg = 0, car = -1;
		String line = "";

		try {
			while (lg < maxLg) {
				car = System.in.read();
				if ((car < 0) || (car == '\n'))
					break;
				lin[lg++] += car;
			}
		} catch (IOException e) {
			return (null);
		}

		if ((car < 0) && (lg == 0))
			return (null); // eof
		return (new String(lin, 0, lg)).trim();
	}

	public static void main(String[] args) {

		String linha = readLn(255);
		StringTokenizer tks = new StringTokenizer(linha);
		
		int nTestes = Integer.parseInt(tks.nextToken());
		
		for (int g = 0; g < nTestes; g++) {
			
			readLn(2);
			
			linha = readLn(255);
			tks = new StringTokenizer(linha);
			int x1 = Integer.parseInt(tks.nextToken());
			int y1 = Integer.parseInt(tks.nextToken());
			int x2 = Integer.parseInt(tks.nextToken());
			int y2 = Integer.parseInt(tks.nextToken());
			
			linha = readLn(255);
			tks = new StringTokenizer(linha);
			int x3 = Integer.parseInt(tks.nextToken());
			int y3 = Integer.parseInt(tks.nextToken());
			int x4 = Integer.parseInt(tks.nextToken());
			int y4 = Integer.parseInt(tks.nextToken());
			
			int xMax = Math.max(x1, x3);
			int yMax = Math.max(y1, y3);
			int xMin = Math.min(x2, x4);
			int yMin = Math.min(y2, y4);
			
			if (xMax < xMin && yMax < yMin) {
				System.out.println(xMax + " " + yMax + " " + xMin + " " + yMin);
			} else {
				System.out.println("No Overlap");
			}
			
			if (g < nTestes - 1) System.out.println();
			
		}
		
	}
}
