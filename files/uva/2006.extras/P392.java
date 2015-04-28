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
	
	public static void main(String[] args) {
		String line = readLn();
		
		while (line != null) {
			StringTokenizer tks = new StringTokenizer(line);
			String result = "";
			
			for (int i = 8; i >= 0; i--) {
				int coefficient = Integer.parseInt(tks.nextToken());
				
				if (coefficient == 0) continue;
				if (result.equals("")) {
					if (coefficient < 0) result += "-";
					if (Math.abs(coefficient) != 1) result += Math.abs(coefficient);
					else if (i == 0) result += Math.abs(coefficient);
				} else {
					if (coefficient < 0) result += " - ";
					else result += " + ";
					if (Math.abs(coefficient) != 1) result += Math.abs(coefficient);
					else if (i == 0) result += Math.abs(coefficient);
				}
				if (i != 0) {
					result += "x";
					if (i > 1) result += "^" + i;
				}
			}
			
			if (result.equals("")) {
				result = "0";
			}
			
			System.out.println(result);
			
			
			
			
			line = readLn();
		}
	}

}
