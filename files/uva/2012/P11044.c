#include <stdio.h>

int main() {
	int t, i, n, m;

	scanf("%d", &t);

	for (i = 0; i < t; i++) {
		scanf("%d %d", &n, &m);

		n = (n - 2) / 3 + ((n - 2) % 3 > 0);
		m = (m - 2) / 3 + ((m - 2) % 3 > 0);

		printf("%d\n", n*m);
	}

	return 0;
}
