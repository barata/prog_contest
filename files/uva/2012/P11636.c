#include <stdio.h>
#include <math.h>

int main() {
	int n, k = 0;

	scanf("%d", &n);

	while (n > 0) {
		printf("Case %d: %.0f\n", ++k, ceil(log(n)/log(2)));

		scanf("%d", &n);
	}

	return 0;
}
