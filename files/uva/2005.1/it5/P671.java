import java.util.Hashtable;
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
	
	static Hashtable tabela = new Hashtable();
	static Vector lista;

	public static void main(String[] args) {
		int nTestes = Integer.parseInt(readLn());
		
		for (int g = 0; g < nTestes; g++) {
			readLn();
			
			String linha = readLn();
			tabela.clear();
			lista = new Vector();
			
			while (!"#".equals(linha)) {
				tabela.put(linha, linha);
				lista.addElement(linha);
				
				linha = readLn();
			}
			
			linha = readLn();
			
			while (!"#".equals(linha)) {
				if (tabela.get(linha) != null) {
					System.out.println(linha + " is correct");
				} else {
					System.out.print(linha + ":");
					
					for (int i = 0; i < lista.size(); i++) {
						String palavra = (String) lista.elementAt(i);
						
						if (isDistanceOne(palavra, linha)) {
							System.out.print(" " + palavra);
						}
					}
					
					System.out.println();
				}
				
				linha = readLn();
			}
			
			if (g < nTestes - 1) System.out.println();
		}
	}
	
	static boolean isDistanceOne(String p1, String p2) {
		int a, b;
		int len_a = p1.length();
		int len_b = p2.length();
		
		if (Math.abs(len_a - len_b) > 1) return false;
		
		if (len_a == len_b) {
			int cont = 0;
			for (a = 0; a < len_a; a++) {
				if (p1.charAt(a) != p2.charAt(a)) {
					cont++;
					if (cont > 1) return false;
				}
			}
			return cont == 1;
		}
		
		if (len_b < len_a) {
			String aux = p2;
			p2 = p1;
			p1 = aux;
		}
		int min = Math.min(len_a, len_b);
		char[] temp1 = new char[min];
		p1.getChars(0, min, temp1, 0);
		char[] temp2 = new char[min+1];
		p2.getChars(0, min+1, temp2, 0);
		
		b = 0;
		for (a = 0; a < min; a++) {
			if (temp1[a] != temp2[a + b]) {
				if (b == 0) {
					b = 1;
					a--;
				}
				else return false;
			}
		}
		return true;
	}

}
