import java.util.Vector;

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
	
	static final String PA = "(";
	static final String CA = "[";

	public static void main(String[] args) {
		int nTestes = Integer.parseInt(readLn());
		
		for (int g = 0; g < nTestes; g++) {
			String linha = readLn();
			
			Vector pilha = new Vector();
			boolean erro = false;
			
			for (int i = 0; !erro && i < linha.length(); i++) {
				char ch = linha.charAt(i);

				try {
					
					switch (ch) {
						case '(':
							pilha.insertElementAt(PA, 0);
							break;
						case '[':
							pilha.insertElementAt(CA, 0);
							break;
						case ')':
							if (pilha.elementAt(0).equals(PA)) {
								pilha.removeElementAt(0);
							} else {
								erro = true;
							}
							break;
						case ']':
							if (pilha.elementAt(0).equals(CA)) {
								pilha.removeElementAt(0);
							} else {
								erro = true;
							}
							break;
					}
					
				} catch (ArrayIndexOutOfBoundsException e) {
					erro = true;
				}
			}
			
			if (!pilha.isEmpty()) erro = true;
			
			if (erro) System.out.println("No");
			else System.out.println("Yes");
			
		}
	}
}
