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
		String linha = readLn();
		
		Hashtable tabela = new Hashtable();
		Vector lista = new Vector();
		
		while (linha != null) {
			StringTokenizer tks = new StringTokenizer(linha);
			
			while (tks.hasMoreTokens()) {
				Integer i = new Integer(tks.nextToken());
				
				if (!tabela.containsKey(i)) {
					lista.addElement(i);
					tabela.put(i, new Integer(0));
				}
				
				Integer cont = (Integer) tabela.get(i);
				Integer novo = new Integer(cont.intValue() + 1);
				tabela.put(i, novo);
			}
			
			linha = readLn();
		}
		
		Enumeration enum = lista.elements();
		while (enum.hasMoreElements()) {
			Object i = enum.nextElement();
			System.out.println(i + " " + (Integer) tabela.get(i));
		}
	}
}
