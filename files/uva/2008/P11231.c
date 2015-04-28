#include <stdio.h>

int main() {
	int n,m,c;

	scanf("%d %d %d", &n, &m, &c);

	while (n != 0 || m != 0 || c != 0) {
		printf("%d\n", ((n -7) * (m - 7) + c) / 2);

		scanf("%d %d %d", &n, &m, &c);
	}

	return 0;
}
