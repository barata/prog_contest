#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>

#define MAX_CHAR 256
#define MAX_LINHA 800

void zeraArrayInt(int array[], int size) {
	int i;
	for (i = 0; i < size; i++) {
		array[i] = 0;
	}
}

void zeraArrayChar(char array[], int size) {
	int i;
	for (i = 0; i < size; i++) {
		array[i] = 0;
	}
}

void ordenaArray(char array[], int freq[], int size) {
	int i, j;
	for (i = 1; i < size; i++) {
		for (j = size -1; j >= i; j--) {

			if (freq[array[j]] > freq[array[j - 1]]) {
				char aux = array[j];
				array[j] = array[j - 1];
				array[j - 1] = aux;
			} else if (freq[array[j]] == freq[array[j - 1]]) {
				if (array[j] < array[j - 1]) {
					char aux = array[j];
					array[j] = array[j - 1];
					array[j - 1] = aux;
				}
			}

		}
	}
}

int main() {

	int i, cont1, cont2;

	char conversor[MAX_CHAR];

	int knownFreq[MAX_CHAR];
	int encodedFreq[MAX_CHAR];

	char knownOrdem[MAX_CHAR];
	char encodedOrdem[MAX_CHAR];

	char linha[MAX_LINHA];

	char *texto[400000];
	int nLinhas;

	zeraArrayChar(conversor,MAX_CHAR);

	zeraArrayInt(knownFreq, MAX_CHAR);
	zeraArrayInt(encodedFreq, MAX_CHAR);

	zeraArrayChar(knownOrdem, MAX_CHAR);
	zeraArrayChar(encodedOrdem, MAX_CHAR);

	/* calcula as frequencias do texto conhecido */
	cont1 = 0;
	while (strlen(gets(linha))) {
		for (i = 0; i < strlen(linha); i++) {
			char ch = linha[i];
			if (ch < 'a') ch = ch + 32;
			if (ch >= 'a' && ch <= 'z') {
				if (knownFreq[ch] == 0) {
					knownOrdem[cont1++] = ch;
				}
				knownFreq[ch]++;
			}
		}

	}

	/* calcula as frequencias do texto codificado */
	cont2 = 0;
	nLinhas = 0;
	while (gets(linha) != NULL) {
		texto[nLinhas] = (char *) malloc(MAX_LINHA);
		strcpy(texto[nLinhas++], linha);

		for (i = 0; i < strlen(linha); i++) {
			char ch = linha[i];
			if (ch < 'a') ch = ch + 32;
			if (ch >= 'a' && ch <= 'z') {
				if (encodedFreq[ch] == 0) {
					encodedOrdem[cont2++] = ch;
				}
				encodedFreq[ch]++;
			}
		}

	}

	/* ordena arrays */
	ordenaArray(knownOrdem, knownFreq, cont1);
	ordenaArray(encodedOrdem, encodedFreq, cont2);

	/* faz mapeamento */
	for (i = 0; i < (cont1 > cont2 ? cont1 : cont2); i++) {
		conversor[(char)encodedOrdem[i]] = knownOrdem[i];
	}

	/* processa texto */
	for (i = 0; i < nLinhas; i++) {
		char *aux = texto[i];
		int j;
		for (j = 0; j < strlen(aux); j++) {
			char ch = aux[j];
			if (aux[j] >= 'A' && aux[j] <= 'Z') ch += 32;
			if (conversor[ch] > 0) {
				if (aux[j] >= 'a' && aux[j] <= 'z') {
					aux[j] = conversor[aux[j]];
				} else if (aux[j] >= 'A' && aux[j] <= 'Z') {
					aux[j] = conversor[ch] - 32;
				}
			}
		}

		printf("%s\n", aux);
	}

}
