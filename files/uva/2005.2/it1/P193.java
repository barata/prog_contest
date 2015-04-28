import java.util.Enumeration;
import java.util.Hashtable;
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
	
	static int max;
	static String answer;

	public static void main(String[] args) {
		int m = Integer.parseInt(readLn());
		
		for (int g = 0; g < m; g++) {
			StringTokenizer tks = new StringTokenizer(readLn());
			
			int n = Integer.parseInt(tks.nextToken());
			int k = Integer.parseInt(tks.nextToken());
			
			Node[] nodes = getNodes(n);
			
			for (int i = 0; i < k; i++) {
				tks = new StringTokenizer(readLn());
				
				Node node1 = nodes[Integer.parseInt(tks.nextToken())];
				Node node2 = nodes[Integer.parseInt(tks.nextToken())];
				
				if (!node1.adj.contains(node2)) node1.adj.addElement(node2);
				if (!node2.adj.contains(node1)) node2.adj.addElement(node1);
			}
			
			Hashtable blacks = new Hashtable();
			max = 0;
			answer = "";
			coloring(nodes, 1, blacks);
			System.out.println(max);
			System.out.println(answer);
		}
	}

	static void coloring(Node[] nodes, int index, Hashtable blacks) {
		if (index == nodes.length) {
			if (blacks.size() > max) {
				max = blacks.size();
				answer = makeString(blacks);
			}
		} else {
			if (nodes[index].canBeBlack(blacks)) {
				blacks.put(nodes[index], "");
				coloring(nodes, index + 1, blacks);
			}
			blacks.remove(nodes[index]);
			coloring(nodes, index + 1, blacks);
		}
	}
	
	static String makeString(Hashtable blacks) {
		StringBuffer sb = new StringBuffer();
		Enumeration e = blacks.keys();
		while (e.hasMoreElements()) {
			sb.append(e.nextElement());
			if (e.hasMoreElements()) sb.append(" ");
		}
		return sb.toString();
	}

	static Node[] getNodes(int n) {
		Node[] result = new Node[n + 1];
		
		for (int i = 1; i < result.length; i++) {
			result[i] = new Node(i);
		}
		
		return result;
	}

}
class Node {
	public int value;
	public Vector adj;

	public Node(int value) {
		this.value = value;
		this.adj = new Vector();
	}
	
	public boolean canBeBlack(Hashtable blacks) {
		for (int i = 0; i < this.adj.size(); i++) {
			Node aux = (Node) this.adj.elementAt(i);
			if (blacks.containsKey(aux)) return false;
		}
		return true;
	}
	
	public String toString() {
		return String.valueOf(this.value);
	}
	
}