import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int nTests = Integer.parseInt(br.readLine());
		
		for (int g = 0; g < nTests; g++) {
			StringTokenizer tks = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(tks.nextToken());
			int m = Integer.parseInt(tks.nextToken());
			
			int[] groupByNode = new int[n + 1];
			Map<Integer,List<Integer>> nodesByGroup = new HashMap<Integer, List<Integer>>();
			
			for (int i = 1; i < groupByNode.length; i++) {
				groupByNode[i] = i;
				List<Integer> l = new LinkedList<Integer>();
				l.add(i);
				nodesByGroup.put(i, l);
			}
			
			int max = 0;
			
			for (int i = 0; i < m; i++) {
				tks = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(tks.nextToken());
				int b = Integer.parseInt(tks.nextToken());
				
				int biggestGroup = groupByNode[a];
				int smallestGroup = groupByNode[b];
				
				if (biggestGroup == smallestGroup) continue;
				
				if (nodesByGroup.get(biggestGroup).size() < nodesByGroup.get(smallestGroup).size()) {
					biggestGroup = groupByNode[b];
					smallestGroup = groupByNode[a];
				}
				
				List<Integer> biggest = nodesByGroup.get(biggestGroup);
				List<Integer> smallest = nodesByGroup.get(smallestGroup);
				for (int k : smallest) {
					groupByNode[k] = biggestGroup;
					biggest.add(k);
				}
				nodesByGroup.remove(smallestGroup);
				max = Math.max(max, biggest.size());
			}
			
			System.out.println(max);
		}
	}

}
