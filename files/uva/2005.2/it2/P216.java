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
	
	static int n;
	static double min;
	static StringBuffer resposta;

	public static void main(String[] args) {
		int nTeste = 0;
		n = Integer.parseInt(readLn());
		
		while (n != 0) {
			
			Vector nodes = new Vector(n);
			
			for (int i = 0; i < n; i++) {
				StringTokenizer tks = new StringTokenizer(readLn());
				
				int x = Integer.parseInt(tks.nextToken());
				int y = Integer.parseInt(tks.nextToken());
				
				nodes.addElement(new Node(x, y));
			}
			
			min = Double.MAX_VALUE;
			backtracking(nodes, new Vector(n), 0);
			System.out.println("**********************************************************");
			System.out.println("Network #" + (++nTeste));
			System.out.println(resposta);
			
			n = Integer.parseInt(readLn());
		}
	}

	static void backtracking(Vector nodes, Vector solucao, double soma) {
		if (solucao.size() == n) {
			if (soma < min) {
				min = soma;
				resposta = new StringBuffer();
				for (int i = 1; i < solucao.size(); i++) {
					Node n1 = (Node) solucao.elementAt(i - 1);
					Node n2 = (Node) solucao.elementAt(i);
					resposta.append("Cable requirement to connect "+n1+" to "+n2+" is "+round(n1.distancia(n2) + 16, 2)+" feet.\n");
				}
				resposta.append("Number of feet of cable required is "+round(soma, 2)+".");
			}
		} else {
			for (int i = 0; i < nodes.size(); i++) {
				Node node = (Node) nodes.elementAt(i);
				nodes.removeElementAt(i);
				double dist = 0;
				if (!solucao.isEmpty()) {
					dist = node.distancia((Node) solucao.elementAt(solucao.size() - 1)) + 16;
				}
				solucao.addElement(node);
				backtracking(nodes, solucao, dist + soma);
				
				nodes.insertElementAt(node, i);
				solucao.removeElementAt(solucao.size() - 1);
			}
		}
	}
	
	static String round(double valor, int casas) {
		long numero = Math.round(valor * Math.pow(10, casas));
		
		String retorno;
		if (numero < 0) retorno = "-";
		else retorno = "";
		retorno += (Math.abs(numero) / (long) Math.pow(10, casas));
		retorno += ".";
		String resto = "" + (Math.abs(numero) % (long) Math.pow(10, casas));
		resto = str('0', casas - resto.length()) + resto;
		retorno += resto;
		
		return retorno;
	}
	
	static String str(char ch, int k) {
		String resultado = "";
		for (int i = 0; i < k; i++) {
			resultado += ch;
		}
		return resultado;
	}
	
}
class Node {

	public int x;
	public int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public double distancia(Node o) {
		int dX = this.x - o.x;
		int dY = this.y - o.y;
		return Math.sqrt(dX * dX + dY * dY);
	}
	
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
}