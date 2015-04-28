#include <stdio.h>

int main() {
	long double a, x, y, z;

	while (scanf("%Lf", &a) == 1) {
		x = 0.31514674362772045263*a*a;
		y = 4*0.1278247915835880833*a*a;
		z = 4*0.043388522509481803541*a*a;

		printf("%.3Lf %.3Lf %.3Lf\n", x, y, z);
	}

	return 0;
}
