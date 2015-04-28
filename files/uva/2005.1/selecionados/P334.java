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
	
	static int total;

	public static void main(String[] args) {
		String linha = readLn();
		int ne = Integer.parseInt(linha);
		
		int nTeste = 0;
		
		while (ne != 0) {
		
			StringTokenizer tks;
			Vector eventos = new Vector();
			Hashtable vertices = new Hashtable();
			
			for (int i = 0; i < ne; i++) {
				linha = readLn();
				tks = new StringTokenizer(linha);
				
				int aux = Integer.parseInt(tks.nextToken());
				
				linha = "";
				
				for (int j = 0; j < aux; j++) {
					String evento = tks.nextToken();
					linha += " " + evento;
					vertices.put(evento, evento);
				}
				
				if (!linha.equals("")) eventos.addElement(linha.trim());
			}
			
			
			boolean[][] array = new boolean[vertices.size()][vertices.size()];
			
			String[] tradutor = new String[vertices.size()];
			int cont = 0;
			Enumeration e = vertices.keys();
			while (e.hasMoreElements()) {
				array[cont][cont] = true;
				tradutor[cont++] = (String) e.nextElement();
			}
			
			vertices = new Hashtable();
			for (int i = 0; i < tradutor.length; i++) {
				vertices.put(tradutor[i], ""+i);
			}
			
			
			for (int i = 0; i < eventos.size(); i++) {
				tks = new StringTokenizer((String) eventos.elementAt(i));
				
				String s1 = tks.nextToken();
				
				while (tks.hasMoreTokens()) {
					String s2 = tks.nextToken();
					
					int p1 = Integer.parseInt((String) vertices.get(s1));
					int p2 = Integer.parseInt((String) vertices.get(s2));
					array[p1][p2] = true;
					
					
					s1 = s2;
				}
			}
			
			int nm = Integer.parseInt(readLn());
			
			for (int i = 0; i < nm; i++) {
				tks = new StringTokenizer(readLn());
				
				String s1 = tks.nextToken();
				String s2 = tks.nextToken();
				
				int p1 = Integer.parseInt((String) vertices.get(s1));
				int p2 = Integer.parseInt((String) vertices.get(s2));
				
				array[p1][p2] = true;
			}
			
			
			
			flood(array);
			
			preencheResto(array);

			
			System.out.print("Case " + (++nTeste) + ", ");
			String conta = conta(array, tradutor);
			if ("".equals(conta)) System.out.println("no concurrent events.");
			else {
				System.out.println(total + " concurrent events:");
				System.out.println(conta);
			}
			
			
			
			
			linha = readLn();
			ne = Integer.parseInt(linha);
		}
	}
	
	static String conta(boolean[][] array, String[] tradutor) {
		total = 0;
		boolean possui = false;
		String retorno = "";
		
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (!array[i][j]) {
					possui = true;
					if (total < 2) retorno += "("+tradutor[j]+","+tradutor[i]+") ";
					total++;
				}
			}
		}
		
		return (possui ? retorno : "");
	}
	
	static void preencheResto(boolean[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i][j]) array[j][i] = true;
			}
		}
	}
	
	static void flood(boolean[][] array) {
		for (int k = 0; k < array.length; k++) {
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length; j++) {
					if (array[i][k] && array[k][j]) array[i][j] = true;
				}
			}
		}
	}

}
