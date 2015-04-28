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
	
	private static int[] count;
	
	public static void main(String[] args) {
		String line = readLn();
		StringTokenizer tks = new StringTokenizer(line);
		
		int b = Integer.parseInt(tks.nextToken());
		int w = Integer.parseInt(tks.nextToken());
		
		while (b != 0 || w != 0) {
			int[][] array = new int[b + 2][w + 2];
			
			for (int i = 0; i < array.length; i++) {
				array[i][0] = -1;
				array[i][array[i].length - 1] = -1;
			}
			
			for (int j = 0; j < array[0].length; j++) {
				array[0][j] = -1;
				array[array.length - 1][j] = -1;
			}
			
			for (int i = 1; i <= b; i++) {
				line = readLn();
				for (int j = 1; j <= w; j++) {
					int aux = Character.getNumericValue(line.charAt(j - 1));
					array[i][j] = -aux;
				}
			}
			
			process(array);
			
			count = new int[5];
			countArray(array);
			for (int i = 0; i < count.length; i++) {
				System.out.print(formata(String.valueOf(count[i]), 3));
			}
			System.out.println();
			
			line = readLn();
			tks = new StringTokenizer(line);
			
			b = Integer.parseInt(tks.nextToken());
			w = Integer.parseInt(tks.nextToken());
		}
	}
	
	static int getDeltaLine(int angle) {
		return (int) Math.round(Math.sin(angle * Math.PI / 180));
	}
	
	static int getDeltaColumn(int angle) {
		return (int) Math.round(Math.cos(angle * Math.PI / 180));
	}

	static void process(int[][] array) {
		int iniLine = array.length - 2;
		int iniColumn = 1;
		
		if (array[iniLine][iniColumn] != 0) throw new RuntimeException();
		
		int curLine = iniLine;
		int curColumn = iniColumn;
		
		int angle = 0;
		
		do {
			if (canTurn(array, curLine, curColumn, angle + 90)) angle = (angle + 90) % 360;
			else if (canTurn(array, curLine, curColumn, angle));
			else if (canTurn(array, curLine, curColumn, angle - 90)) angle = (angle - 90 + 360) % 360;
			else if (canTurn(array, curLine, curColumn, angle - 180)) angle = (angle - 180 + 360) % 360;
			
			array[curLine][curColumn]++;
			
			curLine += getDeltaLine(angle);
			curColumn += getDeltaColumn(angle);
			
		} while (curLine != iniLine || curColumn != iniColumn);
	}
	
	static boolean canTurn(int[][] array, int curLine, int curColumn, int angle) {
		int dLine = getDeltaLine(angle);
		int dColumn = getDeltaColumn(angle);
		return array[curLine + dLine][curColumn + dColumn] != -1;
	}

	private static void countArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				int aux = array[i][j];
				if (aux != -1) {
					count[aux]++;
				}
			}
		}
	}
	
	static String formata(String text, int size) {
		return str(" ", size - text.length()) + text;
	}
	
	static String str(String ch, int n) {
		StringBuffer resultado = new StringBuffer();
		for (int i = 0; i < n; i++) {
			resultado.append(ch);
		}
		return resultado.toString();
	}
	
}