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
            if (car == newLine.charAt(0)) System.in.skip(newLine.length() - 1);
        } catch (java.io.IOException e) { return (null); }
        if ((car < 0) && (buffer.length() == 0)) return (null);
        return (buffer.toString()).trim();
    }
	
	public static void main(String[] args) {
		String linha;
		StringTokenizer tks;
		
		int nTestes = Integer.parseInt(readLn());
		
		for (int c = 0; c < nTestes; c++) {
			
			linha = readLn();
			tks = new StringTokenizer(linha);
			
			int numeroDeParentes = Integer.parseInt(tks.nextToken());
			int[] casas = new int[numeroDeParentes];
			
			for (int i = 0; i < numeroDeParentes; i++) {
				casas[i] = Integer.parseInt(tks.nextToken());
			}
			
			ordena(casas);
			
			int d1 = calculaSoma(casas, numeroDeParentes / 2);
			int d2 = d1;
			
			if (numeroDeParentes % 2 == 0) {
				d2 = calculaSoma(casas, numeroDeParentes / 2 - 1);
			}
			
			System.out.println(Math.min(d1, d2));
		}
	}
	
	static int calculaSoma(int[] casas, int posicao) {
		int d = 0;
		for (int i = 0; i < casas.length; i++) {
			d += Math.abs(casas[posicao] - casas[i]);
		}
		return d;
	}
	
	static void ordena(int[] array) {
		for (int i = 1; i < array.length; i++) {
			for (int j = array.length - 1; j >= i; j--) {
				if (array[j - 1] > array[j]) {
					int aux = array[j - 1];
					array[j - 1] = array[j];
					array[j] = aux;
				}
			}
		}
	}

}
