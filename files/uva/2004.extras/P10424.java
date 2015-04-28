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
        return (buffer.toString()); 
    }

	public static void main(String[] args) {
		
		String nome1 = readLn();
		
		while (nome1 != null) {
			
			String nome2 = readLn();
			
			float ratio1 = normaliza(calculateNumber(nome1));
			float ratio2 = normaliza(calculateNumber(nome2));

			double resposta;
			
			if (ratio1 > ratio2) {
				resposta = ratio2 / ratio1;
			} else{
				resposta = ratio1 / ratio2;
			}

			resposta *= 100;
			
			System.out.println(round(resposta, 2) + " %");
			
			
			
			
			nome1 = readLn();
			
		}
		
	}
	
	static int normaliza(int numero) {
		
		while (numero / 10 != 0) {
			String temp = String.valueOf(numero);
			int aux = 0;
			
			for (int i = 0; i < temp.length(); i++) {
				aux += Character.getNumericValue(temp.charAt(i));
			}
			
			numero = aux;
		}
		
		return numero;
	}
	
	static int calculateNumber(String nome) {
		int soma = 0;
		
		for (int i = 0; i < nome.length(); i++) {
			char ch = nome.toLowerCase().charAt(i);
			if (ch >= 'a' && ch <= 'z') soma += ch - 'a' + 1;
		}
		
		return soma;
	}
	
	static String round(double valor, int casas) {
		long numero = Math.round(valor * Math.pow(10, casas));
		
		String retorno = "" + (numero / (long) Math.pow(10, casas));
		retorno += ".";
		String resto = "" + (numero % (long) Math.pow(10, casas));
		resto = str('0', casas - resto.length()) + resto;
		retorno += resto;
		
		return retorno;
	}
	
	static String str(char ch, int n) {
		String resultado = "";
		for (int i = 0; i < n; i++) {
			resultado += ch;
		}
		return resultado;
	}

}
