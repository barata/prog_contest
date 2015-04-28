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
		
		int[] terms = new int[5];
		
		terms[0] = Integer.parseInt(tks.nextToken());
		terms[1] = Integer.parseInt(tks.nextToken());
		terms[2] = Integer.parseInt(tks.nextToken());
		terms[3] = Integer.parseInt(tks.nextToken());
		terms[4] = Integer.parseInt(tks.nextToken());
		
		while (terms[0] != 0 || terms[1] != 0 || terms[2] != 0 || terms[3] != 0 || terms[4] != 0) {
			
			try {
				perm(terms, terms.length, 0);
				System.out.println("Impossible");
			} catch (Exception e) {
				System.out.println("Possible");
			}
			
			
			
			
			
			
			tks = new StringTokenizer(readLn());
			
			terms[0] = Integer.parseInt(tks.nextToken());
			terms[1] = Integer.parseInt(tks.nextToken());
			terms[2] = Integer.parseInt(tks.nextToken());
			terms[3] = Integer.parseInt(tks.nextToken());
			terms[4] = Integer.parseInt(tks.nextToken());
		}
	}
	
	static void perm(int[] v, int n, int i) throws Exception {
		if (i == n) {
			if (backtracking(v, 0, v[0])) throw new Exception();
		} else {
			for (int j = i; j < n; j++) {
				int aux = v[i];
				v[i] = v[j];
				v[j] = aux;
				perm(v, n, i + 1);
				v[j] = v[i];
				v[i] = aux;
			}
		}
	}
	
	static boolean backtracking(int[] terms, int index, int result) {
		if (index == terms.length - 1) return result == 23;

		return backtracking(terms, index + 1, result + terms[index + 1]) ||
			backtracking(terms, index + 1, result - terms[index + 1]) ||
			backtracking(terms, index + 1, result * terms[index + 1]);
	}

}
