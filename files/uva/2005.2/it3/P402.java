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
		String line;
		int nTest = 0;
		
		line = readLn();
		
		while (line != null) {
			StringTokenizer tks = new StringTokenizer(line);
			
			int n = Integer.parseInt(tks.nextToken());
			int x = Integer.parseInt(tks.nextToken());
			int toDead = n - x;
			
			int[] people = getPeopleArray(n);
			
			while (tks.hasMoreTokens()) {
				int card = Integer.parseInt(tks.nextToken());
				
				toDead -= kill(people, card, toDead);

				if (toDead == 0) break;
			}
			
			System.out.println("Selection #" + (++nTest));
			printResult(people, x);
			System.out.println();
			
			
			line = readLn();
		}
	}
	
	static void printResult(int[] people, int x) {
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < people.length; i++) {
			if (people[i] > 0) {
				sb.append(people[i]);
				x--;
				if (x > 0) sb.append(" ");
			}
		}
		
		System.out.println(sb);
	}

	static int[] getPeopleArray(int n) {
		int[] array = new int[n];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}
		
		return array;
	}

	static int kill(int[] array, int delta, int toDead) {
		if (toDead == 0) return 0;
		
		int count = 0;
		int dead = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] > 0) {
				count++;
				
				if (count % delta == 0) {
					array[i] = 0;
					dead++;
					
					if (dead == toDead) break;
				}
			}
		}
		
		return dead;
	}

}
