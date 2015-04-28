import java.io.IOException;
import java.util.StringTokenizer;

class Main {

	static String readLn (int maxLg)  // utility function to read from stdin
	{
		byte lin[] = new byte [maxLg];
		int lg = 0, car = -1;
		String line = "";

		try
		{
			while (lg < maxLg)
			{
				car = System.in.read();
				if ((car < 0) || (car == '\n')) break;
				lin [lg++] += car;
			}
		}
		catch (IOException e)
		{
			return (null);
		}

		if ((car < 0) && (lg == 0)) return (null);  // eof
		return (new String (lin, 0, lg)).trim();
	}

	static String[] numeros;
	
	static {
		numeros = new String[101];
		
		numeros[1] = "i"; // 1
		numeros[2] = "ii";
		numeros[3] = "iii";
		numeros[4] = "iv";
		numeros[5] = "v";
		numeros[6] = "vi";
		numeros[7] = "vii";
		numeros[8] = "viii";
		numeros[9] = "ix";
		numeros[10] = "x"; // 10
		
		numeros[11] = "xi"; // 11
		numeros[12] = "xii";
		numeros[13] = "xiii";
		numeros[14] = "xiv";
		numeros[15] = "xv";
		numeros[16] = "xvi";
		numeros[17] = "xvii";
		numeros[18] = "xviii";
		numeros[19] = "xix";
		numeros[20] = "xx"; // 20
		
		numeros[21] = "xxi"; // 21
		numeros[22] = "xxii";
		numeros[23] = "xxiii";
		numeros[24] = "xxiv";
		numeros[25] = "xxv";
		numeros[26] = "xxvi";
		numeros[27] = "xxvii";
		numeros[28] = "xxviii";
		numeros[29] = "xxix";
		numeros[30] = "xxx"; // 30
		
		numeros[31] = "xxxi"; // 31
		numeros[32] = "xxxii";
		numeros[33] = "xxxiii";
		numeros[34] = "xxxiv";
		numeros[35] = "xxxv";
		numeros[36] = "xxxvi";
		numeros[37] = "xxxvii";
		numeros[38] = "xxxviii";
		numeros[39] = "xxxix";
		numeros[40] = "xl";  // 40
		
		numeros[41] = "xli"; // 41
		numeros[42] = "xlii";
		numeros[43] = "xliii";
		numeros[44] = "xliv";
		numeros[45] = "xlv";
		numeros[46] = "xlvi";
		numeros[47] = "xlvii";
		numeros[48] = "xlviii";
		numeros[49] = "xlix";
		numeros[50] = "l";  // 50
		
		numeros[51] = "li"; // 51
		numeros[52] = "lii";
		numeros[53] = "liii";
		numeros[54] = "liv";
		numeros[55] = "lv";
		numeros[56] = "lvi";
		numeros[57] = "lvii";
		numeros[58] = "lviii";
		numeros[59] = "lix";
		numeros[60] = "lx";  // 60
		
		numeros[61] = "lxi"; // 61
		numeros[62] = "lxii";
		numeros[63] = "lxiii";
		numeros[64] = "lxiv";
		numeros[65] = "lxv";
		numeros[66] = "lxvi";
		numeros[67] = "lxvii";
		numeros[68] = "lxviii";
		numeros[69] = "lxix";
		numeros[70] = "lxx";  // 70
		
		numeros[71] = "lxxi"; // 71
		numeros[72] = "lxxii";
		numeros[73] = "lxxiii";
		numeros[74] = "lxxiv";
		numeros[75] = "lxxv";
		numeros[76] = "lxxvi";
		numeros[77] = "lxxvii";
		numeros[78] = "lxxviii";
		numeros[79] = "lxxix";
		numeros[80] = "lxxx";  // 80
		
		numeros[81] = "lxxxi"; // 81
		numeros[82] = "lxxxii";
		numeros[83] = "lxxxiii";
		numeros[84] = "lxxxiv";
		numeros[85] = "lxxxv";
		numeros[86] = "lxxxvi";
		numeros[87] = "lxxxvii";
		numeros[88] = "lxxxviii";
		numeros[89] = "lxxxix";
		numeros[90] = "xc";  // 90
		
		numeros[91] = "xci"; // 91
		numeros[92] = "xcii";
		numeros[93] = "xciii";
		numeros[94] = "xciv";
		numeros[95] = "xcv";
		numeros[96] = "xcvi";
		numeros[97] = "xcvii";
		numeros[98] = "xcviii";
		numeros[99] = "xcix";
		numeros[100] = "c";  // 100
	}
	
	static int qnt_i, qnt_v, qnt_x, qnt_l, qnt_c;

	public static void main(String[] args) throws Exception {
		String linha;
		StringTokenizer tks;
		
		linha = readLn(255);
		tks = new StringTokenizer(linha);
		int numero = Integer.parseInt(tks.nextToken());
		
		while (numero != 0) {
			
			
			
			qnt_i = 0;
			qnt_v = 0;
			qnt_x = 0;
			qnt_l = 0;
			qnt_c = 0;
			
			for (int i = 1; i <= numero; i++) {
				conta(numeros[i]);
			}
			
			System.out.print(numero + ":");
			System.out.print(" " + qnt_i + " i");
			System.out.print(", " + qnt_v + " v");
			System.out.print(", " + qnt_x + " x");
			System.out.print(", " + qnt_l + " l");
			System.out.print(", " + qnt_c + " c");
			System.out.println();
			
			
			
			linha = readLn(255);
			tks = new StringTokenizer(linha);
			numero = Integer.parseInt(tks.nextToken());
		}
		
	}
	
	static void conta(String valor) {
		for (int i = 0; i < valor.length(); i++) {
			char ch = valor.charAt(i);
			
			switch (ch) {
			
				case 'i':
					qnt_i++;
					break;
				case 'v':
					qnt_v++;
					break;
				case 'x':
					qnt_x++;
					break;
				case 'l':
					qnt_l++;
					break;
				case 'c':
					qnt_c++;
					break;
			
			}
		}
	}
}
