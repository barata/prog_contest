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
		int nDepartamentos = Integer.parseInt(readLn());
		
		Vector lista = new Vector();
		
		for (int g = 0; g < nDepartamentos; g++) {
			String nomeDoDepartamento = readLn();
			
			String linha = readLn();
			while (linha != null && !linha.equals("")) {
				StringTokenizer tks = new StringTokenizer(linha, ",");

				String titulo = tks.nextToken();
				String primeiroNome = tks.nextToken();
				String ultimoNome = tks.nextToken();
				String endereco = tks.nextToken();
				String telefoneCasa = tks.nextToken();
				String telefoneTrabalho = tks.nextToken();
				String mailBox = tks.nextToken();
				
				Pessoa p = new Pessoa(nomeDoDepartamento, titulo, primeiroNome, ultimoNome,
						endereco, telefoneCasa, telefoneTrabalho, mailBox);
				
				lista.addElement(p);
				
				linha = readLn();
			}
		}
		
		ordena(lista);
		
		imprimeLista(lista);
	}

	private static void imprimeLista(Vector lista) {
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.elementAt(i));
		}
	}
	
	static void ordena(Vector lista) {
		for (int i = 1; i < lista.size(); i++) {
			for (int j = lista.size() - 1; j >= i; j--) {
				Pessoa p1 = ((Pessoa) lista.elementAt(j - 1));
				Pessoa p2 = ((Pessoa) lista.elementAt(j));
				
				if (p1.ultimoNome.compareTo(p2.ultimoNome) > 0) {
					lista.setElementAt(p2, j - 1);
					lista.setElementAt(p1, j);
				}
			}
		}
	}
}
class Pessoa {
	public String departamento;
	public String titulo;
	public String primeiroNome;
	public String ultimoNome;
	public String endereco;
	public String telefoneCasa;
	public String telefoneTrabalho;
	public String mailBox;
	
	public Pessoa(String departamento, String titulo, String primeiroNome, String ultimoNome,
			String endereco, String telefoneCasa, String telefoneTrabalho, String mailBox) {
		this.departamento = departamento;
		this.titulo = titulo;
		this.primeiroNome = primeiroNome;
		this.ultimoNome = ultimoNome;
		this.endereco = endereco;
		this.telefoneCasa = telefoneCasa;
		this.telefoneTrabalho = telefoneTrabalho;
		this.mailBox = mailBox;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("----------------------------------------\n");
		sb.append(this.titulo + " " + this.primeiroNome + " " + this.ultimoNome + "\n");
		sb.append(this.endereco + "\n");
		sb.append("Department: " + this.departamento + "\n");
		sb.append("Home Phone: " + this.telefoneCasa + "\n");
		sb.append("Work Phone: " + this.telefoneTrabalho + "\n");
		sb.append("Campus Box: " + this.mailBox);
		
		return sb.toString();
	}
}