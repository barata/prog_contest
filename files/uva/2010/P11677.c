#include <stdio.h>

int get_minutes(int h, int m) {
	return m + h * 60;
}

int main() {
	int h1, m1, h2, m2;
	int t_m1, t_m2;

	scanf("%d %d %d %d", &h1, &m1, &h2, &m2);

	while (h1 != 0 || m1 != 0 || h2 != 0 || m2 != 0) {
		t_m1 = get_minutes(h1, m1);
		t_m2 = get_minutes(h2, m2);

		if (t_m2 > t_m1) printf("%d\n", t_m2 - t_m1);
		else printf("%d\n", (get_minutes(24, 0) - t_m1) + t_m2);

		scanf("%d %d %d %d", &h1, &m1, &h2, &m2);
	}


	return 0;
}
