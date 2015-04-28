import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) {
		try {
		
			while (true) {
				int n = Scanner.getInt();
				
				int[] array = new int[n];
				
				for (int i = 0; i < n; i++) {
					array[i] = Scanner.getInt();
				}
				
				System.out.println("Minimum exchange operations : " + ordena(array));
			}

		} catch (Exception e) {}
	}
	
	static int ordena(int[] array) {
		int cont = 0;
		for (int i = 1; i < array.length; i++) {
			for (int j = array.length - 1; j >= i; j--) {
				if (array[j - 1] > array[j]) {
					int aux = array[j - 1];
					array[j - 1] = array[j];
					array[j] = aux;
					
					cont++;
				}
			}
		}
		return cont;
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