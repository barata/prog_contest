import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		
		while (!"#".equals(line = br.readLine())) {
			ArrayList<ArrayList<String>> piles = new ArrayList<ArrayList<String>>(52);
			
			StringTokenizer tks = new StringTokenizer(line);
			while (tks.hasMoreTokens()) {
				ArrayList<String> l = new ArrayList<String>(52);
				l.add(tks.nextToken());
				piles.add(l);
				
				update(piles);
			}
			tks = new StringTokenizer(br.readLine());
			while (tks.hasMoreTokens()) {
				ArrayList<String> l = new ArrayList<String>(52);
				l.add(tks.nextToken());
				piles.add(l);
				
				update(piles);
			}
			
			System.out.print(piles.size() + " pile" + (piles.size() == 1 ? " " : "s ") + "remaining:");
			for (ArrayList<String> p : piles) {
				System.out.print(" " + p.size());
			}
			System.out.println();
		}
	}
	
	private static void update(ArrayList<ArrayList<String>> piles) {
		boolean changed;
		do {
			changed = false;
			for (int i = 1; i < piles.size(); i++) {
				ArrayList<String> p = piles.get(i);
				String lastCard = p.get(p.size() - 1);
				if (i > 2) {
					ArrayList<String> aux = piles.get(i - 3);
					if (match(lastCard, aux.get(aux.size() - 1))) {
						aux.add(lastCard);
						p.remove(p.size() - 1);
						if (p.isEmpty()) piles.remove(i);
						changed = true;
						break;
					}
				}
				ArrayList<String> aux = piles.get(i - 1);
				if (match(lastCard, aux.get(aux.size() - 1))) {
					aux.add(lastCard);
					p.remove(p.size() - 1);
					if (p.isEmpty()) piles.remove(i);
					changed = true;
					break;
				}
			}
			
		} while (changed);
	}
	
	private static boolean match(String c1, String c2) {
		return c1.charAt(0) == c2.charAt(0) || c1.charAt(1) == c2.charAt(1);
	}

}
