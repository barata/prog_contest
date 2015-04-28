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
		
		for (int g = 0; g < nTestes; g++) {
			readLn();
			
			int tamanhoTotal = Integer.parseInt(readLn());
			Vector segmentos = new Vector();
			
			StringTokenizer tks = new StringTokenizer(readLn());
			int x1 = Integer.parseInt(tks.nextToken());
			int x2 = Integer.parseInt(tks.nextToken());
			
			while (x1 != 0 || x2 != 0) {
				
				segmentos.addElement(new Segmento(x1, x2));
				
				
				tks = new StringTokenizer(readLn());
				x1 = Integer.parseInt(tks.nextToken());
				x2 = Integer.parseInt(tks.nextToken());
			}
			
			qsort(segmentos);
			
			Vector resposta = greedy(segmentos, tamanhoTotal);
			
			if (resposta == null) System.out.println("0");
			else System.out.println(resposta.size());
			
			if (resposta != null && !resposta.isEmpty()) {
				for (int i = 0; i < resposta.size(); i++) {
					Segmento aux = (Segmento) resposta.elementAt(i);
					
					System.out.println(aux.inicio + " " + aux.fim);
				}
			}
			
			if (g < nTestes - 1) System.out.println();
			
		}
	}

	static Vector greedy(Vector segmentos, int tamanhoTotal) {
		Vector solucao = new Vector();
		
		for (int i = 0; i < segmentos.size(); i++);
		
		int posicao = 0;
		int indice = seleciona(segmentos, 0, posicao);
		
		while (indice >= 0 && posicao < tamanhoTotal) {
			Segmento aux = (Segmento) segmentos.elementAt(indice);
			posicao = aux.fim;
			solucao.addElement(aux);
			
			indice = seleciona(segmentos, indice, posicao);
		}
		
		if (posicao >= tamanhoTotal) return solucao;
		return null;
	}

	static int seleciona(Vector segmentos, int indiceInicial, int posicao) {
		int indice = -1;
		int fim = posicao;
		
		for (int i = indiceInicial; i < segmentos.size(); i++) {
			Segmento aux = (Segmento) segmentos.elementAt(i);
			
			if (aux.inicio > posicao) break;
			if (aux.ehViavel(posicao) && aux.fim > fim) {
				indice = i;
				fim = aux.fim;
			}
		}
		
		return indice;
	}
	
	static void QuickSort(Vector a, int lo0, int hi0) {
		int lo = lo0;
		int hi = hi0;
		Segmento mid;

		if (hi0 > lo0) {

			mid = (Segmento) a.elementAt((lo0 + hi0) / 2);

			while (lo <= hi) {
				while ((lo < hi0) && (((Segmento) a.elementAt(lo)).inicio < mid.inicio))
					++lo;

				while ((hi > lo0) && (((Segmento) a.elementAt(hi)).inicio > mid.inicio))
					--hi;

				if (lo <= hi) {
					swap(a, lo, hi);

					++lo;
					--hi;
				}
			}

			if (lo0 < hi)
				QuickSort(a, lo0, hi);

			if (lo < hi0)
				QuickSort(a, lo, hi0);

		}
	}

	static void swap(Vector a, int i, int j) {
		Segmento e1 = (Segmento) a.elementAt(i);
		Segmento e2 = (Segmento) a.elementAt(j);
		
		a.setElementAt(e2, i);
		a.setElementAt(e1, j);
	}

	static void qsort(Vector a) {
		QuickSort(a, 0, a.size() - 1);
	}

}
class Segmento {
	public int inicio;
	public int fim;
	
	public Segmento(int inicio, int fim) {
		this.inicio = inicio;
		this.fim = fim;
	}
	
	public boolean ehViavel(int posicao) {
		return this.inicio <= posicao && this.fim > posicao;
	}

	public String toString() {
		return inicio + " " + fim;
	}
}