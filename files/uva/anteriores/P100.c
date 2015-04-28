/* @BEGIN_OF_SOURCE_CODE */
/* @JUDGE_ID: 39715JC 100 C "" */

#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>

unsigned long NCiclos(unsigned long Numero) {
  unsigned long Cont = 1;

  while (Numero != 1) {
    if (Numero % 2 == 1) Numero = Numero * 3 + 1;
    else Numero = Numero / 2;
    Cont++;
  }
  return Cont;
}

int main() {
  unsigned long k, i, iAux, j, jAux,
		temp, Maior;

  while (!feof(stdin)) {
    scanf("%li %li\n", &i, &j);
    iAux = i;
    jAux = j;
    if (i > j) {
      temp = i;
      i = j;
      j = temp;
    }
    Maior = NCiclos(j);
    for (k = i; k < j; k++) {
      temp = NCiclos(k);
      if (temp > Maior) Maior = temp;
    }
    printf("%li %li %li\n", iAux, jAux, Maior);
  }

  return 0;
}
/* @END_OF_SOURCE_CODE */