#include <stdio.h>

#define MAX_VALUE 2147483647

long int grafo[101][101];
int maxValue = 100;

long int total, qnt;

void floyd_warshall() {
	int n, i, j;
	for (n = 1; n <= maxValue; n++) {
		for (i = 1; i <= maxValue; i++) {
			for (j = 1; j <= maxValue; j++) {
				grafo[i][j] = grafo[i][j] < grafo[i][n] + grafo[n][j] ? grafo[i][j] : grafo[i][n] + grafo[n][j];
			}
		}
	}
}

void soma() {
	int i, j;
	total = 0;
	qnt = 0;
	
	for (i = 1; i <= maxValue; i++) {
		for (j = 1; j <= maxValue; j++) {
			if (grafo[i][j] != (MAX_VALUE / 2 - 1) && grafo[i][j] != 0) {
				total += grafo[i][j];
				qnt++;
			}
		}
	}
}

int main() {
	int nTestes = 0;
	int n1, n2;
	int aux;
	
	int i, j;
	
	scanf("%d %d", &n1, &n2);
	
	while (n1 != 0 || n2 != 0) {
		
		for (i = 1; i <= maxValue; i++) {
			for (j = 1; j <= maxValue; j++) {
				if (i == j) grafo[i][j] = 0;
				else grafo[i][j] = MAX_VALUE / 2 - 1;
			}
		}
		
		maxValue = -1;
		
		while (n1 != 0 || n2 != 0) {
			aux = maxValue > n1 ? maxValue : n1;
			maxValue = aux > n2 ? aux : n2;

			grafo[n1][n2] = 1;
			
			scanf("%d %d", &n1, &n2);
		}

		floyd_warshall();
		soma();
		
		printf("Case %d: average length between pages = %.3lf clicks\n", ++nTestes, (double) total / qnt);
		
		scanf("%d %d", &n1, &n2);
	}

	return 0;
}
