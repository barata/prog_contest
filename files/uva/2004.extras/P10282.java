import java.util.Hashtable;
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
		String linha = readLn();
		
		Hashtable dic = new Hashtable();
		
		while (!linha.equals("")) {
			StringTokenizer tks = new StringTokenizer(linha);
			
			String english = tks.nextToken();
			String foreign = tks.nextToken();
			
			dic.put(foreign, english);
			
			
			linha = readLn();
		}
		
		linha = readLn();
		
		while (linha != null) {
			
			if (dic.containsKey(linha)) {
				System.out.println(dic.get(linha));
			} else {
				System.out.println("eh");
			}
			
			
			linha = readLn();
		}
	}

}
