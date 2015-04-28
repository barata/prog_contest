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
		String line = readLn();
		
		int[] plane = new int[10000];
		int size = 0;
		
		while (line != null) {
			StringTokenizer tks = new StringTokenizer(line);
			
			int l = Integer.parseInt(tks.nextToken());
			int h = Integer.parseInt(tks.nextToken());
			int r = Integer.parseInt(tks.nextToken());
			
			size = Math.max(size, r);
			
			update(plane, l, h, r);
			
			
			
			
			line = readLn();
		}
		
		print(plane, size);
	}
	
	static void update(int[] plane, int l, int h, int r) {
		for (int i = l; i < r; i++) {
			plane[i] = Math.max(plane[i], h);
		}
	}
	
	static void print(int[] plane, int size) {
		StringBuffer sb = new StringBuffer();
		
		int currentValue = plane[1];
		sb.append("1 ").append(currentValue).append(" ");
		
		for (int i = 2; i <= size; i++) {
			if (plane[i] != currentValue) {
				currentValue = plane[i];
				sb.append(i).append(" ").append(currentValue).append(" ");
			}
		}
		System.out.println(sb.toString().trim());
	}

}
