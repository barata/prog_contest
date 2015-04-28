import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nTests = Integer.parseInt(br.readLine());
		
		br.readLine();
		
		for (int g = 0; g < nTests; g++) {
			StringTokenizer tks = new StringTokenizer(br.readLine());
			String line = tks.nextToken();
			int a;
			if ("*".equals(line)) a = 0;
			else a = Integer.parseInt(line);
			int b;
			if (tks.hasMoreTokens()) b = Integer.parseInt(tks.nextToken());
			else b = a;
			List<String> names = new ArrayList<String>(12);
			
			while (!"".equals(line = br.readLine()) && line != null) {
				names.add(line);
			}
			
			if (a == 0) {
				a = 1;
				b = names.size();
			}
			for (int i = a; i <= b; i++) {
				System.out.println("Size " + i);
				combinations(names, 0, i, new LinkedList<String>());
				System.out.println();
			}
			if (g < nTests - 1) System.out.println();
		}
	}

	private static void combinations(List<String> names, int start, int level, LinkedList<String> result) {
		if (level == 0) {
			String s = result.toString();
			System.out.println(s.substring(1, s.length() - 1));
			return;
		}
		for (int i = start; i < names.size(); i++) {
			result.addLast(names.get(i));
			combinations(names, i + 1, level - 1, result);
			result.removeLast();
		}
	}

}
