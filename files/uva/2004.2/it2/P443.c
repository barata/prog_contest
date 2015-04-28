#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>

#define MAX 5842

long min(unsigned long n1, unsigned long n2, unsigned long n3, unsigned long n4) {

	long temp[4], min;
	int i;

	temp[0] = n1;
	temp[1] = n2;
	temp[2] = n3;
	temp[3] = n4;
	min = temp[0];
	
	for (i = 1; i < 4; i++) {
		if (temp[i] < min) min = temp[i];
	}

	return min;
}

int main() {

	unsigned long numero, aux;
	unsigned long humble[MAX + 1];

	unsigned long indice2, indice3, indice5, indice7;
	unsigned long parte2, parte3, parte5, parte7;

	indice2 = indice3 = indice5 = indice7 = 0;
	parte2 = parte3 = parte5 = parte7 = 1;

	humble[1] = 1;

	for (numero = 2; numero <= MAX; numero++) {

		aux = humble[numero - 1] + 1;
		while ((parte2 = 2 * humble[indice2]) < aux) indice2++;
		while ((parte3 = 3 * humble[indice3]) < aux) indice3++;
		while ((parte5 = 5 * humble[indice5]) < aux) indice5++;
		while ((parte7 = 7 * humble[indice7]) < aux) indice7++;
		humble[numero] = min(parte2, parte3, parte5, parte7);

	}

	while (scanf("%ld", &numero)) {
		if (numero == 0) break;

		if (numero % 100 / 10 == 1) printf("The %ldth humble number is %ld.\n", numero, humble[numero]);
		else if (numero % 10 == 1) printf("The %ldst humble number is %ld.\n", numero, humble[numero]);
		else if (numero % 10 == 2) printf("The %ldnd humble number is %ld.\n", numero, humble[numero]);
		else if (numero % 10 == 3) printf("The %ldrd humble number is %ld.\n", numero, humble[numero]);
		else printf("The %ldth humble number is %ld.\n", numero, humble[numero]);
	}

}
