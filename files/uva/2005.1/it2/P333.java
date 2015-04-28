
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
        return (buffer.toString().trim()); 
    }

	public static void main(String[] args) {
		String linha = readLn();
		
		while (linha != null) {
			
			if (! checagemSintatica(linha) ) {
				System.out.println(linha + " is incorrect.");
			} else {
			
				String isbn = formataISBN(linha);
				int[] array = geraArray(isbn);

				int soma = 0;
				
				for (int i = 0; i < array.length; i++) {
					soma += array[i];
				}

				if (soma % 11 == 0) {
					System.out.println(linha + " is correct.");
				} else {
					System.out.println(linha + " is incorrect.");
				}
			
			}
			
			linha = readLn();
		}
	}
	
	static int[] geraArray(String isbn) {
		int[] array = new int[isbn.length()];
		
		char ch = isbn.charAt(0);
		if (ch == 'X') array[0] = 10;
		else array[0] = Character.getNumericValue(ch);
		
		for (int i = 1; i < isbn.length(); i++) {
			ch = isbn.charAt(i);
			
			int valor;
			
			if (ch == 'X') valor = 10;
			else valor = Character.getNumericValue(ch);
			
			array[i] = array[i - 1] + valor;
		}
		
		return array;
	}
	
	static String formataISBN(String isbn) {
		String resultado = "";
		int cont = 0;
		
		for (int i = 0; i < isbn.length(); i++) {
			char ch = isbn.charAt(i);
			
			if (Character.isDigit(ch)) {
				resultado += ch;
				cont++;
			} else {
				if (cont == 9 && ch == 'X') resultado += ch;
			}
		}
		
		return resultado;
	}

	static boolean checagemSintatica(String isbn) {
		int cont = 0;
		
		for (int i = 0; i < isbn.length(); i++) {
			char ch = isbn.charAt(i);
			
			if (!Character.isDigit(ch) && ch != '-' && ch != 'X') return false;
			if (Character.isDigit(ch) || (cont == 9 && ch == 'X')) cont++;
			
			if (cont > 10) return false;
		}
		
		return cont == 10;
	}

}
