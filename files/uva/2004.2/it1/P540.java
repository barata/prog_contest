import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.Vector;

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

	public static void main(String[] args) {
		String linha;
		StringTokenizer tks;
		long nTestes = 0;
		
		linha = readLn(255);
		
		long numeroDeTimes = Long.parseLong(linha);
		
		while (numeroDeTimes != 0) {
			
			TeamQueue queue;
			Hashtable groupByIdMap = new Hashtable();
			Hashtable idsByGroupMap = new Hashtable();

			// montando os hashes
			for (long i = 0; i < numeroDeTimes; i++) {
				linha = readLn(10000);
				tks = new StringTokenizer(linha);
				
				Long group = new Long(i);
				idsByGroupMap.put(group, new Vector());
				
				// preenche um grupo
				long numeroDeIntegrantes = Long.parseLong(tks.nextToken());
				for (long j = 0; j < numeroDeIntegrantes; j++) {
					long valor = Long.parseLong(tks.nextToken());
					Long id = new Long(valor);
					
					groupByIdMap.put(id, group);
					Vector ids = (Vector) idsByGroupMap.get(group);
					ids.addElement(id);
				}
			}

			queue = new TeamQueue(groupByIdMap, idsByGroupMap);
			System.out.println("Scenario #" + (++nTestes));
			
			
			// executa comandos
			linha = readLn(255);
			while (!linha.equalsIgnoreCase("STOP")) {
				tks = new StringTokenizer(linha);
				String comando = tks.nextToken();
				if (comando.equalsIgnoreCase("ENQUEUE")) {
					Long id = new Long(tks.nextToken());
					queue.push(id);
				} else if (comando.equalsIgnoreCase("DEQUEUE")) {
					Object o = queue.pop();
					if (o != null) {
						System.out.println(o);
					}
				}
				
//				System.out.println("! Comando foi: " + linha);
//				queue.imprime();
				
				linha = readLn(255);
			}
			
			System.out.println();
			
			linha = readLn(255);
			numeroDeTimes = Long.parseLong(linha);
		}
	}
}
class TeamQueue {
	
	// id x grupo
	private Hashtable groupByIdMap;
	private Hashtable idsByGroupMap;
	private Hashtable positionByGroupMap;
	private Vector fila;

	public TeamQueue(Hashtable groupByIdMap, Hashtable idsByGroupMap) {
		this.groupByIdMap = groupByIdMap;
		this.idsByGroupMap = idsByGroupMap;
		this.positionByGroupMap = new Hashtable();
		this.fila = new Vector();
	}
	
	public void push(Long id) {
		if (groupByIdMap.containsKey(id)) {
			Vector tempList = temAmigoNaFila(id);
			if (!this.fila.contains(tempList)) tempList = null;
			
			if (tempList == null) { // deve inserir no final da fila
				tempList = new Vector();
				tempList.addElement(id);
				this.fila.addElement(tempList);
			} else {
				if (! tempList.contains(id) ) {
					tempList.addElement(id);
				}
			}
			this.positionByGroupMap.put(this.groupByIdMap.get(id), tempList);
		}
	}
	
	public Long pop() {
		if (! this.fila.isEmpty() ) {
			Vector tempList = (Vector) this.fila.firstElement();
			Long id = (Long) tempList.firstElement();
			Long group = (Long) this.groupByIdMap.get(id);
			tempList.removeElementAt(0);

			if (tempList.isEmpty()) {
				this.fila.removeElementAt(0);
				this.positionByGroupMap.remove(group);
			}
			return id;
		}
		return null;
	}
	
	private Vector temAmigoNaFila(Long id) {
	    Long group = (Long) this.groupByIdMap.get(id);

	    Vector tempList = (Vector) this.positionByGroupMap.get(group);

	    return tempList;
	}

	public void imprime() {
	    Enumeration enum = this.fila.elements();
	    while (enum.hasMoreElements()) {
	        Vector v = (Vector) enum.nextElement();
	        Enumeration enum2 = v.elements();
	        System.out.print(">");
	        while (enum2.hasMoreElements()) {
	            System.out.print(" " + enum2.nextElement());
	        }
	        System.out.println();
	    }
	}

}