#include <stdio.h>

void calculate(int a, int b) {
	int ini = a / b;
	int next_a, next_b;

	next_a = b;
	next_b = a - b * ini;

	if (a > 1 && b == 1) {
		printf("%d]\n", ini);
	} else {
		printf("%d,", ini);
		calculate(next_a, next_b);
	}
}

int main() {
	int a, b;

	scanf("%d %d", &a, &b);

	while (!feof(stdin)) {
		printf("[%d;", a / b);
		calculate(b, a - b * (a/b));

		scanf("%d %d", &a, &b);
	}

	return 0;
}
