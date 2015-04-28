import java.util.Vector;

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
		int n = Integer.parseInt(readLn());
		
		while (n != 0) {
			Vector deck = getDeck(n);
			StringBuffer sb = new StringBuffer();
			sb.append("Discarded cards:");
			
			while (deck.size() > 1) {
				String card = (String) deck.elementAt(0);
				deck.removeElementAt(0);
				
				sb.append(" ").append(card);
				if (deck.size() > 1) sb.append(",");
				
				card = (String) deck.elementAt(0);
				deck.removeElementAt(0);
				deck.addElement(card);
			}
			
			System.out.println(sb);
			System.out.println("Remaining card: " + deck.elementAt(0));
			
			
			
			
			n = Integer.parseInt(readLn());
		}
	}

	static Vector getDeck(int n) {
		Vector deck = new Vector();
		
		for (int i = 1; i <= n; i++) {
			deck.addElement(String.valueOf(i));
		}
		
		return deck;
	}

}
