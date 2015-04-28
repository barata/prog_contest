#include <stdio.h>

int main() {
	unsigned long long n;

	scanf("%llu", &n);

	while (!feof(stdin)) {
		printf("%llu\n", 3 * (n + 1) / 2 * (n + 1) - 9);

		scanf("%llu", &n);
	}

	return 0;
}
