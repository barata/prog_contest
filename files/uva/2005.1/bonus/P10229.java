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
		String linha = readLn();
		
		while (linha != null) {
			StringTokenizer tks = new StringTokenizer(linha);
			
			long n = Long.parseLong(tks.nextToken());
			long m = Long.parseLong(tks.nextToken());
			
			System.out.println(fibo(n, (long) Math.pow(2, m)));
			
			
			linha = readLn();
		}
	}

	static long fibo(long n, long mod) {
		long i = 1;
		long h = 1;
		long j = 0;
		long k = 0;
		while (n > 0) {
			long t;
			if (n % 2 == 1) { // if n is odd
				t = ((j % mod) * (h % mod)) % mod;
				j = (((i % mod) * (h % mod)) % mod + ((j % mod) * (k % mod)) % mod + t % mod) % mod;
				i = (((i % mod) * (k % mod)) % mod + t % mod) % mod;
			}
			t = ((h % mod) * (h % mod)) % mod;
			h = ((2 * (k % mod) * (h % mod)) % mod + t % mod) % mod;
			k = (((k % mod) * (k % mod)) % mod + (t % mod)) % mod;
			n = n / 2;
		}
		return j;
	}

}
