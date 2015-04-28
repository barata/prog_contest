#include <stdio.h>
#include <math.h>

int main() {
	int a, b, sa, sb;

	scanf("%d %d", &a, &b);

	while (b != 0) {
		sa = (int) ceil(sqrt(a));
		sb = (int) floor(sqrt(b));

		printf("%d\n", sb - sa + 1);

		scanf("%d %d", &a, &b);
	}

	return 0;
}
