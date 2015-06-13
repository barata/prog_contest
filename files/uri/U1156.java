

class Main {

	public static void main(String[] args) throws Exception {
		
		double sum = 0;
		
		for (int i = 1; i <= 20; i++) {
			sum += (2 * i - 1) / Math.pow(2, i - 1);
		}
		
		System.out.printf("%.2f\n", sum);
	}

}