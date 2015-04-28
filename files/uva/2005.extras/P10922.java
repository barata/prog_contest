
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
		
		while (!"0".equals(line)) {
			
			if ("9".equals(line)) System.out.println("9 is a multiple of 9 and has 9-degree 1.");
			else {
				int depth = calculateDepth(line);
				if (depth > 0) {
					System.out.println(line + " is a multiple of 9 and has 9-degree " + depth + ".");
				} else {
					System.out.println(line + " is not a multiple of 9.");
				}
			}
			
			
			line = readLn();
		}
	}
	
	static int calculateDepth(String value) {
		if (value.length() == 1) {
			if ("9".equals(value)) return 0;
			return Integer.MIN_VALUE;
		}
		
		return 1 + calculateDepth(sumDigits(value));
	}
	
	static String sumDigits(String value) {
		int sum = 0;
		
		for (int i = 0; i < value.length(); i++) {
			sum += Character.getNumericValue(value.charAt(i));
		}
		
		return String.valueOf(sum);
	}

}
