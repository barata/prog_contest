import java.io.IOException;
import java.util.StringTokenizer;

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
		String linha;
		StringTokenizer tks;
		
		linha = readLn(255);
		
		while (linha != null && !linha.equals("")) {
			tks = new StringTokenizer(linha);
			
			int n1 = Integer.parseInt(tks.nextToken());
			int n2 = Integer.parseInt(tks.nextToken());


			System.out.println(n1 ^ n2);
			
			
			
			
			linha = readLn(255);
		}
	}

}
