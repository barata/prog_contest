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
		StringTokenizer st = new StringTokenizer(readLn());
		
		long alturaGato = Long.parseLong(st.nextToken());
		long numGatosAtivos = Long.parseLong(st.nextToken());
		
		while (alturaGato != 0 || numGatosAtivos != 0) {
			
			long numGatosInativos;
			
			if (alturaGato == 1) {
				System.out.println("0 " + numGatosAtivos);
			} else {
				numGatosInativos = 1;

				long grau = achaGrau(alturaGato, numGatosAtivos);
				
				long altura = alturaGato / (grau + 1);
				long gatos = 1;
				
				while (altura > 1) {
					gatos *= grau;
					numGatosInativos += gatos;
					alturaGato += (long) (altura * gatos);
					altura /= grau + 1;
				}
				
				alturaGato += numGatosAtivos;
				
				System.out.println(numGatosInativos + " " + alturaGato);
			}
			
			
			
			st = new StringTokenizer(readLn());
			
			alturaGato = Long.parseLong(st.nextToken());
			numGatosAtivos = Long.parseLong(st.nextToken());
		}
	}

	public static long achaGrau(long alturaGato, long numTrabalhadores) {
		double potencia = Math.log(alturaGato) / Math.log(numTrabalhadores);
		long grau = 1;
		
		while (Math.log(grau + 1) / Math.log(grau) - potencia > 1e-15) {
			grau++;
		}
		
		return grau;
	}

}