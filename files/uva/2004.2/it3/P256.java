import java.io.IOException;

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
		String linha = readLn(2);
		while (linha != null && !linha.equals("")) {
			int tamanho = Integer.parseInt(linha) / 2;
			
//			for (int i = 0; i < Math.round(Math.pow(10, tamanho)); i++) {
//				for (int j = 0; j < Math.round(Math.pow(10, tamanho)); j++) {
//					String t1 = formata(i, tamanho);
//					String t2 = formata(j, tamanho);
//
//					int result = Integer.parseInt(t1 + t2);
//					if (Math.round(Math.pow(i + j, 2)) == result) {
//						System.out.println(t1 + t2);
//					}
//					
//				}
//			}
			switch (tamanho) {
				case 1:
					System.out.println("00");
					System.out.println("01");
					System.out.println("81");
					break;
				case 2:
					System.out.println("0000");
					System.out.println("0001");
					System.out.println("2025");
					System.out.println("3025");
					System.out.println("9801");
					break;
				case 3:
					System.out.println("000000");
					System.out.println("000001");
					System.out.println("088209");
					System.out.println("494209");
					System.out.println("998001");
					break;
				case 4:
					System.out.println("00000000");
					System.out.println("00000001");
					System.out.println("04941729");
					System.out.println("07441984");
					System.out.println("24502500");
					System.out.println("25502500");
					System.out.println("52881984");
					System.out.println("60481729");
					System.out.println("99980001");
			}
			
			linha = readLn(2);
		}
	}
	
	static String formata(int numero, int tamanho) {
		String resultado = String.valueOf(numero);
		int tamNumero = resultado.length();
		
		for (int i = 0; i < tamanho - tamNumero; i++) {
			resultado = "0" + resultado;
		}
		
		return resultado;
	}
}
