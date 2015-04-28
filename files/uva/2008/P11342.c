#include <stdio.h>

#define MAX 224
#define MAX_VALUE 50000
#define DEFAULT -1

int main() {
	int n, k;
	int i, a, b, c;
	int matrix[MAX_VALUE + 1][3];
	
	for (i = 0; i <= MAX_VALUE; i++) {
		matrix[i][0] = DEFAULT;
		matrix[i][1] = DEFAULT;
		matrix[i][2] = DEFAULT;
	}
	
	for (a = 0; a <= MAX; a++) {
		for (b = 0; b <= MAX; b++) {
			for (c = 0; c <= MAX; c++) {
				k = a*a + b*b + c*c;
				if (k > 50000 || matrix[k][0] != DEFAULT) continue;
				matrix[k][0] = a;
				matrix[k][1] = b;
				matrix[k][2] = c;
			}
		}
	}
	
	scanf("%d", &n);
	
	for (i = 0; i < n; i++) {
		scanf("%d", &k);
		
		if (matrix[k][0] != DEFAULT) {
			printf("%d %d %d\n", matrix[k][0], matrix[k][1], matrix[k][2]);
		} else {
			printf("-1\n");
		}
	}
	
	return 0;
}
