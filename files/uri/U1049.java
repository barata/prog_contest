import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


class Main {

	static final Map<String, String> TABLE = new HashMap<String, String>();
	
	static {
		TABLE.put("vertebrado|ave|carnivoro", "aguia");
		TABLE.put("vertebrado|ave|onivoro", "pomba");
		TABLE.put("vertebrado|mamifero|onivoro", "homem");
		TABLE.put("vertebrado|mamifero|herbivoro", "vaca");
		TABLE.put("invertebrado|inseto|hematofago", "pulga");
		TABLE.put("invertebrado|inseto|herbivoro", "lagarta");
		TABLE.put("invertebrado|anelideo|hematofago", "sanguessuga");
		TABLE.put("invertebrado|anelideo|onivoro", "minhoca");
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String w1 = br.readLine();
		String w2 = br.readLine();
		String w3 = br.readLine();
		
		System.out.println(TABLE.get(w1 + "|" + w2 + "|" + w3));
	}

}