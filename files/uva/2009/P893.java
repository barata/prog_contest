import java.util.Calendar;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int delta = sc.nextInt();
		int day = sc.nextInt();
		int month = sc.nextInt();
		int year = sc.nextInt();

		while (delta != 0 || day != 0 || month != 0 || year != 0) {
			Calendar cal = Calendar.getInstance();
			cal.set(year, month - 1, day);
			cal.add(Calendar.DATE, delta);

			System.out.printf("%d %d %d\n", cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.YEAR));


			delta = sc.nextInt();
			day = sc.nextInt();
			month = sc.nextInt();
			year = sc.nextInt();
		}
	}

}
