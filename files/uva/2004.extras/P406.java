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
	
	static final int MAX = 1001;
	
	static int[] numerosPrimos = new int[MAX];
	
	static int size;

	static {
		boolean[] primos = new boolean[MAX];
		
		int i, j;

		primos[1] = true;
		primos[2] = true;
		primos[3] = true;

		for (i = 5; i < MAX; i += 2) {
			for (j = 3; j * j <= i; j += 2)
				if (i % j == 0)
					break;
			if (i % j != 0)
				primos[i] = true;
		}
		
		size = 0;
		
		for (i = 1; i < MAX; i++) {
			if (primos[i]) numerosPrimos[size++] = i;
		}
	}

	public static void main(String[] args) {
		String linha = readLn();
		
		while (linha != null) {
			StringTokenizer tks = new StringTokenizer(linha);
			
			int n = Integer.parseInt(tks.nextToken());
			int c = Integer.parseInt(tks.nextToken());
			
			if (n == 1) {
				System.out.println("1 " + c + ": 1\n");
			} else {
				// procura o indice do ultimo elemento
				int indiceN = 0;
				for (; indiceN < size && numerosPrimos[indiceN] <= n; indiceN++);
				indiceN--;
				
				int fim = indiceN / 2;
				int inicio = fim - (c - 1);
				if (inicio < 0) {
					inicio = 0;
					fim = indiceN;
				} else {
					fim += c;
					if (indiceN % 2 == 0) fim--;
				}
				
				System.out.print(n + " " + c + ":");
				
				for (int i = inicio; i <= fim; i++) {
					System.out.print(" " + numerosPrimos[i]);
				}
				
				System.out.println("\n");
			}
			
			linha = readLn();
		}
	}
}
