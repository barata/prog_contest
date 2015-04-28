#include <stdio.h>
#include <math.h>

int main() {
	int n, g;
	double d, v, u, a, t1, t2;

	scanf("%d", &n);

	for (g = 1; g <= n; g++) {
		scanf("%lf %lf %lf", &d, &v, &u);

		if (v == 0.0 || u == 0.0 || u <= v) printf("Case %d: can't determine\n", g);
		else {
			a = acos(v/u);
			t1 = d / (v * tan(a));
			t2 = d / u;
			printf("Case %d: %.3lf\n", g, t1-t2);
		}
	}

	return 0;
}
