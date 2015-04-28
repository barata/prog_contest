#include <stdio.h>

int main() {
	int i;
	long int n, exp;
	double base;

	while (scanf("%li", &n) != EOF) {

		exp = 1;
		base = 5.0;

		for (i = 1; i < n; i++) {
			base /= 2;
			if (base < 1) {
				base *= 10;
				exp++;
			}
		}

		printf("2^-%li = %.3lfe-%li\n", n, base, exp);

	}

	return 0;
}
