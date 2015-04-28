import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

class Main {

	static String readLn(int maxLg) { // utility function to read from stdin
		byte lin[] = new byte[maxLg];
		int lg = 0, car = -1;
		String line = "";

		try {
			while (lg < maxLg) {
				car = System.in.read();
				if ((car < 0) || (car == '\n'))
					break;
				lin[lg++] += car;
			}
		} catch (IOException e) {
			return (null);
		}

		if ((car < 0) && (lg == 0))
			return (null); // eof
		return (new String(lin, 0, lg)).trim();
	}

	public static void main(String[] args) {
		String linha;
		
		linha = readLn(255);
		int nTestes = Integer.parseInt(linha);
		
		readLn(255);
		
		for (int i = 0; i < nTestes; i++) {
			
			Hashtable fragmentosByTamanhoMap = new Hashtable();
			Integer chaves[] = new Integer[150];
			Vector result = new Vector();
			
			linha = readLn(300);
			while (linha != null && !linha.equals("")) {
				Integer tamanho = new Integer(linha.length());
				if (fragmentosByTamanhoMap.get(tamanho) == null) {
					chaves[tamanho.intValue()] = tamanho;
					fragmentosByTamanhoMap.put(tamanho, new Vector());
				}
				Vector list = (Vector) fragmentosByTamanhoMap.get(tamanho);
				list.addElement(linha);
				
				linha = readLn(300);
			}

			// pega as duas lista cuja soma dos tamanho eh igual a fileSize
			int fileSize = getFileSize(fragmentosByTamanhoMap);
			Enumeration enum = fragmentosByTamanhoMap.keys();
			while (fragmentosByTamanhoMap.size() > 0) {
				// primeira lista
				Integer size = (Integer) enum.nextElement();
				Vector list = (Vector) fragmentosByTamanhoMap.get(size);
				fragmentosByTamanhoMap.remove(size);
				
				// segunda lista
				Integer size2 = chaves[fileSize - size.intValue()];
				Vector list2;
				if (size2 == null) {
					list2 = new Vector();
				} else {
					list2 = (Vector) fragmentosByTamanhoMap.get(size2);
					fragmentosByTamanhoMap.remove(size2);
				}

				result = processa(list, list2);
			}

			if (!result.isEmpty()) {
				System.out.println(result.firstElement());
				if (i < nTestes - 1) System.out.println();
			}
		}
	}
	
	private static Vector processa(Vector list1, Vector list2) {
		Vector result = new Vector();
		
		if ((list2 == null || list2.isEmpty()) || (list1 == null || list1.isEmpty())) {
			Vector newList = (list1 != null && list1.size() > 0 ? list1 : list2);
			
			for (int i = 0; i < newList.size(); i++) {
				Vector aux = new Vector();
				for (int j = 0; j < newList.size(); j++) {
					if (i == j) continue;

					String parte1 = (String) newList.elementAt(i);
					String parte2 = (String) newList.elementAt(j);
					aux.addElement(parte1 + parte2);
					aux.addElement(parte2 + parte1);
				}
				if (i == 0) result = aux;
				else result = inter(result, aux);
			}
		} else {
			for (int i = 0; i < list1.size(); i++) {
				Vector aux = new Vector();
				for (int j = 0; j < list2.size(); j++) {
					String parte1 = (String) list1.elementAt(i);
					String parte2 = (String) list2.elementAt(j);
					aux.addElement(parte1 + parte2);
					aux.addElement(parte2 + parte1);
				}
				if (i == 0) result = aux;
				else result = inter(result, aux);
			}
		}
		return result;
	}
	
	private static Vector inter(Vector list1, Vector list2) {
		Vector result = new Vector();

		for (int i = 0; i < list1.size(); i++) {
			String elemento1 = (String) list1.elementAt(i);
			for (int j = 0; j < list2.size(); j++) {
				String elemento2 = (String) list2.elementAt(j);
				if (elemento1.equals(elemento2)) result.addElement(elemento1);
			}
		}
		
		return result;
	}

	private static int getFileSize(Hashtable hash) {
		int total = 0;
		int nTokens = 0;
		Enumeration enum = hash.keys();
		while (enum.hasMoreElements()) {
			Vector list = (Vector) hash.get(enum.nextElement());
			Enumeration enum2 = list.elements();
			while (enum2.hasMoreElements()) {
				String valor = (String) enum2.nextElement();
				total += valor.length();
				nTokens++;
			}
		}
		return total / (nTokens / 2);
	}

	private static void imprime(Hashtable hash) {
		Enumeration enum1 = hash.keys();
		while (enum1.hasMoreElements()) {
			Object chave = enum1.nextElement();
			System.out.print(chave + ":");
			
			Vector list = (Vector) hash.get(chave);
			Enumeration enum2 = list.elements();
			while (enum2.hasMoreElements()) {
				System.out.print(" " + enum2.nextElement());
			}
			System.out.println();
		}
	}

}