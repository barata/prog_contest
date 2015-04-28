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
		
		for (int g = 0; g < nTestes; g++) {
			readLn();
			
			int n = Integer.parseInt(readLn());
			
			Vector origem = new Vector();
			Vector destino = new Vector();
			
			for (int i = 0; i < n; i++) {
				insereOrdenado(origem, new Integer(readLn()));
			}
			
			StringBuffer solucao = new StringBuffer();
			int soma = 0;
			
			while (origem.size() > 2) {
				
				Integer menor1 = (Integer) origem.elementAt(0);
				Integer menor2 = (Integer) origem.elementAt(1);
				Integer maior1 = (Integer) origem.elementAt(origem.size() - 2);
				Integer maior2 = (Integer) origem.elementAt(origem.size() - 1);
				
				int custoA = Math.max(menor1.intValue(), menor2.intValue()) + Math.max(maior1.intValue(), maior2.intValue()) + menor1.intValue() + menor2.intValue();
				int custoB = Math.max(menor1.intValue(), maior2.intValue()) + Math.max(menor1.intValue(), maior1.intValue()) + menor1.intValue() + menor1.intValue();
				
				if (custoA <= custoB) {
					origem.removeElement(menor2);
					insereOrdenado(destino, menor2);
					
					solucao.append(menor1);
					solucao.append(" ");
					solucao.append(menor2);
					solucao.append("\n");
					
					solucao.append(menor1);
					solucao.append("\n");
					
					soma += Math.max(menor1.intValue(), menor2.intValue()) + menor1.intValue();
					
					if (origem.size() <= 2) break;
					
					origem.removeElement(maior1);
					origem.removeElement(maior2);
					insereOrdenado(destino, maior1);
					insereOrdenado(destino, maior2);
					
					solucao.append(maior1);
					solucao.append(" ");
					solucao.append(maior2);
					solucao.append("\n");
					
					destino.removeElement(menor2);
					insereOrdenado(origem, menor2);
					
					solucao.append(menor2);
					solucao.append("\n");
					
					soma += Math.max(maior1.intValue(), maior2.intValue()) + menor2.intValue();
				} else {
					origem.removeElement(maior2);
					insereOrdenado(destino, maior2);
					
					solucao.append(menor1);
					solucao.append(" ");
					solucao.append(maior2);
					solucao.append("\n");
					
					solucao.append(menor1);
					solucao.append("\n");
					
					soma += Math.max(menor1.intValue(), maior2.intValue()) + menor1.intValue();
					
					if (origem.size() <= 2) break;
					
					origem.removeElement(maior1);
					insereOrdenado(destino, maior1);
					
					solucao.append(menor1);
					solucao.append(" ");
					solucao.append(maior1);
					solucao.append("\n");
					
					solucao.append(menor1);
					solucao.append("\n");
					
					soma += Math.max(menor1.intValue(), maior1.intValue()) + menor1.intValue();
				}
			}
			
			if (origem.size() == 1) {
				solucao.append(origem.elementAt(0));
				solucao.append("\n");
				soma += ((Integer) origem.elementAt(0)).intValue();
			} else if (origem.size() == 2) {
				solucao.append(origem.elementAt(0));
				solucao.append(" ");
				solucao.append(origem.elementAt(1));
				solucao.append("\n");
				soma += Math.max(((Integer) origem.elementAt(0)).intValue(), ((Integer) origem.elementAt(1)).intValue());
			}
			
			System.out.println(soma);
			System.out.print(solucao);
			
			if (g < nTestes - 1) System.out.println();
		}
	}

	static void insereOrdenado(Vector colecao, Comparable elemento) {
		insereOrdenado(colecao, elemento, 0, colecao.size() - 1);
	}
	
	static void insereOrdenado(Vector colecao, Comparable elemento, int inicio, int fim) {
		if (fim < inicio) {
			colecao.insertElementAt(elemento, inicio);
		} else {
			int meio = (inicio + fim) / 2;
			Object o = colecao.elementAt(meio);
			if (elemento.compareTo(o) == 0) colecao.insertElementAt(elemento, meio);
			else if (elemento.compareTo(o) < 0) insereOrdenado(colecao, elemento, inicio, meio - 1);
			else insereOrdenado(colecao, elemento, meio + 1, fim);
		}
	}

}
