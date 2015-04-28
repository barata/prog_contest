#include <stdio.h>
#include <string.h>

char conflito(char a, char b) {
	char tmp;

	if (a == '#' && b == '#') return '#';
	if (a == '#') return b;
	if (b == '#') return a;
	if (a == b) return a;
	
	if (a > b) {
		tmp = a;
		a = b;
		b = tmp;
	}
	
	if (a == 'R' && b == 'S') return 'R';
	if (a == 'P' && b == 'S') return 'S';
	if (a == 'P' && b == 'R') return 'P';
	
	return '!';
}

int main() {

	char** array;
	char** aux;

	int g, k, i, j;
	int nTestes;

	char corrente, prox;

	int nLinhas, nColunas, nDias;

	scanf("%d", &nTestes);

	for (g = 0; g < nTestes; g++) {

		scanf("%d %d %d", &nLinhas, &nColunas, &nDias);
		getchar();

		array = (char**) malloc((nLinhas + 1) * sizeof(char*));
		aux = (char**) malloc((nLinhas + 1) * sizeof(char*));
		for (i = 0; i < nLinhas; i++) {
			array[i] = (char*) malloc((nColunas + 1) * sizeof(char));
			aux[i] = (char*) malloc((nColunas + 1) * sizeof(char));
		}

		for (i = 0; i < nLinhas; i++) {
			gets(array[i]);
		}

		for (k = 0; k < nDias; k++) {

			for (i = 0; i < nLinhas; i++) {
				for (j = 0; j < nColunas; j++) {

					corrente = array[i][j];

					if (j > 0) corrente = conflito(array[i][j], array[i][j - 1]);
				
					if (i > 0) prox = conflito(array[i][j], array[i - 1][j]);
					else prox = '#';
					corrente = conflito(corrente, prox);
				
					if (j < nColunas - 1) prox = conflito(array[i][j], array[i][j + 1]);
					else prox = '#';
					corrente = conflito(corrente, prox);
				
					if (i < nLinhas - 1) prox = conflito(array[i][j], array[i + 1][j]);
					else prox = '#';
					corrente = conflito(corrente, prox);
				
					aux[i][j] = corrente;

				}
			}

			for (i = 0; i < nLinhas; i++) {
				strcpy(array[i], aux[i]);
			}



		}


		for (i = 0; i < nLinhas; i++) {
			puts(array[i]);
		}
		if (g < nTestes - 1) printf("\n");


	}




	return 0;
}
