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
		
		while (line != null) {
			StringTokenizer tks = new StringTokenizer(line);
			
			String preOrd = tks.nextToken();
			String inOrd = tks.nextToken();
			
			No[] nodes = new No[inOrd.length()];
			
			for (int i = 0; i < nodes.length; i++) {
				nodes[i] = new No(i, inOrd.charAt(i));
			}
			
			No root = getNode(nodes, preOrd.charAt(0));
			
			for (int i = 1; i < preOrd.length(); i++) {
				char value = preOrd.charAt(i);
				No no = getNode(nodes, value);
				addNode(no, root);
			}
			
			System.out.println(getPosOrd(root));
			
			
			
			
			line = readLn();
		}
	}

	static No getNode(No[] nodes, char c) {
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].value == c) return nodes[i];
		}
		return null;
	}

	static void addNode(No node, No root) {
		if (node.indice < root.indice) {
			if (root.esq == null) {
				root.esq = node;
			} else {
				addNode(node, root.esq);
			}
		} else {
			if (root.dir == null) {
				root.dir = node;
			} else {
				addNode(node, root.dir);
			}
		}
	}

	static String getPosOrd(No root) {
		if (root != null) {
			return getPosOrd(root.esq) + getPosOrd(root.dir) + root;
		}
		return "";
	}

}

class No {
	public int indice;
	public char value;
	public No esq;
	public No dir;
	
	public No(int indice, char ch) {
		this.indice = indice;
		this.value = ch;
		this.esq = null;
		this.dir = null;
	}
	
	public String toString() {
		return String.valueOf(this.value);
	}
}