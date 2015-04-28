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
		int nTestes = Integer.parseInt(readLn());
		
		for (int g = 0; g < nTestes; g++) {
			StringTokenizer tks = new StringTokenizer(readLn());
			
			int[] objs = new int[tks.countTokens() + 1];
			int sum = 0;
			
			for (int i = 1; i < objs.length; i++) {
				objs[i] = Integer.parseInt(tks.nextToken());
				sum += objs[i];
			}
			
			if (sum % 2 != 0) System.out.println("NO");
			else {
				int media = sum / 2;
				boolean[][] array = new boolean[objs.length][media + 1];
				process(array, objs);
				
				if (array[objs.length - 1][media]) System.out.println("YES");
				else System.out.println("NO");
			}
		}
	}
	
	static void process(boolean[][] array, int[] values) {
		for (int i = 0; i < array.length; i++) {
			array[i][0] = true;
		}
		
		for (int i = 1; i < array.length; i++) {
			for (int j = 1; j < array[0].length; j++) {
				if (array[i - 1][j] || (j - values[i] >= 0 && array[i - 1][j - values[i]])) array[i][j] = true;
			}
		}
		
	}

}
