#include <stdio.h>

#ifndef max
	#define max( a, b ) ( ((a) > (b)) ? (a) : (b) )
#endif

#ifndef min
	#define min( a, b ) ( ((a) < (b)) ? (a) : (b) )
#endif

int main() {
	int t, k, a, b, c;

	scanf("%d", &t);

	for (k = 1; k <= t; k++) {
		scanf("%d %d %d", &a, &b, &c);

		printf("Case %d: %d\n", k, (a+b+c)-max(a,max(b,c))-min(a,min(b,c)));
	}

	return 0;
}
