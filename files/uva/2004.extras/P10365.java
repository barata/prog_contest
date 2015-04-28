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

	public static void main(String[] args) {
		int nTestes = Integer.parseInt(readLn());
		
		for (int g = 0; g < nTestes; g++) {
			int n = Integer.parseInt(readLn());
			
			int min = Integer.MAX_VALUE;
			
			for (int a = 1; a <= n; a++) {
				for (int b = 1; b <= n; b++) {
					if (a * b > n) break;
					
					for (int c = 1; c <= n; c++) {
						
						if (a * b * c > n) break;
						else if (a * b * c == n) {
							int aux = 2*a*b + 2*a*c + 2*b*c;
							if (aux < min) min = aux;
						}

					}
				}
			}
			
			System.out.println(min);
		}
	}

}
