#include <stdio.h>

#define MAX_VALUE 1000000

int somaDigitos(long numero) {
	int resultado = 0;
	
	while (numero != 0) {
		resultado += numero % 10;
		numero /= 10;
	}
	
	return resultado;
}

int main() {

	int nTestes;
	int i, j, cont;
	long t1, t2;
	int digitPrimes[MAX_VALUE];
	int primes[MAX_VALUE];
	
	/* inicializa */
	for (i = 0; i < MAX_VALUE; i++) {
		primes[i] = 0;
	}
	
	primes[2] = 1;
	primes[3] = 1;

	for (i = 5; i < MAX_VALUE; i += 2) {
		for (j = 3; j * j <= i; j += 2)
			if (i % j == 0)
				break;
		if (i % j != 0)
			primes[i] = 1;
	}
	
	cont = 0;
	
	for (i = 1; i < MAX_VALUE; i++) {
		if (primes[i] && primes[somaDigitos(i)]) cont++;
		digitPrimes[i] = cont;
	}

	/* processa */	
	scanf("%d", &nTestes);

	for (i = 0; i < nTestes; i++) {
	
		scanf("%li", &t1);
		scanf("%li", &t2);
		
		printf("%d\n", digitPrimes[t2] - digitPrimes[t1 - 1]);
	
	}


}
