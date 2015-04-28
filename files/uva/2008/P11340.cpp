#include <iostream>
#include <string>
using namespace std;

int main() {
	int n, k, m;
	int cost, costs[256];
	
	cin >> n;
	
	for (int nCase = 0; nCase < n; nCase++) {
		
		for (int i = 0; i < 256; i++) costs[i] = 0;
		
		cin >> k;
		
		for (int i = 0; i < k; i++) {
			unsigned char c;
			
			cin >> c;
			cin >> cost;
			
			costs[c] = cost;
		}
		
		cost = 0;
		cin >> m;
		cin.get();
		int linesRead = 0;
		
		while (linesRead < m) {
			unsigned char c;
			c = cin.get();
			
			cost += costs[c];
			
			if (c == '\n') {
				linesRead++;
			}
		}
		
		printf("%.2f$\n", cost/100.0);
	}
	
	
	
	return 0;
}
