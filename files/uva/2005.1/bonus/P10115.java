
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
		
		int size = Integer.parseInt(linha);
		
		while (size != 0) {
			
			String[][] tabela = new String[size][2];
			
			for (int g = 0; g < size; g++) {
				String find = readLn();
				String replaceBy = readLn();
				
				tabela[g][0] = find;
				tabela[g][1] = replaceBy;
			}
			
			String texto = readLn();
			
			for (int i = 0; i < tabela.length; i++) {
				
				while (texto.indexOf(tabela[i][0]) >= 0) {
					String antes = texto.substring(0, texto.indexOf(tabela[i][0]));
					String depois = texto.substring(texto.indexOf(tabela[i][0]) + tabela[i][0].length());
					
					texto = antes + tabela[i][1] + depois;
				}
				
			}
			
			System.out.println(texto);
			
			
			
			
			
			linha = readLn();
			size = Integer.parseInt(linha);
		}
	}

}
