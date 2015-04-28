#include <stdio.h>
#include <math.h>

#define EPS 1e-7

double min(double d1, double d2) {
	return d1 < d2 ? d1 : d2;
}

int main() {
	double l, w, x1, x2, v1, v2, aux;

	while (scanf("%lf %lf", &l, &w) == 2) {
		x1 = 1.0/6 * (-sqrt(l*l - l*w + w*w) + l + w);
		x2 = 1.0/6 * (sqrt(l*l - l*w + w*w) + l + w);

		v1 = (w - 2*x1) * (l - 2*x1) * x1;
		v2 = (w - 2*x2) * (l - 2*x2) * x2;

		if (v1 < v2) {
			aux = x1;
			x1 = x2;
			x2 = aux;
		}

		printf("%.3lf 0.000 %.3lf\n", x1+EPS, min(w,l)/2.0+EPS);
	}

	return 0;
}
