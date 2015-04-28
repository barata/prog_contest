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
			
			int a = Integer.parseInt(tks.nextToken());
			int b = Integer.parseInt(tks.nextToken());
			
			computar(a, b);
			
			linha = readLn();
		}
	}
	
	static void computar(int a, int b) {
		String answer[] = { "", "", "" };
		answer = gcdPlus(a, b, 1, 0, 0, 1, 0);
		
		System.out.println(answer[2] + " " + answer[1] + " " + answer[0]);
	}
	
	static String[] gcdPlus(long a, long b, long q, long r, long s, long t, long divideResult) {
		if (b == 0) {
			String[] answer = { "", "", "" };
			answer[0] = String.valueOf(a); // gcd
			answer[1] = String.valueOf(s); // coefficient for b
			answer[2] = String.valueOf(t); // coefficient for a
			return answer;
		} else {
			// store the quotient of the divide operation
			long quo = a / b;

			// compute the new coefficients after initializing them to 0
			long temp = divideResult * s;
			long new_s = q - temp;

			temp = divideResult * t;
			long new_t = r - temp;

			// go again
			return gcdPlus(b, a % b, s, t, new_s, new_t, quo);
		}
	}
}
