
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
	
	static String[] ram = new String[1000];
	static int ramSize;
	static int ops;
	static int[] reg;
	
	public static void main(String[] args) {
		int nTestes = Integer.parseInt(readLn());
		
		readLn();
		
		for (int g = 0; g < nTestes; g++) {
			initRam();
			
			String line = readLn();
			ramSize = 0;
			
			while (line != null && !"".equals(line)) {
				ram[ramSize++] = line;
				
				line = readLn();
			}
			
			ops = 0;
			reg = new int[10];

			process();

			System.out.println(ops);
			if (g < nTestes - 1) System.out.println();
			
		}
	}
	
	static void initRam() {
		for (int i = 0; i < ram.length; i++) {
			ram[i] = "000";
		}
	}

	static void process() {
		for (int i = 0; ; i++) {
			String command = ram[i];
			ops++;
			
			int c1 = command.charAt(0) - '0';
			int c2 = command.charAt(1) - '0';
			int c3 = command.charAt(2) - '0';
			
			if (c1 == 1) break;

			if (c1 == 2) m2(c2, c3);
			if (c1 == 3) m3(c2, c3);
			if (c1 == 4) m4(c2, c3);
			if (c1 == 5) m5(c2, c3);
			if (c1 == 6) m6(c2, c3);
			if (c1 == 7) m7(c2, c3);
			if (c1 == 8) m8(c2, c3);
			if (c1 == 9) m9(c2, c3);
			if (c1 == 0) {
				if (m0(c2, c3)) {
					i = reg[c2] - 1;
				}
			}
		}
	}

	static void m2(int d, int n) {
		reg[d] = n;
	}
	
	static void m3(int d, int n) {
		reg[d] = (reg[d] + n) % 1000;
	}
	
	static void m4(int d, int n) {
		reg[d] = (reg[d] * n) % 1000;
	}
	
	static void m5(int d, int s) {
		reg[d] = reg[s];
	}
	
	static void m6(int d, int s) {
		reg[d] = (reg[d] + reg[s]) % 1000;
	}
	
	static void m7(int d, int s) {
		reg[d] = (reg[d] * reg[s]) % 1000;
	}
	
	static void m8(int d, int a) {
		reg[d] = Integer.parseInt(ram[reg[a]]);
	}
	
	static void m9(int s, int a) {
		String fmt = "" + reg[s];
		if (fmt.length() == 1) fmt = "00" + fmt;
		if (fmt.length() == 2) fmt = "0" + fmt;
		ram[reg[a]] = fmt;
	}
	
	static boolean m0(int d, int s) {
		return reg[s] != 0;
	}

}
