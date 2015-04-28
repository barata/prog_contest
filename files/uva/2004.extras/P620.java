import java.io.IOException;

class Main {

	static String readLn (int maxLg)  // utility function to read from stdin
    {
        byte lin[] = new byte [maxLg];
        int lg = 0, car = -1;
        String line = "";

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
			
			if (linha.equals("A")) {
				System.out.println("SIMPLE");
			} else if (linha.endsWith("AB")) {
				System.out.println("FULLY-GROWN");
			} else if (linha.startsWith("B") && linha.endsWith("A")) {
				System.out.println("MUTAGENIC");
			} else {
				System.out.println("MUTANT");
			}
			
		}
	}
}
