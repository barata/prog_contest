import java.io.IOException;

class Main {

	static String readLn (int maxLg)  // utility function to read from stdin
    {
        byte lin[] = new byte [maxLg];
        int lg = 0, car = -1;

        try
        {
            while (lg < maxLg)
            {
                car = System.in.read();
                if ((car < 0) || (car == '\n')) break;
                lin [lg++] += car;
            }
        }
        catch (IOException e)
        {
            return (null);
        }

        if ((car < 0) && (lg == 0)) return (null);  // eof
        return (new String (lin, 0, lg));
    }

	public static void main(String[] args) {
		String linha = readLn(255);
		
		int nTestes = Integer.parseInt(linha);
		
		for (int i = 0; i < nTestes; i++) {
			linha = readLn(255);
			
			if (linha.equals("1") || linha.equals("4") || linha.equals("78")) {
				System.out.println("+");
			} else if (linha.endsWith("35")) {
				System.out.println("-");
			} else if (linha.startsWith("9") && linha.endsWith("4")) {
				System.out.println("*");
			} else if (linha.startsWith("190")) {
				System.out.println("?");
			}
		}
	}

}
