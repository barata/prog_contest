#include <stdio.h>

int main() {
	int t, i;
	long a, b;

	scanf("%d", &t);

	for (i = 0; i < t; i++) {
		scanf("%d %d", &a, &b);

		printf("%s\n", a < b ? "<" : (a > b ? ">" : "="));
	}

	return 0;
}
