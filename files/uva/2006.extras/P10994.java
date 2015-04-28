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

		int p = Integer.parseInt(tks.nextToken());
		int q = Integer.parseInt(tks.nextToken());
		
		while (p >= 0 || q >= 0) {
			
			System.out.println(sum(q) - sum(p - 1));
			
			
			
			
			tks = new StringTokenizer(readLn());
			
			p = Integer.parseInt(tks.nextToken());
			q = Integer.parseInt(tks.nextToken());
		}
	}
	
	static long sum(int n) {
		if (n == 0) return 0;
		
		int newValue = n / 10;
		n %= 10;
		
		long sum = 0;
		
		for (int i = 1; newValue != 0 && i <= 9; i++) {
			sum += i * newValue;
		}
		
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		
		return sum(newValue) + sum;
	}

}
