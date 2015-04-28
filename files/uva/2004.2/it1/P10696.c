#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>

long processa(long numero) {
	if (numero > 100) return numero - 10;
	return processa(processa(numero + 11));
}

main() {

	long numero;

	scanf("%ld", &numero);
	while (numero != 0) {
		printf("f91(%ld) = %ld\n", numero, processa(numero));
		scanf("%ld", &numero);
	}
}
