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
	
	static StrLong[] possibilidades = new StrLong[6];
	
	static {
		possibilidades[0] = new StrLong("BCG");
		possibilidades[1] = new StrLong("BGC");
		possibilidades[2] = new StrLong("CBG");
		possibilidades[3] = new StrLong("CGB");
		possibilidades[4] = new StrLong("GBC");
		possibilidades[5] = new StrLong("GCB");
	}
	
	static void resetPossibilidades() {
		for (int i = 0; i < possibilidades.length; i++) {
			possibilidades[i].second = 0;
		}
	}
	
	public static void main(String[] args) {
		String linha = readLn();
		
		while (linha != null) {
			StringTokenizer tks = new StringTokenizer(linha);
			
			Pack[] bins = new Pack[3];
			for (int i = 0; i < 3; i++) {
				long b = Long.parseLong(tks.nextToken());
				long g = Long.parseLong(tks.nextToken());
				long c = Long.parseLong(tks.nextToken());
				
				bins[i] = new Pack(b, g, c);
			}
			
			resetPossibilidades();
			
			for (int i = 0; i < possibilidades.length; i++) {
				
				long custo = 0;
				
				for (int j = 0; j < 3; j++) {
					char ch = possibilidades[i].first.charAt(j);
					
					for (int k = 0; k < 3; k++) {
						if (k != j) {
							if (ch == 'B') custo += bins[k].b;
							else if (ch == 'G') custo += bins[k].g;
							else if (ch == 'C') custo += bins[k].c;
						}
					}
				}
				
				possibilidades[i].second = custo;
			}
			
			
			StrLong resposta = possibilidades[0];
			
			for (int i = 1; i < possibilidades.length; i++) {
				if (possibilidades[i].second < resposta.second) {
					resposta = possibilidades[i];
				}
			}
			
			System.out.println(resposta);
			
			
			
			linha = readLn();
		}
	}

}

class Pack {
	public long b;
	public long g;
	public long c;
	
	public Pack(long b, long g, long c) {
		this.b = b;
		this.g = g;
		this.c = c;
	}
}

class StrLong {
	public String first;
	public long second;
	
	public StrLong(String first) {
		this.first = first;
	}
	
	public String toString() {
		return this.first + " " + this.second;
	}
}