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
		
		boolean devePular = false;
		
		while (linha != null) {
			int n = Integer.parseInt(linha);
			
			Hashtable tabela = new Hashtable();
			Vector lista = new Vector();
			
			linha = readLn();
			StringTokenizer tks = new StringTokenizer(linha);
			
			for (int i = 0; i < n; i++) {
				String nome = tks.nextToken();
				lista.addElement(nome);
				tabela.put(nome, "" + i);
			}
			
			int[][] matriz = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				linha = readLn();
				tks = new StringTokenizer(linha);
				
				String nome = tks.nextToken();
				int valor = Integer.parseInt(tks.nextToken());
				int k = Integer.parseInt(tks.nextToken());
				int qnt = (k == 0 ? 0 : valor / k);
				
				for (int j = 0; j < k; j++) {
					String nome2 = tks.nextToken();
					
					int indice = Integer.parseInt((String) tabela.get(nome));
					int indice2 = Integer.parseInt((String) tabela.get(nome2));
					
					matriz[indice][indice2] = qnt;
				}
			}
			

			if (devePular) System.out.println();
			else devePular = true;
			
			for (int i = 0; i < lista.size(); i++) {
				String nome = (String) lista.elementAt(i);
				int indice = Integer.parseInt((String) tabela.get(nome));
				
				int soma1 = 0;
				int soma2 = 0;
				
				for (int j = 0; j < matriz[indice].length; j++) {
					soma1 += matriz[indice][j];
				}
				
				for (int j = 0; j < matriz.length; j++) {
					soma2 += matriz[j][indice];
				}
				
				System.out.println(nome + " " + (soma2 - soma1));
			}
			
			
			
			
			
			
			linha = readLn();
		}
	}

}
