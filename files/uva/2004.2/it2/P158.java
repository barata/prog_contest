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

	static final int[] DIAS_MES = { -1, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	static Data dias[];
	
	static {
		dias = new Data[366 + 1];
		int count = 1;
		
		for (int i = 1; i < DIAS_MES.length; i++) {
			for (int j = 1; j <= DIAS_MES[i]; j++) {
				dias[count++] = new Data(j, i);
			}
		}
	}

	public static void main(String[] args) {
		String linha = readLn(300);
		int ano = Integer.parseInt(linha);
		
		Vector eventos = new Vector();
		boolean comecou = false;
		
		linha = readLn(300);
		while (linha != null && !linha.equals("#")) {
			StringTokenizer tks = new StringTokenizer(linha);
			
			String comando = tks.nextToken();
			int dia = Integer.parseInt(tks.nextToken());
			int mes = Integer.parseInt(tks.nextToken());
			Data dataHoje = new Data(dia, mes);
			
			if (comando.equals("A")) {
				
				int prioridade = Integer.parseInt(tks.nextToken());
				String descricao = tks.nextToken("\n");
				
				eventos.addElement(new Evento(dia, mes, prioridade, descricao.trim()));
				
			} else if (comando.equals("D")) {
				
				int qntDias = getNumeroDeDias(dia, mes, ano);
				Hashtable result = new Hashtable();
				for (int i = 1; i <= 12; i++) {
					result.put(new Integer(i), new Vector());
				}

				// filtra os eventos
				for (int i = qntDias; i < qntDias + 8; i++) {
					Data data = getData(i, ano);

					Vector tempEventos = getEventos(eventos, data);
					
					Enumeration enum = tempEventos.elements();
					while (enum.hasMoreElements()) {
						Evento evento = (Evento) enum.nextElement();

						int diasRestantes = getDiasRestantes(dataHoje, data, ano);

						int nStars = evento.prioridade - diasRestantes + 1;

						if (diasRestantes == 0) {
							evento.stars = "*TODAY*";
						} else if (diasRestantes > 0 && diasRestantes <= evento.prioridade) {
							evento.stars = getStr('*', nStars);
						}
						
						if (diasRestantes >= 0 && diasRestantes <= evento.prioridade) {
							Vector v = (Vector) result.get(new Integer(evento.data.mes));
							if (! v.contains(evento) ) v.addElement(evento);
						}

					}

				}
				
				// resultado
				if (comecou)
					System.out.println();
				imprimeResultado(result, dia, mes);
				comecou = true;
			}
			
			
			linha = readLn(300);
		}

	}
	
	static void imprimeResultado(Hashtable eventos, int dia, int mes) {
		Vector lista1 = new Vector();
		Vector lista2 = new Vector();
		
		Enumeration enum = eventos.keys();
		while (enum.hasMoreElements()) {
			Integer chave = (Integer) enum.nextElement();
			Vector lista = (Vector) eventos.get(chave);
			if (!lista.isEmpty()) {
				lista1 = lista;
				break;
			}
		}
		while (enum.hasMoreElements()) {
			Integer chave = (Integer) enum.nextElement();
			Vector lista = (Vector) eventos.get(chave);
			if (!lista.isEmpty()) {
				lista2 = lista;
				break;
			}
		}
		
		ordena(lista1);
		ordena(lista2);
		
		System.out.println("Today is:" + just(dia, 3, 'R') + just(mes, 3, 'R'));

		// imprime
		imprimeListas(lista1, lista2);
	}
	
	static void imprimeListas(Vector lista1, Vector lista2) {
		boolean deveImprimirLista1 = !lista1.isEmpty();
		boolean deveImprimirLista2 = !lista2.isEmpty();
		
		if (deveImprimirLista1 ^ deveImprimirLista2) {
			if (deveImprimirLista1) {
				imprimeLista(lista1);
			} else {
				imprimeLista(lista2);
			}
		} else if (deveImprimirLista1) {
			int mes1 = ((Evento) lista1.firstElement()).data.mes;
			int mes2 = ((Evento) lista2.firstElement()).data.mes;
			
			if ((mes1 == 12 && mes2 == 1) || (mes1 == 1 && mes2 == 12)) {
				if (mes1 > mes2) {
					imprimeLista(lista1);
					imprimeLista(lista2);
				} else {
					imprimeLista(lista2);
					imprimeLista(lista1);
				}
			} else {
				if (mes1 < mes2) {
					imprimeLista(lista1);
					imprimeLista(lista2);
				} else {
					imprimeLista(lista2);
					imprimeLista(lista1);
				}
			}
		}
	}
	
	static void imprimeLista(Vector lista) {
		Enumeration enum = lista.elements();
		while (enum.hasMoreElements()) {
			Evento evento = (Evento) enum.nextElement();
			System.out.println(just(evento.data.dia, 3, 'R') + just(evento.data.mes, 3, 'R') +
					" " + just(evento.stars, 7, 'L') + " " + evento.descricao);
		}
	}

	static void ordena(Vector lista) {
		for (int i = 1; i < lista.size(); i++) {
			for (int j = i; j > 0; j--) {
				Evento evento1 = (Evento) lista.elementAt(j - 1);
				Evento evento2 = (Evento) lista.elementAt(j);

				if (evento1.compareTo(evento2) > 0) {
					lista.setElementAt(evento1, j);
					lista.setElementAt(evento2, j - 1);
				}
			}
		}
	}

	static int getDiasRestantes(Data data1, Data data2, int ano) {
		int inc = 0;

		if (data1.mes == 2 && data2.mes == 3 && !ehBissexto(ano)) inc = -1;
		
		if (data2.dia >= data1.dia) return data2.dia - data1.dia;
		
		return DIAS_MES[data1.mes] + inc + data2.dia - data1.dia;
	}
	
	static String just(int valor, int tamanho, char tipo) {
		String texto = String.valueOf(valor);
		return just(texto, tamanho, tipo);
	}
	
	static String just(String valor, int tamanho, char tipo) {
		String complemento = getStr(' ', tamanho - valor.length());
		
		if (tipo == 'L') {
			return valor + complemento;
		} else {
			return complemento + valor;
		}
	}

	static Vector getEventos(Vector eventos, Data data) {
		Vector result = new Vector();
		Enumeration enum = eventos.elements();
		while (enum.hasMoreElements()) {
			Evento e = (Evento) enum.nextElement();
			if (e.data.equals(data)) result.addElement(e);
		}
		return result;
	}
	
	static int getNumeroDeDias(Data data, int ano) {
		return getNumeroDeDias(data.dia, data.mes, ano);
	}

	static int getNumeroDeDias(int dia, int mes, int ano) {
		int total = 0;

		for (int i = 1; i < mes; i++) {
			total += DIAS_MES[i];
		}
		
		if (mes > 2 && !ehBissexto(ano)) {
			total--;
		}
		
		total += dia;
		
		return total;
	}
	
	static Data getData(int qntDias, int ano) {
		int indice = qntDias;
		
		if (indice >= 60 && indice <= 366 && !ehBissexto(ano)) {
			indice++;
		}
		
		// verifica se estrapolou
		int sobra = indice % 366;
		if (sobra != 0) indice = sobra;
		
		return dias[indice];
	}
	
	static boolean ehBissexto(int ano) {
		return ((ano % 4 == 0) && (ano % 100 != 0)) || (ano % 400 == 0);
	}
	
	static String getStr(char caractere, int tamanho) {
		String result = "";
		for (int i = 0; i < tamanho; i++) {
			result += caractere;
		}
		return result;
	}
}

