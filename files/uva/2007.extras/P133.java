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
		StringTokenizer tks = new StringTokenizer(readLn());
		
		int n = Integer.parseInt(tks.nextToken());
		int k = Integer.parseInt(tks.nextToken());
		int m = Integer.parseInt(tks.nextToken());
		
		
		while (n != 0 || k != 0 || m != 0) {
			
			Vector list = new Vector(n);
			for (int i = 1; i <= n; i++) {
				list.addElement(Integer.toString(i));
			}
			
			StringBuffer sb = new StringBuffer();
			
			int counterClockwise = -1;
			int clockwise = list.size();
			
			while (true) {

				counterClockwise = (counterClockwise + k) % list.size();
				clockwise = (clockwise - (m%list.size()) + list.size()) % list.size();

				if (counterClockwise == clockwise) {
					if (sb.length() != 0) sb.append(",");
					sb.append(rjust(list.elementAt(counterClockwise).toString(), 3));
					list.removeElementAt(counterClockwise);
					
					if (list.isEmpty()) break;
					
					counterClockwise = (counterClockwise - 1 + list.size()) % list.size();
				} else {
					if (sb.length() != 0) sb.append(",");
					sb.append(rjust(list.elementAt(counterClockwise).toString(), 3) + rjust(list.elementAt(clockwise).toString(), 3));
					list.removeElementAt(Math.max(counterClockwise, clockwise));
					list.removeElementAt(Math.min(counterClockwise, clockwise));
					
					if (list.isEmpty()) break;
					
					if (counterClockwise < clockwise) {
						counterClockwise = (counterClockwise - 1 + list.size()) % list.size();
						clockwise--;
					} else {
						counterClockwise = (counterClockwise - (2%list.size()) + list.size()) % list.size();
					}
				}
				
			}
			
			System.out.println(sb);
			
			
			
			
			tks = new StringTokenizer(readLn());
			
			n = Integer.parseInt(tks.nextToken());
			k = Integer.parseInt(tks.nextToken());
			m = Integer.parseInt(tks.nextToken());
		}
	}
	
	static String rjust(String str, int casas) {
	    return str(' ', casas - str.length()) + str;
	}
	
	static String str(char ch, int n) {
	    String resultado = "";
	    for (int i = 0; i < n; i++) {
	        resultado += ch;
	    }
	    return resultado;
	}
	
}
