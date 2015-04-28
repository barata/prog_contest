
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
		
		while (linha != null) {
			
			BigInt num1 = new BigInt(linha);
			BigInt num2 = new BigInt(readLn());
			
			System.out.println(num1.multiply(num2));
			
			
			linha = readLn();
		}
	}

}

class BigInt implements Comparable {

	int PLUS = 1;

	int MINUS = -1;

	int MAXDIGITS = 500;

	char[] digits;

	int signbit;

	int lastdigit;

	private BigInt() {
		digits = new char[MAXDIGITS];
		signbit = 1;
		lastdigit = 0;
	}

	public BigInt(String s) {
		if (s.charAt(0) == '-') {
			signbit = -1;
			s = s.substring(1, s.length());
		} else {
			signbit = 1;
		}
		digits = new char[MAXDIGITS];
		for (int i = 0; i < s.length(); i++) {
			digits[i] = (char) ((int) s.charAt(s.length() - i - 1) - (int) '0');
		}
		lastdigit = s.length() - 1;
	}

	public BigInt(int i) {
		this("" + i);
	}

	public BigInt add(int i) {
		return add(new BigInt(i));
	}

	public BigInt subtract(int i) {
		return subtract(new BigInt(i));
	}

	public BigInt multiply(int i) {
		return multiply(new BigInt(i));
	}

	public BigInt divide(int i) {
		return divide(new BigInt(i));
	}

	public BigInt add(BigInt b) {
		BigInt c = new BigInt();
		if (signbit == b.signbit) {
			c.signbit = signbit;
		} else {
			if (signbit == MINUS) {
				signbit = PLUS;
				c = b.subtract(this);
				signbit = MINUS;
			} else {
				b.signbit = PLUS;
				c = subtract(b);
				b.signbit = MINUS;
			}
			return c;
		}
		c.lastdigit = Math.max(lastdigit, b.lastdigit) + 1;
		int carry = 0;
		for (int i = 0; i <= c.lastdigit; i++) {
			c.digits[i] = (char) ((carry + digits[i] + b.digits[i]) % 10);
			carry = (carry + digits[i] + b.digits[i]) / 10;
		}
		c.zeroJustify();
		return c;
	}

	public BigInt subtract(BigInt b) {
		BigInt c = new BigInt();
		if (signbit == MINUS || b.signbit == MINUS) {
			b.signbit = -1 * b.signbit;
			c = add(b);
			b.signbit = -1 * b.signbit;
			return c;
		}
		if (compareTo(b) < 0) {
			c = b.subtract(this);
			c.signbit = MINUS;
			return c;
		}
		c.lastdigit = Math.max(lastdigit, b.lastdigit);
		int borrow = 0;
		for (int i = 0; i <= c.lastdigit; i++) {
			int v = digits[i] - borrow - b.digits[i];
			if (digits[i] > 0) {
				borrow = 0;
			}
			if (v < 0) {
				v = v + 10;
				borrow = 1;
			}
			c.digits[i] = (char) (v % 10);
		}
		c.zeroJustify();
		return c;
	}

	public BigInt multiply(BigInt b) {
		BigInt c = new BigInt();
		BigInt row = (BigInt) clone();
		for (int i = 0; i <= b.lastdigit; i++) {
			for (int j = 1; j <= b.digits[i]; j++) {
				c = c.add(row);
			}
			row.digitShift(1);
		}
		c.signbit = signbit * b.signbit;
		c.zeroJustify();
		return c;
	}

	public BigInt divide(BigInt b) {
		BigInt c = new BigInt();
		c.signbit = signbit * b.signbit;
		int asignbit = signbit;
		signbit = PLUS;
		b.signbit = PLUS;
		c.lastdigit = lastdigit;
		BigInt row = new BigInt();
		for (int i = lastdigit; i >= 0; i--) {
			row.digitShift(1);
			row.digits[0] = digits[i];
			c.digits[i] = 0;
			while (row.compareTo(b) >= 0) {
				c.digits[i]++;
				row = row.subtract(b);
			}
		}
		signbit = asignbit;
		b.signbit = b.signbit;
		c.zeroJustify();
		return c;
	}

	public boolean isZero() {
		return (lastdigit == 0 && digits[0] == 0);
	}

	private void digitShift(int d) {
		if (!isZero()) {
			for (int i = lastdigit; i >= 0; i--) {
				digits[i + d] = digits[i];
			}
			for (int i = 0; i < d; i++) {
				digits[i] = 0;
			}
			lastdigit = lastdigit + d;
		}
	}

	public int compareTo(Object o) {
		BigInt b = (BigInt) o;
		if (signbit == MINUS && b.signbit == PLUS) {
			return -1;
		} else if (signbit == PLUS && b.signbit == MINUS) {
			return 1;
		}
		if (lastdigit < b.lastdigit) {
			return (-1 * signbit);
		} else if (lastdigit > b.lastdigit) {
			return signbit;
		}
		for (int i = lastdigit; i >= 0; i--) {
			if (digits[i] > b.digits[i]) {
				return signbit;
			} else if (digits[i] < b.digits[i]) {
				return (-1 * signbit);
			}
		}
		return 0;
	}

	public Object clone() {
		BigInt c = new BigInt();
		c.signbit = signbit;
		c.lastdigit = lastdigit;
		for (int i = 0; i <= lastdigit; i++) {
			c.digits[i] = digits[i];
		}
		return c;
	}

	private void zeroJustify() {
		while (lastdigit > 0 && digits[lastdigit] == 0) {
			lastdigit--;
		}
		if (lastdigit == 0 && digits[0] == 0) {
			signbit = PLUS;
		}
	}

	public String toString() {
		String s = "";
		if (signbit == MINUS) {
			s += "-";
		}
		for (int i = lastdigit; i >= 0; i--) {
			s += (char) ('0' + digits[i]);
		}
		return s;
	}
}