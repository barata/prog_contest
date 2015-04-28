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
		
		for (int g = 0; g < nTestes; g++) {
			linha = readLn();
			
			System.out.println("The maximum and minimum are " + getMax(linha) + " and " + getMin(linha) + ".");
		}
	}
	
	static Long getMin(String linha) {
		Vector numeros = new Vector(12);
		Vector operadores = new Vector(12);
		preenche(linha, numeros, operadores);
		
		calcula(numeros, operadores, "*");
		calcula(numeros, operadores, "+");
		
		return (Long) numeros.firstElement();
	}
	
	static Long getMax(String linha) {
		Vector numeros = new Vector(12);
		Vector operadores = new Vector(12);
		preenche(linha, numeros, operadores);
		
		calcula(numeros, operadores, "+");
		calcula(numeros, operadores, "*");
		
		return (Long) numeros.firstElement();
	}

	private static void calcula(Vector numeros, Vector operadores, String str) {
		int i = 0;
		
		while (i < operadores.size()) {
			if (operadores.elementAt(i).equals(str)) {
				long op1 = ((Long) numeros.elementAt(i)).longValue();
				numeros.removeElementAt(i);
				
				long op2 = ((Long) numeros.elementAt(i)).longValue();
				numeros.removeElementAt(i);
				
				if ("+".equals(str)) numeros.insertElementAt(new Long(op1 + op2), i);
				else if ("*".equals(str)) numeros.insertElementAt(new Long(op1 * op2), i);
				else throw new RuntimeException();
				operadores.removeElementAt(i);
			} else i++;
		}
	}
	
	static void preenche(String linha, Vector numeros, Vector operadores) {
		StringTokenizer tks = new StringTokenizer(linha, "+*", true);
		
		numeros.addElement(new Long(tks.nextToken()));
		
		while (tks.hasMoreTokens()) {
			operadores.addElement(tks.nextToken());
			numeros.addElement(new Long(tks.nextToken()));
		}
	}

}
