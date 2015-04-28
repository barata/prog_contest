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
		
		while (!linha.equals(".")) {

			boolean achou = false;
			int fator = (linha.length() / 2) + (linha.length() % 2);
			int i;
			
			for (i = 1; i <= fator; i++) {
				if (linha.length() % i != 0) continue;
				
				String padrao = linha.substring(0, i);
				achou = true;
				
				for (int j = 1; j * i < linha.length(); j++) {

					if (!linha.substring(j * i, j * i + i).equals(padrao)) {
						achou = false;
						break;
					}
					
				}
				
				if (achou) break;
			}
			
			if (achou) {
				System.out.println(linha.length() / i);
			} else {
				System.out.println(1);
			}

			
			
			linha = readLn();
		}
	}

}
