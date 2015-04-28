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
		int nTests = Integer.parseInt(readLn());
		
		for (int g = 0; g < nTests; g++) {
			StringTokenizer tks = new StringTokenizer(readLn());
			int collumns = Integer.parseInt(tks.nextToken());
			int rows = Integer.parseInt(tks.nextToken());
			
			String[][] spreadsheet = new String[rows][collumns];
			
			for (int i = 0; i < rows; i++) {
				String line = readLn();
				tks = new StringTokenizer(line);
				
				for (int j = 0; j < collumns; j++) {
					spreadsheet[i][j] = tks.nextToken();
				}
			}
			
			
			process(spreadsheet);
			
			
			
			
			// print spreadsheet
			for (int i = 0; i < spreadsheet.length; i++) {
				for (int j = 0; j < spreadsheet[i].length; j++) {
					System.out.print(spreadsheet[i][j]);
					if (j < spreadsheet[i].length - 1) System.out.print(" ");
				}
				System.out.println();
			}
		}
	}

	static void process(String[][] spreadsheet) {
		for (int i = 0; i < spreadsheet.length; i++) {
			for (int j = 0; j < spreadsheet[i].length; j++) {
				spreadsheet[i][j] = getValue(spreadsheet, i, j);
			}
		}
	}

	static String getValue(String[][] spreadsheet, int i, int j) {
		if (spreadsheet[i][j].startsWith("=")) {
			int result = 0;
			StringTokenizer tks = new StringTokenizer(spreadsheet[i][j].substring(1), "+");
			
			while (tks.hasMoreTokens()) {
				String token = tks.nextToken();
				int collumn = getCollumn(token);
				int row = getRow(token);
				
				result += Integer.parseInt(getValue(spreadsheet, row - 1, collumn - 1));
			}
			
			return String.valueOf(result);
		} else {
			return spreadsheet[i][j];
		}
	}
	
	static int index(String value) {
		for (int i = 0; i < value.length(); i++) {
			if (Character.isDigit(value.charAt(i))) return i;
		}
		return -1;
	}
	
	static int getCollumn(String value) {
		int result = 0;
		int index = index(value);
		String collumn = value.substring(0, index);
		
		for (int i = collumn.length() - 1; i >=0; i--) {
			int aux = collumn.charAt(i) - 'A' + 1;
			result += aux * Math.pow(26, collumn.length() - i - 1);
		}
		
		return result;
	}
	
	static int getRow(String value) {
		int index = index(value);
		
		return Integer.parseInt(value.substring(index));
	}
}
