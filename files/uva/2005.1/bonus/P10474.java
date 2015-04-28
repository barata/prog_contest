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
		String linha = readLn();
		StringTokenizer tks = new StringTokenizer(linha);
		
		int cont = 0;
		
		int n = Integer.parseInt(tks.nextToken());
		int q = Integer.parseInt(tks.nextToken());
		
		while (n != 0 || q != 0) {
			
			int[] array = new int[n];
			
			for (int i = 0; i < n; i++) {
				array[i] = Integer.parseInt(readLn());
			}
			
			qsort(array);
			
			System.out.println("CASE# " + (++cont) + ":");
			
			for (int i = 0; i < q; i++) {
				int valor = Integer.parseInt(readLn());
				int indice = busca(array, valor);
				
				if (indice < 0) System.out.println(valor + " not found");
				else System.out.println(valor + " found at " + (indice + 1));
			}
			
			
			
			linha = readLn();
			tks = new StringTokenizer(linha);
			
			n = Integer.parseInt(tks.nextToken());
			q = Integer.parseInt(tks.nextToken());
		}
		
	}
	
	static int busca(int[] array, int valor) {
		int indice = binarySearch(array, valor, 0, array.length - 1);
		
		if (indice < 0) return -1;
		
		while (indice > 0 && array[indice - 1] == valor) {
			indice--;
		}
		
		return indice;
	}

	static int binarySearch(int[] array, int valor, int inicio, int fim) {
		int meio = (inicio + fim) / 2;
		
		if (inicio > fim) return -1;
		else if (array[meio] == valor) return meio;
		else if (array[meio] < valor) return binarySearch(array, valor, meio + 1, fim);
		else return binarySearch(array, valor, inicio, meio - 1);
	}

	static void QuickSort(int a[], int lo0, int hi0) {
		int lo = lo0;
		int hi = hi0;
		int mid;

		if (hi0 > lo0) {

			mid = a[(lo0 + hi0) / 2];

			while (lo <= hi) {
				while ((lo < hi0) && (a[lo] < mid))
					++lo;

				while ((hi > lo0) && (a[hi] > mid))
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

	static void swap(int a[], int i, int j) {
		int T;
		T = a[i];
		a[i] = a[j];
		a[j] = T;
	}

	static void qsort(int a[]) {
		QuickSort(a, 0, a.length - 1);
	}

}
