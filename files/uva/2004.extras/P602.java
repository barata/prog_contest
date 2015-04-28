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
            if (car == newLine.charAt(0)) 
            System.in.skip(newLine.length() - 1); 
        } catch (java.io.IOException e) { return (null);} 
        if ((car < 0) && (buffer.length() == 0)) return (null); 
        return (buffer.toString()).trim(); 
    }
	
	static final int DIAS_MES[] = { -1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	static final String NOME_DIAS[] = { "", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" };
	
	static final String NOME_MESES[] = { "", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
	
	public static void main(String[] args) {
		String linha = readLn();
		StringTokenizer tks = new StringTokenizer(linha);
		
		int mes = Integer.parseInt(tks.nextToken());
		int dia = Integer.parseInt(tks.nextToken());
		int ano = Integer.parseInt(tks.nextToken());

		while (mes != 0 || dia != 0 || ano != 0) {
			
			boolean ehValido;
			int qntDias = 1;
			
			if (ano < 1752) {
				
				ehValido = ehValidoAntes(dia, mes, ano);
				if (ehValido) qntDias = getNumeroDeDiasAntes(dia, mes, ano);
				
			} else if (ano > 1752) {
				
				ehValido = ehValidoDepois(dia, mes, ano);
				if (ehValido) qntDias = getNumeroDeDiasAntes(31, 12, 1751) + getNumeroDeDiasEm(31, 12) + getNumeroDeDiasDepois(dia, mes, ano);
			
			} else {
				
				ehValido = ehValidoEm(dia, mes);
				if (ehValido) qntDias = getNumeroDeDiasAntes(31, 12, 1751) + getNumeroDeDiasEm(dia, mes);
				
			}
			
			if (ehValido) {
				int diaDaSemana = (qntDias - 1) % 7 + 1;
				System.out.println(NOME_MESES[mes] + " " + dia + ", " + ano + " is a " + NOME_DIAS[diaDaSemana]);
			} else {
				System.out.println(mes + "/" + dia + "/" + ano + " is an invalid date.");
			}
			
			
			linha = readLn();
			tks = new StringTokenizer(linha);
			
			mes = Integer.parseInt(tks.nextToken());
			dia = Integer.parseInt(tks.nextToken());
			ano = Integer.parseInt(tks.nextToken());
		}
	}
	
	static boolean ehValidoAntes(int dia, int mes, int ano) {
		if (ano < 0) return false;
		if (mes < 1 || mes > 12) return false;
		
		int limite = DIAS_MES[mes];
		if (mes == 2 && ehLeap(ano)) limite++;
		if (dia < 1 || dia > limite) return false;
		
		return true;
	}
	
	static boolean ehValidoEm(int dia, int mes) {
		if (mes == 9 && (dia > 2 && dia < 14)) return false;
		
		if (mes < 1 || mes > 12) return false;
		
		int limite = DIAS_MES[mes];
		if (mes == 2) limite++;
		if (dia < 1 || dia > limite) return false;
		
		return true;
	}
	
	static boolean ehValidoDepois(int dia, int mes, int ano) {
		if (ano < 0) return false;
		if (mes < 1 || mes > 12) return false;
		
		int limite = DIAS_MES[mes];
		if (mes == 2 && ehBissexto(ano)) limite++;
		if (dia < 1 || dia > limite) return false;
		
		return true;
	}

	static boolean ehBissexto(int ano) {
		return ((ehLeap(ano) && (ano % 100 != 0)) || (ano % 400 == 0));
	}
	
	static boolean ehLeap(int ano) {
		return (ano % 4 == 0);
	}

	static int getNumeroDeDiasAntes(int dia, int mes, int ano) {
		int d = 0;
		
		for (int i = 1; i < ano; i++) {
			d += 365;
			if (ehLeap(i)) d++;
		}

		for (int i = 1; i < mes; i++) {
			d += DIAS_MES[i];
		}
		
		if (mes > 2 && ehLeap(ano)) {
			d++;
		}
		
		d += dia;

		return d;
	}
	
	static int getNumeroDeDiasEm(int dia, int mes) {
		int d = 0;
		
		for (int i = 1; i < mes; i++) {
			d += DIAS_MES[i];
		}
		
		if (mes > 2) {
			d++;
		}
		
		d += dia;
		
		if (mes > 9) d -= 11;
		else if (mes == 9 && dia > 2) d -= 11;
		
		return d;
	}
	
	static int getNumeroDeDiasDepois(int dia, int mes, int ano) {
		int d = 0;
		
		for (int i = 1753; i < ano; i++) {
			d += 365;
			if (ehBissexto(i)) d++;
		}
		
		for (int i = 1; i < mes; i++) {
			d += DIAS_MES[i];
		}
		
		if (mes > 2 && ehBissexto(ano)) {
			d++;
		}
		
		d += dia;

		return d;
	}
}
