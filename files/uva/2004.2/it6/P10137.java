class Main
{
	static String readLn()
	{
		String newLine = System.getProperty("line.separator");
		StringBuffer buffer = new StringBuffer();
		int car = -1;

		try
		{
			car = System.in.read();
			while ((car > 0) && (car != newLine.charAt(0)))
			{
				buffer.append(Character.toLowerCase( (char)car ));
				car = System.in.read();
			}
			if (car == newLine.charAt(0))
			{
				System.in.skip(newLine.length() - 1);
			}
		}
		catch (java.io.IOException e)
		{
			return (null);
		}

		if ((car < 0) && (buffer.length() == 0))
		{
			return (null);  /* eof */
		}
		return (buffer.toString()).trim();
	}

	public static void main(String[] args)
	{
		String linha;
		
		linha = readLn();

		while (!"0".equals(linha)) {
			int n = Integer.parseInt(linha);
			double[] gastos = new double[n];
			double soma = 0.0;
			double media;

			for (int i = 0; i < gastos.length; i++) {
				gastos[i] = new Double(readLn()).doubleValue();
				soma += gastos[i];
			}
			
			// calcula a media
			media = soma / n;
			media = Math.floor(media * 100 + 0.5) / 100.0;

			// acumula o valor a ser trocado entre os estudantes
			double acimaMedia = 0.0;
			double abaixoMedia = 0.0;
			
			for (int i = 0; i < gastos.length; i++) {
				if (gastos[i] > media) {
					acimaMedia += gastos[i] - media;
				} else if (gastos[i] < media) {
					abaixoMedia += media - gastos[i];
				}
			}
			
			double resultado = Math.min(acimaMedia, abaixoMedia);
			System.out.println("$" + round(resultado, 100));
			
			
			
			
			linha = readLn();
		}
	}
	
	static String round(double valor, int casas) {
		long numero = Math.round(valor * casas);

		String retorno = "" + numero / casas;
		retorno += ".";
		String resto = "" + (numero % casas);
		resto = str('0', 2 - resto.length()) + resto;
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
