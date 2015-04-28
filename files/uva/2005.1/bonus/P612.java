import java.util.Hashtable;
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
	
	public static void main(String[] args) {
		int nTestes = Integer.parseInt(readLn());
		
		for (int g = 0; g < nTestes; g++) {
			readLn();
			
			String linha = readLn();
			StringTokenizer tks = new StringTokenizer(linha);
			
			tks.nextToken();
			int numeroPalavras = Integer.parseInt(tks.nextToken());
			
			String[] lista = new String[numeroPalavras];
			
			for (int i = 0; i < numeroPalavras; i++) {
				lista[i] = readLn();
			}
			
			Hashtable tabela = new Hashtable();
			for (int i = 0; i < lista.length; i++) {
				tabela.put(lista[i], new Integer(sortedness(lista[i])));
			}
			
			ordena(lista, tabela);
			
			// imprime
			for (int i = 0; i < lista.length; i++) {
				System.out.println(lista[i]);
			}
			if (g < nTestes - 1) System.out.println();
			
		}
	}
	
	static void ordena(String[] array, Hashtable tabela) {
		for (int i = 1; i < array.length; i++) {
			for (int j = array.length - 1; j >= i; j--) {
				int a = ((Integer) tabela.get(array[j])).intValue();
				int b = ((Integer) tabela.get(array[j - 1])).intValue();
				
				if (a < b) {
					String aux = array[j];
					array[j] = array[j - 1];
					array[j - 1] = aux;
				}
			}
		}
	}
	
	static int sortedness(String palavra) {
		int cont = 0;

		for (int i = 0; i < palavra.length() - 1; i++) {
			char ch1 = palavra.charAt(i);
			
			for (int j = i + 1; j < palavra.length(); j++) {
				char ch2 = palavra.charAt(j);

				if (ch1 > ch2) cont++;
			}
		}
		
		return cont;
	}

}
