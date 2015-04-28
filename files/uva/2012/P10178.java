import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		
		while ((line = br.readLine()) != null) {
			StringTokenizer tks = new StringTokenizer(line);
			int n = Integer.parseInt(tks.nextToken());
			int e = Integer.parseInt(tks.nextToken());
			
			int nextGroup = 1;
			int[] groups = new int[256];
			
			for (int i = 0; i < e; i++) {
				tks = new StringTokenizer(br.readLine());
				char node1 = tks.nextToken().charAt(0);
				char node2 = tks.nextToken().charAt(0);
				
				int maxGroup = Math.max(groups[node1], groups[node2]);
				if (maxGroup == 0) {
					groups[node1] = groups[node2] = nextGroup++;
				} else {
					int minGroup = Math.min(groups[node1], groups[node2]);
					
					if (minGroup == 0) {
						groups[node1] = groups[node2] = maxGroup;
					} else {
						for (char c = 'A'; c <= 'z'; c++) {
							if (groups[c] == minGroup) groups[c] = maxGroup;
						}
					}
				}
			}
			
			Set<Integer> totalGroups = new HashSet<Integer>();
			int count = 0;
			for (char c = 'A'; c <= 'z'; c++) {
				if (groups[c] > 0) {
					totalGroups.add(groups[c]);
					count++;
				}
			}
			
			System.out.println(e + 1 + totalGroups.size() - count);
		}
	}

}
