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
	
	static String[] numeros = new String[5001];
	
	static {
		numeros[0] = "0";
		numeros[1] = "1";

		BigInt penultimo = new BigInt(numeros[0]);
		BigInt ultimo = new BigInt(numeros[1]);
		
		for (int i = 2; i <= 5000; i++) {
			BigInt aux = penultimo;
			penultimo = ultimo;
			ultimo = ultimo.soma(aux);

			numeros[i] = ultimo.toString();
		}
	}

	public static void main(String[] args) {
		String linha = readLn();
		
		while (linha != null) {
			int numero = Integer.parseInt(linha);
			
			System.out.println("The Fibonacci number for " + numero + " is " + numeros[numero]);
			
			
			linha = readLn();
		}
	}
}
class BigInt {

    private static final int MAX_DIGITOS = 1050;

    private int numeroDeDigitos;
    private int[] bigNumero;
    private String bigNumeroStr;

    public BigInt(String numeroGrande) {
            numeroDeDigitos = numeroGrande.length();
            bigNumeroStr = numeroGrande;
            constroiArray();
    }

    public void constroiArray() {
            bigNumero = new int[MAX_DIGITOS];
            int stringCont = numeroDeDigitos;
            for(int i = MAX_DIGITOS - 1; i >= MAX_DIGITOS - numeroDeDigitos; i--) {
                    bigNumero[i] = Byte.parseByte(String.valueOf(bigNumeroStr.charAt(--stringCont)));
            }
    }

    public void freeArray() {
            bigNumero = new int[1];
    }

    public BigInt soma(BigInt outro) {
            int nDigitosResultado = 0;
            if( outro.numeroDeDigitos > this.numeroDeDigitos )
                    nDigitosResultado = outro.numeroDeDigitos;
            else nDigitosResultado = this.numeroDeDigitos;

            int[] resultado = new int[MAX_DIGITOS];
            for(int i = MAX_DIGITOS - 1; i >= MAX_DIGITOS - nDigitosResultado; i--) {
                    int soma = this.bigNumero[i] + outro.bigNumero[i];
                    if(soma > 9) {
                            resultado[i] += soma % 10;
                            resultado[i-1]++;
                    } else {
                            resultado[i] += soma;
                    }

                    if(resultado[i] > 9) {
                            resultado[i] = resultado[i] % 10;
                            resultado[i-1]++;
                    }

            }

            StringBuffer sb = new StringBuffer();
            for(int i = MAX_DIGITOS - nDigitosResultado - 1; i < MAX_DIGITOS ; i++)
                    sb.append(resultado[i]);
            if(sb.charAt(0) == '0')
                    sb.setCharAt(0,' ');

            return new BigInt(sb.toString().trim());
    }

    public String toString() {
            return bigNumeroStr;
    }
}