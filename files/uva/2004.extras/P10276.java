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
		int nTestes = Integer.parseInt(readLn());
		
		for (int g = 0; g < nTestes; g++) {
			int nBastoes = Integer.parseInt(readLn());
			
			// processa
			Vector[] bastoes = new Vector[nBastoes];
			
			for (int i = 0; i < bastoes.length; i++) {
				bastoes[i] = new Vector();
			}
			
			int cont = 1;
			
			Integer bola = new Integer(1);
			
			int i = 0;
			
			while (i < bastoes.length) {
				
				if (podeColocar(bastoes[i], bola.intValue())) {
					bastoes[i].addElement(bola);
					bola = new Integer(bola.intValue() + 1);
					cont++;
					
					i = 0;
				} else {
					i++;
				}
				
			}
				
			
			System.out.println(cont - 1);
		}
	}
	
	static boolean podeColocar(Vector v, int numero) {
		if (v.isEmpty()) return true;
		
		int soma = ((Integer) v.lastElement()).intValue() + numero;
		
		long raiz = Math.round(Math.sqrt(soma));
		
		return raiz * raiz == soma;
	}
}
