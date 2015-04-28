#include <stdio.h>

int main() {
	int n, i;
	unsigned long long table[1000001], inc = 0;

	table[3] = 0;

	for (i = 4; i <= 1000000; i++) {
		inc += (i >> 1) - 1;
		table[i] = table[i - 1] + inc;
	}

	scanf("%d", &n);

	while (n >= 3) {
		printf("%llu\n", table[n]);

		scanf("%d", &n);
	}

	return 0;
}
