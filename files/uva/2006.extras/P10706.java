
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
		int t = Integer.parseInt(readLn());
		
		for (int g = 0; g < t; g++) {
			int i = Integer.parseInt(readLn());
			
			int linha = 1;
			StringBuffer soma = new StringBuffer();
			
			while (i > 0) {
				soma.append(linha++);
				i -= soma.length();
			}
			
			System.out.println(soma.charAt(soma.length() - 1 + i));
		}
	}

}
