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

	public static void main(String[] args) throws Exception {
		int nTestes = 0;;
		
		int n = Integer.parseInt(readLn());
		
		while (n != 0) {
			int[] array = new int[(int) Math.pow(2, (n + 1)) - 1];
			
			int[] map = new int[n + 1];
			
			
			StringTokenizer st = new StringTokenizer(readLn());
			
			for (int k = 1; k <= n; k++) {
				String token = st.nextToken();
				map[k] = Integer.parseInt(token.substring(1));
			}
			
			String line = readLn();
			int index = array.length - 1;
			for (int k = line.length() - 1; k >= 0; k--) {
				array[index--] = Character.getNumericValue(line.charAt(k));
			}
			
			String resultado = "";
			
			int cases = Integer.parseInt(readLn());
			
			for (int k = 0; k < cases; k++) {
				line = readLn();
				
				int[] variables = new int[n + 1];

				for (int i = 1; i < map.length; i++) {
					variables[i] = Character.getNumericValue(line.charAt(map[i] - 1));
				}

				int indexTree = 1;
				
				for (int i = 1; i <= n; i++) {
					if (variables[i] == 0) {
						indexTree = (indexTree * 2); 
					} else {
						indexTree = (indexTree * 2) + 1;
					}
				}
				
				resultado += array[indexTree-1];
			}
			
			System.out.println("S-Tree #" + (++nTestes) + ":");
			System.out.println(resultado);
			System.out.println();
			
			n = Integer.parseInt(readLn());
		}
	}
}
