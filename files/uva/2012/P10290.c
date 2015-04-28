#include <stdio.h>
#include <string.h>
#include <math.h>

#define I_MAX 3000001
#define SQRT 5478

char sieve[I_MAX];
int primes[216815];

int main() {
	unsigned long long n;
	unsigned int i, j, pc = 0, count, r;

	memset(sieve, 1, I_MAX);
	for(i = 3; i < SQRT; i += 2)
		if (sieve[i])
			for (primes[pc++] = i, j = i*i; j < I_MAX; j += i)
				sieve[j] = 0;
	for (i = SQRT+1; i < I_MAX; i += 2)
		if (sieve[i]) primes[pc++] = i;

	while (scanf("%llu", &n) == 1) {
		r = 1;
		if (n) while(!(n & 1)) n >>= 1;

		if (n) for (i = 0; i < pc; i++)
			if (!(n % primes[i])) {
				count = 0;

				do {
					n /= primes[i];
					count++;
				} while (!(n % primes[i]));
				r *= (count + 1);

				if (n == 1 || (n < I_MAX && sieve[n])) break;
			}

		if (n > 1)  r <<= 1;

		printf("%u\n", r);
	}

	return 0;
}
