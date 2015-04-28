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

	public static void main(String[] args) {
		String linha = readLn();
		int nTeste = 0;
		
		while (linha != null) {
			
			// leitura de um caso
			Vector lista = new Vector();
			lista.addElement(linha);
			
			linha = readLn();

			while (! linha.equals("9") ) {
				lista.addElement(linha);
				
				linha = readLn();
			}
			
			// processa
			boolean achou = false;
			
			for (int i = 0; !achou && i < lista.size() - 1; i++) {
				for (int j = i + 1; !achou && j < lista.size(); j++) {
					String s1 = (String) lista.elementAt(i);
					String s2 = (String) lista.elementAt(j);
					
					if (s1.startsWith(s2) || s2.startsWith(s1)) achou = true;
				}
			}
			
			String resultado = "Set " + (++nTeste) + " is";
			if (achou) {
				resultado += " not";
			}
			resultado += " immediately decodable";
			
			System.out.println(resultado);

			linha = readLn();
		}

	}

}
