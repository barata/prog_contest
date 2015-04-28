
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
			
			StringBuffer sb = new StringBuffer();
			sb.append(line).append(" is ");
			if (!div11(line)) sb.append("not ");
			sb.append("a multiple of 11.");
			
			System.out.println(sb);
			
			
			
			
			line = readLn();
		}
	}

	static boolean div11(String line) {
		int s1 = 0;
		int s2 = 0;
		
		for (int i = 0; i < line.length(); i++) {
			int value = Character.getNumericValue(line.charAt(i));
			
			if (i % 2 == 0) s1 += value;
			else s2 += value;
		}
		
		return (s1 - s2) % 11 == 0;
	}

}
