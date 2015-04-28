#include <stdio.h>

int main() {
	int n, i, e, f, c, tot, res;

	scanf("%d", &n);

	for (i = 0; i < n; i++) {
		scanf("%d %d %d", &e, &f, &c);
		tot = e + f;
		res = 0;

		do {
			res += tot / c;
			tot = (tot / c) + (tot % c);
		} while (tot >= c);

		printf("%d\n", res);
	}

	return 0;
}
