
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) {
		String linha = Reader.readLn();
		
		int nTestes = Integer.parseInt(linha);
		
		for (int g = 0; g < nTestes; g++) {
			int nAlunos = Scanner.getInt();
			
			int[] notas = new int[nAlunos];
			
			double somaDasNotas = 0;
			
			for (int i = 0; i < nAlunos; i++) {
				notas[i] = Scanner.getInt();
				somaDasNotas += notas[i];
			}
			
			double media = somaDasNotas / nAlunos;
			int alunosAcima = 0;
			
			for (int i = 0; i < nAlunos; i++) {
				if (notas[i] > media) alunosAcima++;
			}
			
			long porcentagem = Math.round(alunosAcima * 100.0 / nAlunos * 1000);

			System.out.println(round(alunosAcima * 100.0 / nAlunos, 3) + "%");
		}
	}
	
	static String round(double valor, int casas) {
		long numero = Math.round(valor * Math.pow(10, casas));
		
		String retorno = "" + (numero / (long) Math.pow(10, casas));
		retorno += ".";
		String resto = "" + (numero % (long) Math.pow(10, casas));
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

class Scanner {

	static StringTokenizer st = null;

	static int getInt() {
		if (st == null)
			st = new StringTokenizer(Reader.readLn());
		while (!st.hasMoreTokens())
			st = new StringTokenizer(Reader.readLn());
		return Integer.parseInt(st.nextToken());
	}

}

class Reader {
	static String readLn() {
		String newLine = System.getProperty("line.separator");
		StringBuffer buffer = new StringBuffer();
		int car = -1;
		try {
			car = System.in.read();
			while ((car > 0) && (car != newLine.charAt(0))) {
				buffer.append((char) car);
				car = System.in.read();
			}
			if (car == newLine.charAt(0))
				System.in.skip(newLine.length() - 1);
		} catch (java.io.IOException e) {
			return (null);
		}
		if ((car < 0) && (buffer.length() == 0))
			return (null);
		return (buffer.toString()).trim();
	}
}