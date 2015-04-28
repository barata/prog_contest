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
		String numero = readLn();
		long numeroOriginal = Long.parseLong(numero);
		
		while (numeroOriginal != 0) {
		
			long n1 = Long.parseLong(ordena(numero, false));
			long n2 = Long.parseLong(ordena(numero, true));
			
			System.out.println("Original number was " + numero);
			System.out.println(n1 + " - " + n2 + " = " + (n1 - n2));
			
			numero = String.valueOf(n1 - n2);
			
			Hashtable tabela = new Hashtable();
			int length = 1;
			
			while (!tabela.containsKey(numero)) {
				tabela.put(numero, "");
				
				n1 = Long.parseLong(ordena(numero, false));
				n2 = Long.parseLong(ordena(numero, true));
				
				numero = String.valueOf(n1 - n2);
				
				System.out.println(n1 + " - " + n2 + " = " + (n1 - n2));
				length++;
			}
			
			System.out.println("Chain length " + length);
			System.out.println();
			
			numero = readLn();
			numeroOriginal = Long.parseLong(numero);
		}
	}
	
	static String ordena(String numero, boolean crescente) {
		char[] array = new char[numero.length()];
		
		numero.getChars(0, array.length, array, 0);
		
		for (int i = 1; i < array.length; i++) {
			for (int j = array.length - 1; j >= i; j--) {
				if (array[j] < array[j - 1] == crescente) {
					char aux = array[j];
					array[j] = array[j - 1];
					array[j - 1] = aux;
				}
			}
		}
		
		return new String(array);
	}

}
