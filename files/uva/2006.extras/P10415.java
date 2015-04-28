
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
	
	static boolean[][] tabela = new boolean[256][];
	
	static {
		boolean[] aux1 = { false, true, true, true, false, false, true, true, true, true }; tabela['c'] = aux1;
		boolean[] aux2 = { false, true, true, true, false, false, true, true, true, false }; tabela['d'] = aux2;
		boolean[] aux3 = { false, true, true, true, false, false, true, true, false, false }; tabela['e'] = aux3;
		boolean[] aux4 = { false, true, true, true, false, false, true, false, false, false }; tabela['f'] = aux4;
		boolean[] aux5 = { false, true, true, true, false, false, false, false, false, false }; tabela['g'] = aux5;
		boolean[] aux6 = { false, true, true, false, false, false, false, false, false, false }; tabela['a'] = aux6;
		boolean[] aux7 = { false, true, false, false, false, false, false, false, false, false }; tabela['b'] = aux7;
		
		boolean[] aux8 = { false, false, true, false, false, false, false, false, false, false }; tabela['C'] = aux8;
		boolean[] aux9 = { true, true, true, true, false, false, true, true, true, false }; tabela['D'] = aux9;
		boolean[] aux10 = { true, true, true, true, false, false, true, true, false, false }; tabela['E'] = aux10;
		boolean[] aux11 = { true, true, true, true, false, false, true, false, false, false }; tabela['F'] = aux11;
		boolean[] aux12 = { true, true, true, true, false, false, false, false, false, false }; tabela['G'] = aux12;
		boolean[] aux13 = { true, true, true, false, false, false, false, false, false, false }; tabela['A'] = aux13;
		boolean[] aux14 = { true, true, false, false, false, false, false, false, false, false }; tabela['B'] = aux14;
	}

	public static void main(String[] args) {
		String line = readLn();
		int t = Integer.parseInt(line);
		
		for (int g = 0; g < t; g++) {
			line = readLn();
			
			int[] cont = new int[10];
			boolean[] dedos = new boolean[10];
			
			for (int i = 0; i < line.length(); i++) {
				char ch = line.charAt(i);
				
				for (int j = 0; j < tabela[ch].length; j++) {
					if (tabela[ch][j] && !dedos[j]) cont[j]++;
					dedos[j] = tabela[ch][j];
				}
			}
			
			for (int i = 0; i < cont.length; i++) {
				System.out.print(cont[i]);
				if (i < cont.length - 1) System.out.print(" ");
			}
			System.out.println();
		}
	}

}
