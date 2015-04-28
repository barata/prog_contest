#include <iostream>
#include <queue>
using namespace std;

int main()
{
	int n, k;
	int value;

	cin >> n;

	while (n != 0) {
		priority_queue< int, vector< int >, greater< int > > q;
		int total = 0;

		for (k = 0; k < n; k++) {
			cin >> value;
			q.push(value);
		}

		for (k = 1; k < n; k++) {
			int p1 = q.top(); q.pop();
			int p2 = q.top(); q.pop();

			q.push(p1 + p2);

			total += p1 + p2;
		}

		cout << total << endl;

		cin >> n;
	}
}
