import java.net.ServerSocket;
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
		
		boolean shouldSkipLine = false;
		
		int n = Integer.parseInt(tks.nextToken());
		
		while (n != 0) {
			int k = Integer.parseInt(tks.nextToken());
			
			int[][] score = new int[n + 1][2];
			
			int numberOfGames = k * n * (n - 1) / 2;
			
			for (int i = 0; i < numberOfGames; i++) {
				linha = readLn();
				tks = new StringTokenizer(linha);
				
				int playerA = Integer.parseInt(tks.nextToken());
				String valueA = tks.nextToken();
				int playerB = Integer.parseInt(tks.nextToken());
				String valueB = tks.nextToken();
				
				if (compare(valueA, valueB) < 0) {
					score[playerA][0]++;
					score[playerB][1]++;
				} else if (compare(valueA, valueB) > 0) {
					score[playerA][1]++;
					score[playerB][0]++;
				}
				
			}
			
			if (shouldSkipLine) System.out.println();
			shouldSkipLine = true;
			
			for (int i = 1; i < score.length; i++) {
				if (score[i][0] == score[i][1]) System.out.println("-");
				else System.out.println(round(1.0 * score[i][0] / (score[i][0] + score[i][1]), 3));
			}
			
			
			
			
			linha = readLn();
			tks = new StringTokenizer(linha);
			
			n = Integer.parseInt(tks.nextToken());
		}
	}
	
	static int compare(String p1, String p2) {
		if ("rock".equals(p1) && "scissors".equals(p2)) return -1;
		if ("scissors".equals(p1) && "paper".equals(p2)) return -1;
		if ("paper".equals(p1) && "rock".equals(p2)) return -1;
		
		if ("rock".equals(p2) && "scissors".equals(p1)) return 1;
		if ("scissors".equals(p2) && "paper".equals(p1)) return 1;
		if ("paper".equals(p2) && "rock".equals(p1)) return 1;
		
		return 0;
	}
	
	static String round(double valor, int casas) {
		long numero = Math.round(valor * Math.pow(10, casas));
		
		String retorno;
		if (numero < 0) retorno = "-";
		else retorno = "";
		retorno += (Math.abs(numero) / (long) Math.pow(10, casas));
		retorno += ".";
		String resto = "" + (Math.abs(numero) % (long) Math.pow(10, casas));
		resto = str('0', casas - resto.length()) + resto;
		retorno += resto;
		
		return retorno;
	}
	
	static String str(char ch, int n) {
		String resultado = "";
		for (int i = 0; i < n; i++) {
			resultado += ch;
		}
		return resultado;
	}

}
