import java.util.Hashtable;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner();
		
		int k = sc.getInt();
		
		while (k != 0) {
			int m = sc.getInt();

			Hashtable tabela = new Hashtable();
			
			for (int i = 0; i < k; i++) {
				String aux = sc.getString();
				tabela.put(aux, aux);
			}

			boolean yes = true;
			
			for (int i = 0; i < m; i++) {
				int c = Integer.parseInt(sc.getString());
				int r = Integer.parseInt(sc.getString());
				
				int cont = 0;
				
				for (int j = 0; j < c; j++) {
					if (tabela.get(sc.getString()) != null) cont++;
				}
				
				yes &= cont >= r;
			}
			
			System.out.println(yes ? "yes" : "no");
			
			
			
			
			k = sc.getInt();
		}
	}

}

class Scanner {

    StringTokenizer st = null;
    String next = null;

    Scanner() {
        next = Reader.readLn();
    }

    int getInt() {
        read();
        return Integer.parseInt(st.nextToken());
    }

    double getDouble() {
        read();
        return new Double(st.nextToken()).doubleValue();
    }

    String getString() {
        read();
        return st.nextToken();
    }

    boolean isEOF() {
        return (st == null && next == null) || (st != null && !st.hasMoreTokens() && next == null);
    }

    private void read() {
        if(st == null) {
                st = new StringTokenizer(next);
                next = Reader.readLn();
        }

        while(! st.hasMoreTokens()) {
                st = new StringTokenizer(next);
                next = Reader.readLn();
        }
    }

}

class Reader {
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
}