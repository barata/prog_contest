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
		String line1 = readLn();
		
		while (line1 != null) {
			String line2 = readLn();
			
			Vector v1 = new Vector();
			Vector v2 = new Vector();
			
			StringTokenizer tks1 = new StringTokenizer(line1);
			StringTokenizer tks2 = new StringTokenizer(line2);
			
			
			while (tks1.hasMoreTokens()) {
				v1.addElement(tks1.nextToken());
			}
			
			while (tks2.hasMoreTokens()) {
				v2.addElement(tks2.nextToken());
			}
			
			int count = countIntersection(v1, v2);
			
			if (count == v1.size() && count == v2.size()) System.out.println("A equals B");
			else if (count == v1.size()) System.out.println("A is a proper subset of B");
			else if (count == v2.size()) System.out.println("B is a proper subset of A");
			else if (count == 0) System.out.println("A and B are disjoint");
			else System.out.println("I'm confused!");
			
			
			
			
			
			line1 = readLn();
		}
	}

	static int countIntersection(Vector v1, Vector v2) {
		int count = 0;
		
		for (int i = 0; i < v1.size(); i++) {
			String e1 = (String) v1.elementAt(i);
			for (int j = 0; j < v2.size(); j++) {
				String e2 = (String) v2.elementAt(j);
				
				if (e1.equals(e2)) count++;
			}
		}
		
		return count;
	}
}
