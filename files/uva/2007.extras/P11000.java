
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
	
	static long[] fib = new long[1000000];
	
	static {
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i < fib.length; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		
		for (int i = 2; i < fib.length; i++) {
			fib[i] += fib[i - 1];
		}
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(readLn());
		
		while (n >= 0) {
			
			System.out.println(fib[n] + " " + fib[n + 1]);
			
			
			n = Integer.parseInt(readLn());
		}
	}

}
