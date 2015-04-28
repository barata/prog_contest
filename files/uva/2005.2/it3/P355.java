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
	
	static String[] table = new String[17];
	
	static {
		table[0] = "0";
		table[1] = "1";
		table[2] = "2";
		table[3] = "3";
		table[4] = "4";
		table[5] = "5";
		table[6] = "6";
		table[7] = "7";
		table[8] = "8";
		table[9] = "9";
		table[10] = "A";
		table[11] = "B";
		table[12] = "C";
		table[13] = "D";
		table[14] = "E";
		table[15] = "F";
	}

	public static void main(String[] args) {
		String line = readLn();
		
		while (line != null) {
			StringTokenizer tks = new StringTokenizer(line);
			
			int originalBase = Integer.parseInt(tks.nextToken());
			int base = Integer.parseInt(tks.nextToken());
			String originalNumber = tks.nextToken();
			
			try {
				long number = Long.parseLong(originalNumber, originalBase);
				
				System.out.println(originalNumber + " base " + originalBase + " = " + convert(number, base) + " base " + base);
			} catch (NumberFormatException e) {
				System.out.println(originalNumber + " is an illegal base " + originalBase + " number");
			}
			
			
			
			
			line = readLn();
		}
	}
	
	static String convert(long number, int base) {
		if (number < base) return table[(int) number];
		return convert(number / base, base) + table[(int) (number % base)];
	}

}
