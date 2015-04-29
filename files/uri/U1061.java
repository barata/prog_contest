import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		StringTokenizer tks = new StringTokenizer(line);
		tks.nextToken();
		int d1 = Integer.parseInt(tks.nextToken());
		
		line = br.readLine();
		tks = new StringTokenizer(line, ":");
		int h1 = Integer.parseInt(tks.nextToken().trim());
		int m1 = Integer.parseInt(tks.nextToken().trim());
		int s1 = Integer.parseInt(tks.nextToken().trim());
		
		line = br.readLine();
		tks = new StringTokenizer(line);
		tks.nextToken();
		int d2 = Integer.parseInt(tks.nextToken());
		
		line = br.readLine();
		tks = new StringTokenizer(line, ":");
		int h2 = Integer.parseInt(tks.nextToken().trim());
		int m2 = Integer.parseInt(tks.nextToken().trim());
		int s2 = Integer.parseInt(tks.nextToken().trim());
		
		Calendar cal1 = Calendar.getInstance();
		cal1.set(2000, 0, d1, h1, m1, s1);
		
		Calendar cal2 = Calendar.getInstance();
		cal2.set(2000, 0, d2, h2, m2, s2);
		
		long totalInSecs = (cal2.getTimeInMillis() - cal1.getTimeInMillis()) / 1000;
		
		System.out.printf("%d dia(s)\n", totalInSecs / 86400);
		System.out.printf("%d hora(s)\n", (totalInSecs % 86400) / 3600);
		System.out.printf("%d minuto(s)\n", ((totalInSecs % 86400) % 3600) / 60);
		System.out.printf("%d segundo(s)\n", ((totalInSecs % 86400) % 3600) % 60);
	}

}