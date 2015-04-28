import java.io.IOException;
import java.util.Hashtable;

class Main {

	static Hashtable dic1;
	static Hashtable dic2;
	
	public static void main(String[] args) {
		montaDic();
		String entrada = readLn(255);
		while( entrada != null && !entrada.equals("") ) {
			
			boolean shiftDown = true;
			
			StringBuffer resposta = new StringBuffer();
			for(int i = 0; i < entrada.length(); i+=5) {
				String bits = entrada.substring(i,i+5);
				if(bits.equals("11011")) {
					shiftDown = true;
				} else if(bits.equals("11111")) {
					shiftDown = false;
				} else {
					if(shiftDown) {
						resposta.append( (String)dic1.get(bits) );
					} else {
						resposta.append( (String)dic2.get(bits) );
					}
				}
			}
			
			System.out.println(resposta.toString());
			
			entrada = readLn(255);
		}
	}
	

	private static void montaDic() {
		dic1 = new Hashtable();
		dic2 = new Hashtable();
		String linha1 = readLn(255);
		String linha2 = readLn(255);
		for(int i = 0 ; i <= 30; i++ ) {
			if( i != 27 ) {
				dic1.put(format(Integer.toBinaryString(i)), String.valueOf(linha1.charAt(i)));
				dic2.put(format(Integer.toBinaryString(i)), String.valueOf(linha2.charAt(i)));
			}
		}
	}
	
	private static String format(String bin) {
		if(bin.length() == 1)
			return "0000".concat(bin);
		else if(bin.length() == 2)
			return "000".concat(bin);
		else if(bin.length() == 3)
			return "00".concat(bin);
		else if(bin.length() == 4)
			return "0".concat(bin);
		return bin;
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