class Evento {
	public Data data;
	public int prioridade;
	public String descricao;
	public String stars;

	public Evento(int dia, int mes, int prioridade, String descricao) {
		this.data = new Data(dia, mes);
		this.prioridade = prioridade;
		this.descricao = descricao;
		this.stars = "*TODAY*";
	}
	
	public int compareTo(Object o) {
		Evento aux = (Evento) o;
		
		int difData = this.data.compareTo(aux.data);
		int difStars = aux.stars.length() - this.stars.length();
		
		if (difData != 0) {
			return difData;
		} else if (difStars != 0) {
			return difStars;
		}
		return 0;
	}
	
	public String toString() {
		return this.stars + " " + this.descricao;
	}
}

class Data {
	public int dia;
	public int mes;

	public Data(int dia, int mes) {
		this.dia = dia;
		this.mes = mes;
	}
	
	public int compareTo(Object o) {
		Data aux = (Data) o;
		
		int difMes = this.mes - aux.mes;
		int difDia = this.dia - aux.dia;
		
		if (difMes != 0) return difMes;
		return difDia;
	}
	
	public String toString() {
		return "" + this.dia + "/" + this.mes;
	}
	
	public boolean equals(Object o) {
		if (!(o instanceof Data)) return false;
		
		Data aux = (Data) o;
		return this.dia == aux.dia && this.mes == aux.mes;
	}
}