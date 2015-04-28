import java.io.IOException;

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
		int nTestes = Integer.parseInt(readLn(255));
		
		for (int c = 1; c <= nTestes; c++) {
			
			int num1 = Integer.parseInt(readLn(255));
			int num2 = Integer.parseInt(readLn(255));
			
			System.out.println("Case " + c + ": " + getSum(num1, num2));
		}
	}
	
	static long getSum(int num1, int num2) {
		long result = 0;
		
		int inicio = num1;
		if (inicio % 2 == 0) inicio++;
		
		for (int i = inicio; i <= num2; i += 2) {
			result += i;
		}
		
		return result;
	}
}
