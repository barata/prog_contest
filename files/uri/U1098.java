
class Main {

	public static void main(String[] args) throws Exception {
		
		for (int i = 0; i <= 20; i += 2) {
			for (int j = 1; j <= 3; j++) {
				String cmp = (i % 10 != 0 ? "." + (i % 10) : "");
				System.out.println("I=" + (i / 10) + cmp + " J=" + (i / 10 + j) + cmp);
			}
		}
		
	}

}