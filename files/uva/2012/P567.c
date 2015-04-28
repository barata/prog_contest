#include <stdio.h>

int matrix[21][21];

int main() {
	int i, j, k, x, c = 0;

	while (scanf("%d", &x) == 1) {

		for (i = 0; i <= 20; i++)
			for (j = 0; j <= 20; j++)
				matrix[i][j] = 1000;


		for (i = 1; i <= 19; i++) {
			for (k = 0; k < x; k++) {
				scanf("%d", &j);

				matrix[i][j] = matrix[j][i] = 1;
			}

			scanf("%d", &x);
		}

		for (k = 1; k <= 20; k++)
			for (i = 1; i <= 20; i++)
				for (j = 1; j <= 20; j++)
					if (matrix[i][j] > matrix[i][k] + matrix[k][j])
						matrix[i][j] = matrix[i][k] + matrix[k][j];

		printf("Test Set #%d\n", (++c));

		for (i = 0; i < x; i++) {
			scanf("%d %d", &k, &j);

			printf("%2d to %2d: %d\n", k, j, matrix[k][j]);
		}

		printf("\n");
	}

	return 0;
}
