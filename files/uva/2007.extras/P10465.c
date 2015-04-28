#include <stdio.h>

int main() {
	int m, n, t;
	int i;
	int array[10001][2];

	while (scanf("%d %d %d", &m, &n, &t) == 3) {

		for (i = 0; i <= t; i++) {
			array[i][0] = 0;
			array[i][1] = 0;
		}

		for (i = m; i <= t; i++) {
			array[i][0] = array[i - m][0] + 1;
		}

		for (i = n; i <= t; i++) {
			if (array[i - n][0] * m + (array[i - n][1] + 1) * n > array[i][0] * m + array[i][1] * n) {
				array[i][0] = array[i - n][0];
				array[i][1] = array[i - n][1] + 1;
			} else if (array[i - n][0] * m + (array[i - n][1] + 1) * n == array[i][0] * m + array[i][1] * n) {
				if (array[i - n][0] + array[i - n][1] + 1 > array[i][0] + array[i][1]) {
					array[i][0] = array[i - n][0];
					array[i][1] = array[i - n][1] + 1;
				}
			}
		}

		printf("%d", array[t][0] + array[t][1]);
		if (t - (array[t][0] * m + array[t][1] * n) > 0) {
			printf(" %d", t - (array[t][0] * m + array[t][1] * n));
		}
		printf("\n");
	}

	return 0;
}
