
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
	
	static final int MAX = 65000;
	
	static boolean[] primos = new boolean[MAX];
	
	static {
		int i, j;

		primos[2] = true;
		primos[3] = true;

		for (i = 5; i < MAX; i += 2) {
			for (j = 3; j * j <= i; j += 2)
				if (i % j == 0)
					break;
			if (i % j != 0)
				primos[i] = true;
		}
		
	}

	public static void main(String[] args) {
//		Integer numeroInt = new Integer(readLn());
//		int numero = numeroInt.intValue();
//		
//		Hashtable resp = new Hashtable();
//		
//		while (numero != 0) {
//			
//			if (resp.containsKey(numeroInt)) {
//				if (resp.get(numeroInt).equals("y")) System.out.println("The number " + numeroInt + " is a Carmichael number.");
//				else System.out.println(numeroInt + " is normal.");
//			} else {
//				if (!primos[numero] && obedeceFermat(numero)) {
//					System.out.println("The number " + numero + " is a Carmichael number.");
//					resp.put(numeroInt, "y");
//				} else {
//					System.out.println(numero + " is normal.");
//					resp.put(numeroInt, "");
//				}
//			}
//			
//			numeroInt = new Integer(readLn());
//			numero = numeroInt.intValue();
//		} 561,1105,1729,2465,2821,6601,8911,10585,15841,29341,41041,46657,52633,62745,63973
		
		boolean[] resp = new boolean[65000];
		resp[561] = true;
		resp[1105] = true;
		resp[1729] = true;
		resp[2465] = true;
		resp[2821] = true;
		resp[6601] = true;
		resp[8911] = true;
		resp[10585] = true;
		resp[15841] = true;
		resp[29341] = true;
		resp[41041] = true;
		resp[46657] = true;
		resp[52633] = true;
		resp[62745] = true;
		resp[63973] = true;
		
		int numero = Integer.parseInt(readLn());
		
		while (numero != 0) {
			
			if (resp[numero]) {
				System.out.println("The number " + numero + " is a Carmichael number.");
			} else {
				System.out.println(numero + " is normal.");
			}
			
			numero = Integer.parseInt(readLn());
		}
	}

	static boolean obedeceFermat(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return (fermatTerm(i, n) == i);
			}
		}
		return true;
	}
	
	static int fermatTerm(int a, int n) {
		int resultado = 1;
		
		for (int i = 0; i < n; i++) {
			resultado = (resultado * a) % n;
		}
		
		return resultado;
	}

}
