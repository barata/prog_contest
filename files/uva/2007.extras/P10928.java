import java.util.Enumeration;
import java.util.StringTokenizer;
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
		int nTestes = Integer.parseInt(readLn());
		
		for (int g = 0; g < nTestes; g++) {
			int p = Integer.parseInt(readLn());
			
			Vector result = null;
			int min = Integer.MAX_VALUE;
			
			for (int i = 1; i <= p; i++) {
				int count = new StringTokenizer(readLn()).countTokens();
				
				if (count == min) {
					result.addElement(new Integer(i));
				} else if (count < min) {
					min = count;
					result = new Vector();
					result.addElement(new Integer(i));
				}
			}
			
			Enumeration en = result.elements();
			while (en.hasMoreElements()) {
				System.out.print(en.nextElement());
				if (en.hasMoreElements()) System.out.print(" ");
			}
			System.out.println();
			
			if (g < nTestes - 1) readLn();
		}
	}

}
