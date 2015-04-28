import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner();
		
		int n = sc.getInt();
		
		while (n != 0) {
			
			Tree tree = new Tree();
			
			for (int i = 0; i < n; i++) {
				String number = sc.getString();
				tree.insert(number);
			}

			System.out.println(tree.inOrder());
			
			n = sc.getInt();
		}
	}
	
}

class Tree {
	
	private Node root;
	private StringBuffer txt;
	
	public Tree() {
		this.root = null;
	}

	public StringBuffer inOrder() {
		this.txt = new StringBuffer();
		if (this.root != null) this.inOrder(this.root);
		return this.txt;
	}
	
	private void inOrder(Node node) {
		if (node == null) return;
		this.inOrder(node.left);
		this.txt.append(node.value);
		this.inOrder(node.right);
	}

	public void insert(String number) {
		if (this.root == null) this.root = new Node(number);
		else insert(this.root, number);
	}
	
	private void insert(Node currentNode, String number) {
		int code = compare(currentNode.value, number);
		
		if (code > 0) { // number + currentNode.value (insert on the left)
			
			if (currentNode.left == null) {
				Node newNode = new Node(number);
				currentNode.left = newNode;
			} else {
				insert(currentNode.left, number);
			}
			
		} else { // currentNode.value + number (insert on the right)
			
			if (currentNode.right == null) {
				Node newNode = new Node(number);
				currentNode.right = newNode;
			} else {
				insert(currentNode.right, number);
			}
			
		}
	}

	private int compare(String s1, String s2) {
		int p1 = 0;
		int p2 = 0;
		
		int digit1 = Character.getNumericValue(s1.charAt(p1));
		int digit2 = Character.getNumericValue(s2.charAt(p2));
		
		while (digit1 == digit2 && (p1 < s1.length() - 1 || p2 < s2.length() - 1)) {
			
			p1 = (p1 + 1) % s1.length();
			p2 = (p2 + 1) % s2.length();
			
			digit1 = Character.getNumericValue(s1.charAt(p1));
			digit2 = Character.getNumericValue(s2.charAt(p2));
		}
		
		return (digit2 - digit1);
	}

}

class Node {
	public String value;
	public Node left;
	public Node right;
	
	public Node(String value) {
		this.value = value;
		this.left = null;
		this.right = null;
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