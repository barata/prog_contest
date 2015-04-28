import java.util.Enumeration;
import java.util.Hashtable;

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
		
		int nTestes = Integer.parseInt(linha);
		
		for (int g = 0; g < nTestes; g++) {
			
			String frase = readLn();
			Hashtable tabela = new Hashtable();

			int numero = Integer.parseInt(readLn());
			
			for (int i = 0; i < numero; i++) {
				String palavra = readLn();
				char resposta = 'n';
				boolean achou = false;
				
				if (tabela.containsKey(palavra)) {
					if (tabela.get(palavra).equals("y")) resposta = 'y';
					else resposta = 'n';
					
					achou = true;
				} else {
					Enumeration enum = tabela.keys();
					while (enum.hasMoreElements()) {
						String p = (String) enum.nextElement();
						if (p.indexOf(palavra) >= 0) {
							tabela.put(palavra, "y");
							resposta = 'y';
							
							achou = true;
							break;
						}
					}
				}
				
				if (!achou) {
					if (frase.indexOf(palavra) < 0) {
						tabela.put(palavra, "n");
						resposta = 'n';
					} else {
						tabela.put(palavra, "y");
						resposta= 'y';
					}
				}
				
				System.out.println(resposta);
			}
			
		}
	}
}
