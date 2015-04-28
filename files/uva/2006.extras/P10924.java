
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
	
	static int[] table = new int[256];
	
	static {
		for (char ch = 'a'; ch <= 'z'; ch++) {
			table[ch] = ch - 'a' + 1;
		}
		
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			table[ch] = ch - 'A' + 27;
		}
	}

	public static void main(String[] args) {
		String line = readLn();
		
		while (line != null) {
			
			int sum = getWordValue(line);
			
			System.out.print("It is ");
			if (! isPrime(sum) ) {
				System.out.print("not ");
			}
			System.out.println("a prime word.");
			
			line = readLn();
		}
	}

	static int getWordValue(String word) {
		int sum = 0;
		for (int i = 0; i < word.length(); i++) {
			sum += table[word.charAt(i)];
		}
		return sum;
	}
	
	static boolean isPrime(int number) {
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) return false;
		}
		return true;
	}

}
