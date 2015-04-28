import java.io.IOException;

class Main {

	static String readLn(int maxLg) { // utility function to read from stdin
		byte lin[] = new byte[maxLg];
		int lg = 0, car = -1;
		String line = "";

		try {
			while (lg < maxLg) {
				car = System.in.read();
				if ((car < 0) || (car == '\n'))
					break;
				lin[lg++] += car;
			}
		} catch (IOException e) {
			return (null);
		}

		if ((car < 0) && (lg == 0))
			return (null); // eof
		return (new String(lin, 0, lg)).trim();
	}
	
	static boolean isValid(String palavra) {
		for (int i = 1; i < palavra.length(); i++) {
			if (palavra.charAt(i) <= palavra.charAt(i - 1)) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String linha = readLn(6);
		
		while (linha != null && !linha.equals("")) {
			
			int cont = 0;
			boolean achou = false;
			
			if (!isValid(linha)) {
				System.out.println("0");
			} else {
			
			// uma letra
				for (char a = 'a'; !achou && a <= 'z'; a++) {
					if (linha.equals("" + a)) achou = true;
					cont++;
				}
				
				// duas letras
				for (char a = 'a'; !achou && a <= 'z'; a++) {
					for (char b = (char)(a + 1); !achou && b <= 'z'; b++) {
						if (linha.equals("" + a + b)) achou = true;
						cont++;
					}
				}
				
				// tres letras
				for (char a = 'a'; !achou && a <= 'z'; a++) {
					for (char b = (char)(a + 1); !achou && b <= 'z'; b++) {
						for (char c = (char)(b + 1); !achou && c <= 'z'; c++) {
							if (linha.equals("" + a + b + c)) achou = true;
							cont++;
						}
					}
				}
				
				// quatro letras
				for (char a = 'a'; !achou && a <= 'z'; a++) {
					for (char b = (char)(a + 1); !achou && b <= 'z'; b++) {
						for (char c = (char)(b + 1); !achou && c <= 'z'; c++) {
							for (char d = (char)(c + 1); !achou && d <= 'z'; d++) {
								if (linha.equals("" + a + b + c + d)) achou = true;
								cont++;
							}
						}
					}
				}
				
				// cinco letras
				for (char a = 'a'; !achou && a <= 'z'; a++) {
					for (char b = (char)(a + 1); !achou && b <= 'z'; b++) {
						for (char c = (char)(b + 1); !achou && c <= 'z'; c++) {
							for (char d = (char)(c + 1); !achou && d <= 'z'; d++) {
								for (char e = (char)(d + 1); !achou && e <= 'z'; e++) {
									if (linha.equals("" + a + b + c + d + e)) achou = true;
									cont++;
								}
							}
						}
					}
				}
				
				System.out.println(cont);
			}
			
			linha = readLn(6);
		}
	}
}
