
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
		int n = Integer.parseInt(readLn());
		
		while (n != 0) {
			
			int numberOfXs = 0;
			int maxNumberOfXs = 0;
			
			for (int i = 0; i < n; i++) {
				
				int partialNumberOfXs = 0;
				String line = readLn();
				
				for (int j = 0; j < line.length(); j++) {
					if (line.charAt(j) == 'X') partialNumberOfXs++;
				}
				
				numberOfXs += partialNumberOfXs;
				maxNumberOfXs = Math.max(maxNumberOfXs, partialNumberOfXs);
			}
			
			System.out.println(maxNumberOfXs * n - numberOfXs);
			
			
			n = Integer.parseInt(readLn());
		}
	}

}
