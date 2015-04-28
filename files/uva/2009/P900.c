#include <stdio.h>

int fib(long long arr[], int length) {
	int i;
	arr[0] = 0;
	arr[1] = 1;
	arr[2] = 2;

	for (i = 3; i < length; i++) {
		arr[i] = arr[i - 1] + arr[i - 2];
	}
}

int main() {
	int number;
	long long fibs[51];

	fib(fibs, 51);

	scanf("%d", &number);

	while (number) {
		printf("%llu\n", fibs[number]);

		scanf("%d", &number);
	}

	return 0;
}
