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
            if (car == newLine.charAt(0)) 
            System.in.skip(newLine.length() - 1); 
        } catch (java.io.IOException e) { return (null);} 
        if ((car < 0) && (buffer.length() == 0)) return (null); 
        return (buffer.toString()).trim(); 
    }
	
	public static void main(String[] args) {
		String linha = readLn();
		
		int nTestes = Integer.parseInt(linha);
		readLn();
		
		for (int g = 0; g < nTestes; g++) {
			
			Registro[][] tabela = new Registro[26][7];
			
			Vector entrada = new Vector();
		
			linha = readLn();
			
			while (linha != null && !linha.equals("")) {
				StringTokenizer tks = new StringTokenizer(linha);
				
				int idDaEquipe = Integer.parseInt(tks.nextToken());
				char idDoProblema = tks.nextToken().charAt(0);
				int tempo = extraiTempo(tks.nextToken());
				char resultado = tks.nextToken().charAt(0);
				
				entrada.addElement(new Entrada(idDaEquipe, idDoProblema, tempo, resultado));
				
				linha = readLn();
			}
			
			// processa entrada
			prepara(entrada);
			
			while (!entrada.isEmpty()) {
				Entrada ent = (Entrada) entrada.firstElement();
				entrada.removeElementAt(0);
				
				int idDaEquipe = ent.idDaEquipe;
				char idDoProblema = ent.idDoProblema;
				int tempo = ent.tempo;
				char resultado = ent.resultado;
	
				if (tabela[idDaEquipe][idDoProblema - 'A'] == null) {
					tabela[idDaEquipe][idDoProblema - 'A'] = new Registro();
				}
				
				Registro reg = tabela[idDaEquipe][idDoProblema - 'A'];
				
				if (reg.status == false) {
					if (resultado == 'N') reg.submissoesErradas++;
					else {
						reg.status = true;
						reg.tempoAceito = 20 * reg.submissoesErradas + tempo;
					}
				}

			}
			
			Vector lista = extraiLista(tabela);
			ordena(lista);
			
			imprime(lista);
			if (g < nTestes - 1) System.out.println();
		}
	}

	static void prepara(Vector lista) {
		for (int i = 1; i < lista.size(); i++) {
			for (int j = lista.size() - 1; j >= i; j--) {
				Entrada e1 = ((Entrada) lista.elementAt(j - 1));
				Entrada e2 = ((Entrada) lista.elementAt(j));
				
				if (e1.tempo > e2.tempo) {
					lista.setElementAt(e2, j - 1);
					lista.setElementAt(e1, j);
				} else if (e1.tempo == e2.tempo) {
					if (e1.resultado == 'Y' && e2.resultado == 'N') {
						lista.setElementAt(e2, j - 1);
						lista.setElementAt(e1, j);
					}
				}
			}
		}
	}

	static void imprime(Vector lista) {
		System.out.println("RANK TEAM PRO/SOLVED TIME");
		
		if (! lista.isEmpty() ) {
			Classificavel b = (Classificavel) lista.firstElement();
			b.posicao = 1;
			System.out.print("   1");
			System.out.println(b);
			
			for (int i = 1; i < lista.size(); i++) {
				Classificavel a = (Classificavel) lista.elementAt(i - 1);
				b = (Classificavel) lista.elementAt(i);
				
				if (a.numeroDeAceitos == b.numeroDeAceitos && a.tempo == b.tempo) {
					b.posicao = a.posicao;
				} else b.posicao = (i + 1);
				
				System.out.print(formata(b.posicao, 4));
				System.out.println(b);
			}
		}
	}

	static String formata(int numero, int espaco) {
		String n = "" + numero;
		
		return str(' ', espaco - n.length()) + n;
	}
	
	static String str(char ch, int n) {
		String resultado = "";
		n = Math.max(0, n);
		for (int i = 0; i < n; i++) {
			resultado += ch;
		}
		return resultado;
	}

	static void ordena(Vector lista) {
		for (int i = 1; i < lista.size(); i++) {
			for (int j = lista.size() - 1; j >= i; j--) {
				Classificavel p1 = ((Classificavel) lista.elementAt(j - 1));
				Classificavel p2 = ((Classificavel) lista.elementAt(j));
				
				if (p1.numeroDeAceitos < p2.numeroDeAceitos) {
					lista.setElementAt(p2, j - 1);
					lista.setElementAt(p1, j);
				} else if (p1.numeroDeAceitos == p2.numeroDeAceitos) {
					if (p1.tempo > p2.tempo) {
						lista.setElementAt(p2, j - 1);
						lista.setElementAt(p1, j);
					} else if (p1.tempo == p2.tempo) {
						if (p1.idDaEquipe > p2.idDaEquipe) {
							lista.setElementAt(p2, j - 1);
							lista.setElementAt(p1, j);
						}
					}
				}
			}
		}
	}

	static Vector extraiLista(Registro[][] tabela) {
		Vector lista = new Vector();
		int maxIdDeEquipe = 0;
		
		for (int i = 1; i < tabela.length; i++) {
			for (int j = 0; j < tabela[i].length; j++) {
				if (tabela[i][j] != null) {
					maxIdDeEquipe = i;
					break;
				}
			}
		}
		
		for (int i = 1; i <= maxIdDeEquipe; i++) {
			int numeroDeAceitos = 0;
			int tempo = 0;
			
			for (int j = 0; j < tabela[i].length; j++) {
				if (tabela[i][j] != null) {
					Registro reg = tabela[i][j];
					
					if (reg.status) {
						numeroDeAceitos++;
						tempo += reg.tempoAceito;
					}
				}
			}
			
			lista.addElement(new Classificavel(i, numeroDeAceitos, tempo));
		}
		
		return lista;
	}

	static int extraiTempo(String string) {
		StringTokenizer tks = new StringTokenizer(string, ":");
		
		int hora = Integer.parseInt(tks.nextToken());
		int minuto = Integer.parseInt(tks.nextToken());
		
		return hora * 60 + minuto;
	}

}

class Classificavel {
	
	public int posicao;
	public int idDaEquipe;
	public int numeroDeAceitos;
	public int tempo;

	public Classificavel(int idDaEquipe, int numeroDeAceitos, int tempo) {
		this.posicao = -1;
		this.idDaEquipe = idDaEquipe;
		this.numeroDeAceitos = numeroDeAceitos;
		this.tempo = tempo;
	}
	
	public String toString() {
		if (this.numeroDeAceitos == 0) {
			return " " + Main.formata(this.idDaEquipe, 4);
		}
		return " " + Main.formata(this.idDaEquipe, 4) + " " + Main.formata(this.numeroDeAceitos, 4) + Main.formata(this.tempo, 11);
	}
	
}

class Registro {
	
	public boolean status;
	public int submissoesErradas;
	public int tempoAceito;
	
	public Registro() {
		this.status = false;
		this.submissoesErradas = 0;
		this.tempoAceito = 0;
	}

	
}

class Entrada {
	
	public int idDaEquipe;
	public char idDoProblema;
	public int tempo;
	public char resultado;
	
	public Entrada(int idDaEquipe, char idDoProblema, int tempo, char resultado) {
		this.idDaEquipe = idDaEquipe;
		this.idDoProblema = idDoProblema;
		this.tempo = tempo;
		this.resultado = resultado;
	}
	
}