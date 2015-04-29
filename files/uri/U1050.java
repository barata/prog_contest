import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


class Main {

	static final Map<String, String> TABLE = new HashMap<String, String>();
	
	static {
		TABLE.put("61", "Brasilia");
		TABLE.put("71", "Salvador");
		TABLE.put("11", "Sao Paulo");
		TABLE.put("21", "Rio de Janeiro");
		TABLE.put("32", "Juiz de Fora");
		TABLE.put("19", "Campinas");
		TABLE.put("27", "Vitoria");
		TABLE.put("31", "Belo Horizonte");
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String ddd = br.readLine();
		
		System.out.println(TABLE.containsKey(ddd) ? TABLE.get(ddd) : "DDD nao cadastrado");
	}

}