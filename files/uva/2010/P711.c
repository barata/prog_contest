#include <stdio.h>
#include <string.h>

#define SIZE 60001

int main() {
	int i, j, k, sum;
	int x[6];
	int testcase = 0;
	int array[SIZE];
	int prev_item, prev_qnt;

	scanf("%d %d %d %d %d %d", &x[0], &x[1], &x[2], &x[3], &x[4], &x[5]);
	sum = 1*x[0] + 2*x[1] + 3*x[2] + 4*x[3] + 5*x[4] + 6*x[5];

	while (sum != 0) {

		printf("Collection #%d:\n", ++testcase);

		if (sum % 2 == 0) {
			memset(array, 0, SIZE * sizeof(int));

			for (i = 0; i < 6 && !array[sum>>1]; i++) {
				if (!x[i]) continue;
				array[0] = i + 1;
				for (k = i + 1; k <= (sum>>1); k++) {
					if (!array[k] && array[k - (i + 1)] > 0) {
						prev_item = array[k - (i + 1)] % 10;
						prev_qnt = array[k - (i + 1)] / 10;

						if (prev_item != i + 1) array[k] = 10 + (i + 1);
						else if (prev_qnt < x[i]) array[k] = (prev_qnt + 1) * 10 + prev_item;
					}
				}
			}

			if (array[sum>>1]) {
				printf("Can be divided.");
			} else {
				printf("Can't be divided.");
			}
		} else {
			printf("Can't be divided.");
		}

		printf("\n\n");

		scanf("%d %d %d %d %d %d", &x[0], &x[1], &x[2], &x[3], &x[4], &x[5]);
		sum = 1*x[0] + 2*x[1] + 3*x[2] + 4*x[3] + 5*x[4] + 6*x[5];
	}



	return 0;
}
