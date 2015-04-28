
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
        return buffer.toString(); 
    }
	
	public static void main(String[] args) {
		int cont = 0;
		
		int n = Integer.parseInt(readLn().trim());
		
		while (n != 0) {
			String[] correto = new String[n];
			
			for (int i = 0; i < n; i++) {
				correto[i] = readLn();
			}
			
			int m = Integer.parseInt(readLn().trim());
			String[] time = new String[m];
			
			for (int i = 0; i < m; i++) {
				time[i] = readLn();
			}
			
			System.out.print("Run #" + (++cont) + ": ");
			
			if (isAccept(correto, time)) {
				System.out.println("Accepted");
			} else if (isPE(correto, time)) {
				System.out.println("Presentation Error");
			} else {
				System.out.println("Wrong Answer");
			}
			
			
			
			n = Integer.parseInt(readLn().trim());
		}
	}

	static boolean isAccept(String[] correto, String[] time) {
		if (time.length != correto.length) return false;
		
		for (int i = 0; i < correto.length; i++) {
			if (! time[i].equals(correto[i]) ) return false;
		}
		
		return true;
	}
	
	static boolean isPE(String[] correto, String[] time) {
		StringBuffer sbCorreto = new StringBuffer();
		StringBuffer sbTime = new StringBuffer();
		
		for (int i = 0; i < correto.length; i++) {
			for (int j = 0; j < correto[i].length(); j++) {
				char ch = correto[i].charAt(j);
				
				if (ch >= '0' && ch <= '9') sbCorreto.append(ch);
			}
		}
		
		for (int i = 0; i < time.length; i++) {
			for (int j = 0; j < time[i].length(); j++) {
				char ch = time[i].charAt(j);
				
				if (ch >= '0' && ch <= '9') sbTime.append(ch);
			}
		}
		
		return sbCorreto.toString().equals(sbTime.toString());
	}

}
