import java.io.IOException;

class Main {

	public static void main(String[] args) {
		
			String linha = readLn(255);
			while( linha != null && !linha.equals("0") ) {
				
				if(linha.indexOf("0") >= 0) System.out.println("NOT ACCEPTABLE");
				else {
					String result = process(linha);
					if(result.indexOf("0") >= 0) System.out.println("NOT ACCEPTABLE");
					else System.out.println(result);
				}
				
				linha = readLn(255);
			}
	}
	
	
	/**
	 * @param linha
	 */
	private static String process(String num) {
		
		if(num.startsWith("3")) {
			String num2 = num.substring(1, num.length());
			String result = process(num2);
			return result + "2" + result;
		} else if(num.startsWith("2") && num.length() >=2){
			String num2=num.substring(1, num.length());
			return num2;
		} else {
			return "0";
		}
		
		
	}


	static String readLn (int maxLg)   {
        byte lin[] = new byte [maxLg];
        int lg = 0, car = -1;
        String line = "";
        try {
            while (lg < maxLg) {
                car = System.in.read();
                if ((car < 0) || (car == '\n')) break;
                lin [lg++] += car;
        }}
        catch (IOException e) { return (null); }
        if ((car < 0) && (lg == 0)) return (null);  // eof
        return (new String (lin, 0, lg)).trim();
    }
}
