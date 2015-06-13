

class Main {

	public static void main(String[] args) throws Exception {
		
		double sum = 0;
		
		for (int i = 1; i <= 100; i++) {
			sum += 1d / i;
		}
		
		System.out.printf("%.2f\n", sum);
	}

}