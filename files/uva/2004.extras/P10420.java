import java.util.Enumeration;
import java.util.Hashtable;
import java.util.StringTokenizer;
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
		int nTestes = Integer.parseInt(readLn());
		
		Hashtable tabela = new Hashtable();
		Vector listaDePaises = new Vector();
		
		for (int i = 0; i < nTestes; i++) {
			String linha = readLn();
			StringTokenizer tks = new StringTokenizer(linha);
			
			String pais = tks.nextToken();
			String nome = tks.nextToken("\n");
			
			if (!tabela.containsKey(pais)) {
				listaDePaises.addElement(pais);
				tabela.put(pais, new Vector());
			}
			Vector lista = (Vector) tabela.get(pais);
			if (!lista.contains(nome)) lista.addElement(nome);
		}
		
		// ordena
		ordena(listaDePaises);
		
		// imprime
		Enumeration enum = listaDePaises.elements();
		
		while (enum.hasMoreElements()) {
			String pais = (String) enum.nextElement();
			Vector lista = (Vector) tabela.get(pais);
			
			System.out.println(pais + " " + lista.size());
		}
		
	}
	
	static void ordena(Vector lista) {
		for (int i = 1; i < lista.size(); i++) {
			for (int j = lista.size() - 1; j >= i; j--) {
				String p1 = (String) lista.elementAt(j - 1);
				String p2 = (String) lista.elementAt(j);
				
				if (p1.compareTo(p2) > 0) {
					lista.setElementAt(p2, j - 1);
					lista.setElementAt(p1, j);
				}
			}
		}
	}

}
