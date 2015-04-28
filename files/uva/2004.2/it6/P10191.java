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

	public static void main(String[] args) {
		try {
		String linha;
		int cont = 0;

		linha = readLn();
		
		while (linha != null) {
			int numeroDeCompromissos = Integer.parseInt(linha);
			
			boolean[] minutos = new boolean[480];
			
			for (int i = 0; i < numeroDeCompromissos; i++) {
				linha = readLn();
				StringTokenizer tks = new StringTokenizer(linha);
				
				int horaInicial = getMinutos(tks.nextToken());
				int horaFinal = getMinutos(tks.nextToken());
				
				for (int j = horaInicial; j < horaFinal; j++) {
					minutos[j] = true;
				}
			}
			
			int inicioResposta = 0;
			int fimResposta = -1;
			int inicioParcial = 0;
			int fimParcial = -1;
			
			if (!minutos[0]) {
				inicioParcial = 0;
				fimParcial = 0;
			}
			
			for (int i = 1; i < minutos.length; i++) {
				if (!minutos[i]) {
					if (minutos[i - 1]) {
						inicioParcial = i;
					}
					fimParcial = i;
				}
				
				if (fimParcial - inicioParcial > fimResposta - inicioResposta) {
					inicioResposta = inicioParcial;
					fimResposta = fimParcial;
				}
			}
			
			String resposta = "Day #" + (++cont) + ": the longest nap starts at " + getTempo(inicioResposta) + " and will last for ";
			if ((fimResposta - inicioResposta + 1) / 60 > 0) {
				resposta += ((fimResposta - inicioResposta + 1) / 60) + " hours and ";
			}
			resposta += ((fimResposta - inicioResposta + 1) % 60) + " minutes.";
			
			System.out.println(resposta);
			
			linha = readLn();
		}
		} catch (Exception e) { while (true); }
	}
	
	static int getMinutos(String texto) {
		StringTokenizer tks = new StringTokenizer(texto, ":");
		
		int hora = Integer.parseInt(tks.nextToken());
		int minuto = Integer.parseInt(tks.nextToken());
		
		return hora * 60 + minuto - 600;
	}
	
	static String getTempo(int minutos) {
		String resposta = "";
		
		resposta += minutos / 60 + 10;
		resposta += ":";
		if (minutos % 60 < 10) resposta += "0";
		resposta += minutos % 60;

		return resposta;
	}

}
