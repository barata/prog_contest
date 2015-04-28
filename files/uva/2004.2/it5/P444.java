
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
		String linha = readLn();

		while (linha != null) {
			String resultado = "";
			String valor = "";

			if (!linha.equals("")) {
				// decode
				if (isNumber(linha.charAt(0))) {
					linha = inv(linha);
					
					while (! linha.equals("") && linha.length() > 2) {
	
						int offset = 3;
						valor = linha.substring(0, 3);
							
						if (Integer.parseInt(valor) > 122) {
							offset = 2;
							valor = linha.substring(0, 2);
						}
						
						resultado += (char) Integer.parseInt(valor);
						linha = linha.substring(offset, linha.length());
					}
	
					if (!linha.equals("")) {
						valor = linha.substring(0, linha.length());
						resultado += (char) Integer.parseInt(valor);
					}
	
				} else { // encode
	
					for (int i = linha.length() - 1; i >= 0; i--) {
						
						valor = String.valueOf((int) linha.charAt(i));
						resultado += inv(valor);
						
					}
	
				}
			}

			System.out.println(resultado.trim());

			linha = readLn();
		}
	}

	static String inv(String valor) {
		String resultado = "";

		for (int i = valor.length() - 1; i >= 0; i--) {
			resultado += valor.charAt(i);
		}

		return resultado;
	}

	static boolean isNumber(char ch) {
		return ch >= '0' && ch <= '9';
	}

}