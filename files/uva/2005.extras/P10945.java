
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
		String line = readLn();
		
		while (!"DONE".equals(line)) {
			
			if (ehPalindrome(line)) {
				System.out.println("You won't be eaten!");
			} else {
				System.out.println("Uh oh..");
			}
			
			
			
			line = readLn();
		}
	}

	static boolean ehPalindrome(String line) {
		String prepared = "";
		for (int i = 0; i < line.length(); i++) {
			char ch = line.toLowerCase().charAt(i);
			if (ch >= 'a' && ch <= 'z') prepared += ch;
		}
		
		for (int i = 0; i < prepared.length() / 2; i++) {
			char ch1 = prepared.charAt(i);
			char ch2 = prepared.charAt(prepared.length() - i - 1);
			if (ch1 != ch2) return false;
		}
		
		return true;
	}

}
