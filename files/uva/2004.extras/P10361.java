
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
			
			String linha1 = readLn();
			String linha2 = readLn();
			
			String s1 = linha1.substring(0, linha1.indexOf("<"));
			String s2 = linha1.substring(linha1.indexOf("<") + 1, linha1.indexOf(">"));
			String s3 = linha1.substring(linha1.indexOf(">") + 1, linha1.lastIndexOf("<"));
			String s4 = linha1.substring(linha1.lastIndexOf("<") + 1, linha1.lastIndexOf(">"));
			String s5 = linha1.substring(linha1.lastIndexOf(">") + 1);
			
			String resultado = linha2.substring(0, linha2.length() - 3);
			resultado += s4 + s3 + s2 + s5;
			
			System.out.println(s1 + s2+ s3 + s4 + s5);
			System.out.println(resultado);
			
		}
	}
}
