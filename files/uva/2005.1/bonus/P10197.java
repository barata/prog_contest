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
            if (car == newLine.charAt(0)) 
            System.in.skip(newLine.length() - 1); 
        } catch (java.io.IOException e) { return (null);} 
        if ((car < 0) && (buffer.length() == 0)) return (null); 
        return (buffer.toString()).trim(); 
    }
	
	static final char ACENTO = (char) 243;
	
	public static void main(String[] args) {
		String linha = readLn();
		
		boolean deveImprimir = false;
		
		while (linha != null) {
			StringTokenizer tks = new StringTokenizer(linha);
			
			String v1 = tks.nextToken();
			String v2 = tks.nextToken("\n").trim();
			
			if (deveImprimir) System.out.println();
			else deveImprimir = true;
			
			System.out.println(v1 + " (to " + v2 + ")");
			
			conjugar(v1);
			
			linha = readLn();
		}
	}

	static void conjugar(String v1) {
		if (v1.length() < 2 || !v1.endsWith("r")) {
			System.out.println("Unknown conjugation");
		} else {
		
			String root = v1.substring(0, v1.length() - 2);
			char tv = v1.charAt(v1.length() - 2);
			
			String[] termos = new String[6];
			
			switch (tv) {
			
				case 'a': case 'e':
					
					termos[0] = root + "o";
					termos[1] = root + tv + "s";
					termos[2] = root + tv;
					termos[3] = root + tv + "mos";
					termos[4] = root + tv + "is";
					termos[5] = root + tv + "m";
					
					imprime(termos);
					
					break;
				case 'i':
					
					termos[0] = root + "o";
					termos[1] = root + "es";
					termos[2] = root + "e";
					termos[3] = root + tv + "mos";
					termos[4] = root + tv + "s";
					termos[5] = root + "em";
					
					imprime(termos);
					
					break;
				default:
					System.out.println("Unknown conjugation");
			}
		}
	}
	
	static void imprime(String[] termos) {
		System.out.println("eu        " + termos[0]);
		System.out.println("tu        " + termos[1]);
		System.out.println("ele/ela   " + termos[2]);
		System.out.println("n" + ACENTO + "s       " + termos[3]);
		System.out.println("v" + ACENTO + "s       " + termos[4]);
		System.out.println("eles/elas " + termos[5]);
	}

}
