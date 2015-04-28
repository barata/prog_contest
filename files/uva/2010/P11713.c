#include <stdio.h>
#include <string.h>

int is_vowel(char c) {
	return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
}

int main() {
	int n, len, i, j;
	char name1[21], name2[21];

	scanf("%d", &n);

	for (i = 0;  i < n; i++) {
		scanf("%s", name1);
		scanf("%s", name2);

		if (strlen(name1) != strlen(name2)) {
			printf("No\n");
		} else {
			len = strlen(name1);
			for (j = 0; j < len; j++) {
				if (is_vowel(name1[j])) {
					name1[j] = ' ';
				}
				if (is_vowel(name2[j])) {
					name2[j] = ' ';
				}
			}
			printf("%s\n", strcmp(name1, name2) == 0 ? "Yes" : "No");
		}
	}

	return 0;
}
