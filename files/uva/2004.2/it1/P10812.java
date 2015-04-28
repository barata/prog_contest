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
		StringTokenizer tks;
		int nTestes = Integer.parseInt(linha);
		
		for (int c = 0; c < nTestes; c++) {
			linha = readLn(255);
			tks = new StringTokenizer(linha);
			
			int s = Integer.parseInt(tks.nextToken());
			int d = Integer.parseInt(tks.nextToken());
			
			if (s < d || ((s + d) & 1) == 1) {
				System.out.println("impossible");
			} else {
				int t1 = (s + d) / 2;
				System.out.println(t1 + " " + (s - t1));
			}
		}
	}
}
