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
		Scanner sc = new Scanner();

		while (!sc.isEOF()) {
			String[] tree = new String[16384];
			boolean discard = false;

			String token = sc.getString();
			
			while (! "()".equals(token) ) {
				StringTokenizer st = new StringTokenizer(token, "(,");
				String value = "";
				String path = "";

				String aux = st.nextToken();
				value = aux;
				aux = st.nextToken();
				path = aux.substring(0, aux.length() - 1);
				
				int pos = 0;
				
				for (int i = 0; i < path.length(); i++) {
					char ch = path.charAt(i);
					if (ch == 'L') pos = 2 * pos + 1;
					if (ch == 'R') pos = 2 * pos + 2;
				}

				if (tree[pos] != null) discard = true;
				else tree[pos] = value;

				
				
				
				token = sc.getString();
			}

			if (!discard && isCompletelySpecified(tree)) {
				imprime(tree);
			} else {
				System.out.println("not complete");
			}
			
		}
	}
	
	static boolean isCompletelySpecified(String[] tree) {
		for (int i = 1; i < tree.length; i++) {
			// does not have parent
			if (tree[i] != null && tree[(i - 1) /2] == null) {
				return false;
			}
		}
		return true;
	}
	
	static void imprime(String[] tree) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < tree.length; i++) {
			if (tree[i] != null) sb.append(" ").append(tree[i]);
		}
		System.out.println(sb.toString().trim());
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