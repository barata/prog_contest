#include <stdio.h>

int main() {
	int i, j, nTestes, tamanho, op1, op2, carry;
	int soma[1000001];

	scanf("%d", &nTestes);
	
	for (i = 0; i < nTestes; i++) {

		scanf("%d", &tamanho);

		for (j = 0; j < tamanho; j++) {
			scanf("%d %d", &op1, &op2);
			
			soma[j] = op1 + op2;
		}

		carry = 0;
		for (j = tamanho - 1; j >= 0; j--) {
			int op = soma[j];

			soma[j] = (op + carry) % 10;
			carry = (op + carry) / 10;
		}

		for (j = 0; j < tamanho; j++) {
			printf("%d", soma[j]);
		}
		printf("\n");

		if (i < nTestes - 1) printf("\n");

	}

	return 0;
}
