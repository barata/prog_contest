import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String line = sc.nextLine();
		String buffer = "";

		while (!"#".equals(line)) {
			line = line.replaceAll("[^A-Za-z -]", "");

			if ("".equals(buffer)) {
				if (line.charAt(line.length() - 1) == '-') {
					buffer = line.substring(line.lastIndexOf(" ") + 1, line.length() - 1);
					line = line.substring(0, line.lastIndexOf(" ") + 1);
				}
				System.out.println(line.replaceAll("-", ""));
			} else {
				buffer += line.substring(0, line.indexOf(" "));
				line = line.substring(line.indexOf(" "));
				System.out.println(buffer.replaceAll("-", ""));
				buffer = "";
				continue;
			}
			
			line = sc.nextLine();
		}
	}

}
