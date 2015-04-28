import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tks = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(tks.nextToken());
		int k = Integer.parseInt(tks.nextToken());
		
		while (n != 0 || k != 0) {
			int count = n;
			
			Person first = new Person(1);
			Person current = first;
			Person aux = first;
			for (int i = 2; i <= n; i++) {
				current.next = new Person(i);
				current = current.next;
				if (i == k%n) aux = current;
			}
			current.next = first;
			current = aux;
			
			while (count > 1) {
				aux = current;
				for (int i = 0; i < k - 1; i++) {
					aux = aux.next;
					if (aux.next.id == current.id) aux = aux.next;
				}
				current.id = aux.next.id;
				aux.next = aux.next.next;
				
				count--;
				
				for (int i = 0; i < k; i++) {
					current = current.next;
				}
			}

			System.out.println((n - current.next.id + 1) % n + 1);

			tks = new StringTokenizer(br.readLine());
			n = Integer.parseInt(tks.nextToken());
			k = Integer.parseInt(tks.nextToken());
		}
	}
}

class Person {
	public int id;
	public Person next;
	
	public Person(int id) {
		this.id = id;
	}
}