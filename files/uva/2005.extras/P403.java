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
	
	static final int PAGE_SIZE = 60;
	
	static final int CHAR_HEIGHT = 5;
	
	static final int CHAR_WIDTH = 6;
	
	static char[][][] chars = new char[256][CHAR_HEIGHT][CHAR_WIDTH];
	
	static {
		loadChar("..............................", chars[' ']);
		
		loadChar(".***..*...*.*****.*...*.*...*.", chars['A']);
		loadChar("****..*...*.****..*...*.****..", chars['B']);
		loadChar(".****.*...*.*.....*......****.", chars['C']);
		loadChar("****..*...*.*...*.*...*.****..", chars['D']);
		loadChar("*****.*.....***...*.....*****.", chars['E']);
		loadChar("*****.*.....***...*.....*.....", chars['F']);
		loadChar(".****.*.....*..**.*...*..***..", chars['G']);
		loadChar("*...*.*...*.*****.*...*.*...*.", chars['H']);
		loadChar("*****...*.....*.....*...*****.", chars['I']);
		loadChar("..***....*.....*..*..*...**...", chars['J']);
		loadChar("*...*.*..*..***...*..*..*...*.", chars['K']);
		loadChar("*.....*.....*.....*.....*****.", chars['L']);
		loadChar("*...*.**.**.*.*.*.*...*.*...*.", chars['M']);
		loadChar("*...*.**..*.*.*.*.*..**.*...*.", chars['N']);
		loadChar(".***..*...*.*...*.*...*..***..", chars['O']);
		loadChar("****..*...*.****..*.....*.....", chars['P']);
		loadChar(".***..*...*.*...*.*..**..****.", chars['Q']);
		loadChar("****..*...*.****..*..*..*...*.", chars['R']);
		loadChar(".****.*......***......*.****..", chars['S']);
		loadChar("*****.*.*.*...*.....*....***..", chars['T']);
		loadChar("*...*.*...*.*...*.*...*..***..", chars['U']);
		loadChar("*...*.*...*..*.*...*.*....*...", chars['V']);
		loadChar("*...*.*...*.*.*.*.**.**.*...*.", chars['W']);
		loadChar("*...*..*.*....*....*.*..*...*.", chars['X']);
		loadChar("*...*..*.*....*.....*.....*...", chars['Y']);
		loadChar("*****....*....*....*....*****.", chars['Z']);
	}
	
	public static void main(String[] args) {
		String line = readLn();
		
		char[][] page = getPage();
		
		while (line != null) {
			if (".EOP".equals(line)) {
				showPage(page);
				page = getPage();
			} else {
				StringTokenizer tks = new StringTokenizer(line, "|");
				String params = tks.nextToken();
				String text = tks.nextToken();
				
				tks = new StringTokenizer(params);
				String command = tks.nextToken();
				String type = tks.nextToken();
				int row = Integer.parseInt(tks.nextToken());
				int column;
				
				if (".P".equals(command)) {
					column = Integer.parseInt(tks.nextToken());
					
					if ("C1".equals(type)) {
						printC1(page, text, row, column);
					} else if ("C5".equals(type)) {
						printC5(page, text, row, column);
					}
					
				} else if (".L".equals(command)) {
					column = 1;
					
					if ("C1".equals(type)) {
						printC1(page, text, row, column);
					} else if ("C5".equals(type)) {
						printC5(page, text, row, column);
					}
					
				} else if (".R".equals(command)) {
					
					if ("C1".equals(type)) {
						column = 60 - text.length() + 1;
						printC1(page, text, row, column);
					} else if ("C5".equals(type)) {
						column = 60 - 6 * text.length() + 1;
						printC5(page, text, row, column);
					}
					
				} else if (".C".equals(command)) {
					
					if ("C1".equals(type)) {
						column = (60 - text.length()) / 2 + 1;
						if (text.length() % 2 != 0) column++;
						printC1(page, text, row, column);
					} else if ("C5".equals(type)) {
						column = (60 - text.length() * 6) / 2 + 1;
						printC5(page, text, row, column);
					}
					
				}
			}
			
			
			
			line = readLn();
		}
		
	}
	
	static void loadChar(String data, char[][] ch) {
		for (int i = 0; i < CHAR_HEIGHT; i++) {
			for (int j = 0; j < CHAR_WIDTH; j++) {
				ch[i][j] = data.charAt(i * CHAR_WIDTH + j);
			}
		}
	}
	
	static void printChar(char[][] page, char[][] ch, int row, int column) {
		for (int i = 0; i < ch.length; i++) {
			if (row + i < 1 || row + i >= page.length) continue;
			
			for (int j = 0; j < ch[i].length; j++) {
				if (column + j < 1 || column + j >= page[i].length) continue;
				
				if (ch[i][j] == '*') {
					page[row + i][column + j] = '*';
				}
			}
		}
	}

	static void printC1(char[][] page, String text, int row, int column) {
		for (int i = 0; i < text.length(); i++) {
			if (column + i < 1 || column + i >= page[row].length) continue;
			if (text.charAt(i) == ' ') continue;
			page[row][column + i] = text.charAt(i);
		}
	}
	
	static void printC5(char[][] page, String text, int row, int column) {
		for (int i = 0; i < text.length(); i++) {
			printChar(page, chars[text.charAt(i)], row, column + i * 6);
		}
	}
	
	static void showPage(char[][] page) {
		for (int i = 1; i < page.length; i++) {
			for (int j = 1; j < page[i].length; j++) {
				System.out.print(page[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("\n------------------------------------------------------------\n");
	}
	
	static char[][] getPage() {
		char[][] page = new char[PAGE_SIZE + 1][PAGE_SIZE + 1];
		
		for (int i = 0; i < page.length; i++) {
			for (int j = 0; j < page[i].length; j++) {
				page[i][j] = '.';
			}
		}
		
		return page;
	}

}
