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
	
	static long[] resp = new long[500001];
	
	static {
		resp[1] = 1;
		long cont  = 2;
		
		for (int i = 2; i <= 500000; i++) {
			resp[i] = cont;
			if (ehPotenciaDeDois(i)) cont = 2;
			else cont += 2;
		}
	}
	
	static boolean ehPotenciaDeDois(int n) {
		int k = (int) Math.round(Math.log(n) / Math.log(2));
		return n == (int) Math.pow(2, k);
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(readLn());
		
		while (n != 0) {
			System.out.println(resp[n]);
			
			
			
			n = Integer.parseInt(readLn());
		}
	}

}