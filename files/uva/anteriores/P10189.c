/* @BEGIN_OF_SOURCE_CODE */
/* @JUDGE_ID: 39715JC 10189 C "" */

#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>

int main() {
  int m, n, n_teste = 0;
  char mapa[101][101];

  scanf("%d %d\n", &m, &n);

  while (m != 0 && n != 0) {
    int L, C;

    for (L = 0; L < m; L++)
      gets(mapa[L]);

    for (L = 0; L < m; L++)
      for (C = 0; C < n; C++) {
	char cont = '0';
	if (mapa[L][C] == '.') {
	  if (L > 0 && C > 0)
	    if (mapa[L - 1][C - 1] == '*') cont++;
	  if (L > 0)
	    if (mapa[L - 1][C] == '*') cont++;
	  if (L > 0 && C < n - 1)
	    if (mapa[L - 1][C + 1] == '*') cont++;
	  if (C < n - 1)
	    if (mapa[L][C + 1] == '*') cont++;
	  if (L < m - 1 && C < n - 1)
	    if (mapa[L + 1][C + 1] == '*') cont++;
	  if (L < m - 1)
	    if (mapa[L + 1][C] == '*') cont++;
	  if (L < m - 1 && C > 0)
	    if (mapa[L + 1][C - 1] == '*') cont++;
	  if (C > 0)
	    if (mapa[L][C - 1] == '*') cont++;
	  mapa[L][C] = cont;
	}
      }

    n_teste++;
    printf("Field #%d:\n", n_teste);

    for (L = 0; L < m; L++) {
      for (C = 0; C < n; C++)
	printf("%c", mapa[L][C]);
      printf("\n");
    }

    scanf("%d %d\n", &m, &n);

    if (m != 0 && n != 0) printf("\n");
  }
  return 0;
}
/* @END_OF_SOURCE_CODE */