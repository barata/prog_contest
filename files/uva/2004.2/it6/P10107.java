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
		String linha;
		
		linha = readLn();
		
		Vector numeros = new Vector();
		
		while (linha != null) {
			Integer numero = new Integer(linha);
			
			insereOrdenado(numeros, numero);
			
			int mediana;
			
			int n1 = ((Integer) numeros.elementAt(numeros.size() / 2)).intValue();
			int n2 = n1;
			
			if (numeros.size() % 2 == 0) {
				n2 = ((Integer) numeros.elementAt(numeros.size() / 2 - 1)).intValue();
			}
			
			System.out.println((n1 + n2) / 2);
			
			
			linha = readLn();
		}
	}
	
	static void insereOrdenado(Vector lista, Integer valor) {
		boolean inseriu = false;
		for (int i = 0; !inseriu && i < lista.size(); i++) {
			Integer aux = (Integer) lista.elementAt(i);
			
			if (aux.compareTo(valor) >= 0) {
				lista.insertElementAt(valor, i);
				inseriu = true;
			}
		}
		
		if (!inseriu) lista.addElement(valor);
	}
}
