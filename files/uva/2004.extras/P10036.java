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
		int nTestes = Integer.parseInt(readLn());

		for (int g = 0; g < nTestes; g++) {
			// leitura dos dados
			String linha = readLn();
			StringTokenizer tks = new StringTokenizer(linha);
			
			int valor = Integer.parseInt(tks.nextToken());
			int divisor = Integer.parseInt(tks.nextToken());
			
			int[] numeros = new int[valor];
			
			linha = readLn();
			tks = new StringTokenizer(linha);
			
			for (int i = 0; i < valor; i++) {
				int aux = Integer.parseInt(tks.nextToken());
				numeros[i] = aux;
			}
			
			// processa
			if (valor == 1) {
				if (numeros[0] % divisor == 0) System.out.println("Divisible");
				else System.out.println("Not divisible");
			} else {
				boolean[][] proc = new boolean[valor][divisor];
				proc[0][Math.abs(numeros[0]) % divisor] = true;
				
				boolean ehDivisivel = false;
				
				for (int i = 1; i < valor; i++) {
					
					for (int j = 0; j < divisor; j++) {
						
						if (proc[i - 1][j]) {
							int soma = Math.abs(j + numeros[i]) % divisor;
							int sub = Math.abs(j - numeros[i]) % divisor;
							
							if ((i == valor - 1) && (soma == 0 || sub == 0))
								ehDivisivel = true;
							
							proc[i][soma] = true;
							proc[i][sub] = true;
						}
						
					}
					
				}
				
				if (ehDivisivel) System.out.println("Divisible");
				else System.out.println("Not divisible");
			}
		}
	}
}
