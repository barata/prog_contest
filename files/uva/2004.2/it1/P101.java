import java.io.IOException;
import java.util.StringTokenizer;

class Main {

	static String readLn(int maxLg) { // utility function to read from stdin
		byte lin[] = new byte[maxLg];
		int lg = 0, car = -1;
		String line = "";

		try {
			while (lg < maxLg) {
				car = System.in.read();
				if ((car < 0) || (car == '\n'))
					break;
				lin[lg++] += car;
			}
		} catch (IOException e) {
			return (null);
		}

		if ((car < 0) && (lg == 0))
			return (null); // eof
		return (new String(lin, 0, lg)).trim();
	}
	
	static Bloco[] base;
	
	static void init() {
		for (int i = 0; i < base.length; i++) {
			base[i] = new Bloco(-1);
			base[i].next = new Bloco(i);
		}
	}

	public static void main(String[] args) {
		int numeroDeBlocos = Integer.parseInt(readLn(255));
		
		base = new Bloco[numeroDeBlocos];
		
		init();
		
		String linha = readLn(255);
		
		while (linha != null && !linha.equals("quit")) {
			
			StringTokenizer tks = new StringTokenizer(linha);
			
			String comando = tks.nextToken();
			int origem = Integer.parseInt(tks.nextToken());
			String operador = tks.nextToken();
			int destino = Integer.parseInt(tks.nextToken());
			
			if (ehComandoValido(origem, destino)) {
			
				if (comando.equals("move")) {
					
					if (operador.equals("onto")) {
						
						moveOnto(origem, destino);
						
					} else if (operador.equals("over")) {
						
						moveOver(origem, destino);
						
					}

				} else if (comando.equals("pile")) {
					
					if (operador.equals("onto")) {
						
						pileOnto(origem, destino);
						
					} else if (operador.equals("over")) {
						
						pileOver(origem, destino);
						
					}
					
				}
				
			}
//			imprime();
			
			linha = readLn(255);
		}
		
		imprime();
	}
	
	static void moveOnto(int origem, int destino) {
		Bloco baseOrigem = base[getBase(origem)];
		Bloco blocoOrigem = getBloco(origem);
		devolveBlocos(blocoOrigem.next);
		removeBloco(baseOrigem, blocoOrigem);
		
		Bloco blocoDestino = getBloco(destino);
		if (blocoDestino.next != null) {
			devolveBlocos(blocoDestino.next);
			blocoOrigem.next = blocoDestino.next;
		}
		blocoDestino.next = blocoOrigem;
	}

	static void moveOver(int origem, int destino) {
		Bloco baseOrigem = base[getBase(origem)];
		Bloco blocoOrigem = getBloco(origem);
		devolveBlocos(blocoOrigem.next);
		removeBloco(baseOrigem, blocoOrigem);
		
		Bloco blocoDestino = getBloco(destino);
		Bloco topo = getLast(blocoDestino);
		topo.next = blocoOrigem;
	}
	
	static void pileOnto(int origem, int destino) {
		Bloco baseOrigem = base[getBase(origem)];
		Bloco blocoOrigem = getBloco(origem);
		Bloco aux = baseOrigem;
		while (! aux.next.equals(blocoOrigem) ) {
			aux = aux.next;
		}
		if (aux != null) {
			aux.next = null;
		}
		
		Bloco baseDestino = base[getBase(destino)];
		Bloco blocoDestino = getBloco(destino);
		if (blocoDestino.next != null) {
			devolveBlocos(blocoDestino.next);
			Bloco topo = getLast(blocoOrigem);
			topo.next = blocoDestino.next;
		}
		blocoDestino.next = blocoOrigem;
	}
	
	static void pileOver(int origem, int destino) {
		Bloco baseOrigem = base[getBase(origem)];
		Bloco blocoOrigem = getBloco(origem);
		Bloco aux = baseOrigem;
		while (! aux.next.equals(blocoOrigem) ) {
			aux = aux.next;
		}
		if (aux != null) aux.next = null;
		
		Bloco blocoDestino = getBloco(destino);
		Bloco topo = getLast(blocoDestino);
		topo.next = blocoOrigem;
	}
	
	static boolean ehComandoValido(int origem, int destino) {
		if (origem == destino) return false;
		
		int baseOrigem = getBase(origem);
		int baseDestino = getBase(destino);
		
		if (baseOrigem == -1 || baseDestino == -1) return false;
		return baseOrigem != baseDestino;
	}
	
	static void devolveBlocos(Bloco inicio) {
		Bloco aux = inicio;
		while (aux != null) {
			Bloco aux2 = aux.next;
			removeBloco(base[getBase(aux.numero)], aux);
			getLast(base[aux.numero]).next = aux;
			
			aux = aux2;
		}
	}
	
	static Bloco getLast(Bloco bloco) {
		if (bloco == null || bloco.next == null) return bloco;
		return getLast(bloco.next);
	}
	
	static void removeBloco(Bloco inicio, Bloco bloco) {
		if (inicio.next != null && !inicio.next.equals(bloco)) {
			removeBloco(inicio.next, bloco);
		} else {
			inicio.next = bloco.next;
			bloco.next = null;
		}
	}
	
	static int getBase(int numero) {
		for (int i = 0; i < base.length; i++) {
			Bloco temp = buscaEmLista(base[i], numero);
			
			if (temp != null) return i;
		}
		return -1;
	}
	
	static Bloco getBloco(int numero) {
		for (int i = 0; i < base.length; i++) {
			Bloco temp = buscaEmLista(base[i], numero);
			
			if (temp != null) return temp;
		}
		return null;
	}
	
	static Bloco buscaEmLista(Bloco inicio, int numero) {
		if (inicio == null || inicio.numero == numero) return inicio;
		
		return buscaEmLista(inicio.next, numero);
	}
	
	static void imprime() {
		for (int i = 0; i < base.length; i++) {
			System.out.print(i + ":");
			Bloco aux = base[i].next;
			while (aux != null) {
				System.out.print(" " + aux);
				aux = aux.next;
			}
			System.out.println();
		}
	}
}

class Bloco {
	
	public int numero;
	
	public Bloco next;
	
	public Bloco(int numero) {
		this.numero = numero;
	}
	
	public boolean equals(Object o) {
		if (!(o instanceof Bloco)) return false;
		
		Bloco aux = (Bloco) o;
		return aux.numero == this.numero;
	}
	
	public String toString() {
		return "" + this.numero;
	}
	
}