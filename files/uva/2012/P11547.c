#include <stdio.h>

int main() {
	int t, i, n;

	scanf("%d", &t);

	for (i = 0; i < t; i++) {
		scanf("%d", &n);

		n = ((5*(63*n+7492)-498) % 100) / 10;
		printf("%d\n", n < 0 ? -n : n);
	}

	return 0;
}
