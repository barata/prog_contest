#include <stdio.h>
#include <math.h>

int main() {
	unsigned long n, m, i;
	unsigned long max, min;

	long double r;

	scanf("%lu %lu", &n, &m);

	while (n != 0 || m != 0) {

		r = 1;

		max = (m > n - m ? m : n - m);
		min = (m < n - m ? m : n - m);

		for (i = min; i > 1; i--) r /= i;
		for (i = n; i > max; i--) r *= i;



		printf("%d things taken %d at a time is %.0f exactly.\n", n, m, fabs(r));


		scanf("%lu %lu", &n, &m);
	}


	return 0;
}
