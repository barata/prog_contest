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
	
	static String division;
	
	public static void main( String[ ] args ) {
		String line = readLn();
		
		while (line != null) {
			StringTokenizer tks = new StringTokenizer(line, "/%", true);
			
			String operand1 = tks.nextToken().trim();
			String operator = tks.nextToken();
			String operand2 = tks.nextToken().trim();
			
			long mod = 0;
			
			division = "";
			mod = divide(operand1, operand2, operand2.length());
			format();
			
			if ("/".equals(operator)) {
				System.out.println(division);
			} else if ("%".equals(operator)) {
				System.out.println(mod);
			}
			
			
			line = readLn();
		}
	}
	
	static void format() {
		int k = 0;
		for (; k < division.length(); k++) {
			if (division.charAt(k) != '0') {
				break;
			}
		}
		division = division.substring(k);
		if ("".equals(division)) division = "0";
	}
	
	static long divide(String n1, String n2, int i) {
		if (n1.length() <= n2.length() && Long.parseLong(n1) < Long.parseLong(n2)) {
			if (i <= n1.length()) division += "0";
			return Long.parseLong(n1);
		}
		
		int index = i;
		while (index < n1.length() && Long.parseLong(n1.substring(0, index)) < Long.parseLong(n2)) {
			division += "0";
			index++;
		}
		
		division += Long.parseLong(n1.substring(0, index)) / Long.parseLong(n2);
		String resto = String.valueOf(Long.parseLong(n1.substring(0, index)) % Long.parseLong(n2));
		return divide(resto + n1.substring(index), n2, resto.length() + 1);
	}
	
}