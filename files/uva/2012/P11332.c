#include <stdio.h>

int main() {
	unsigned long long n, sum;

	scanf("%llu", &n);

	while (n != 0) {
		while (n > 9) {
			sum = 0;
			while (n > 0) {
				sum += n % 10;
				n /= 10;
			}
			n = sum;	
		}

		printf("%llu\n", n);
			

		scanf("%llu", &n);
	}

	return 0;
}
