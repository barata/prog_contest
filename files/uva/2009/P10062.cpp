#include <iostream>
#include <string.h>
using namespace std;

int main() {
	char s[1001];
	unsigned int freq[256];
	int i, selected_freq;
	bool first = true, found;

	cin.getline(s, 1001);

	while (!cin.eof()) {
		for (i = 0; i < 256; i++) freq[i] = 9999;

		for (i = 0; i < strlen(s); i++) {
			if (freq[s[i]] == 9999) freq[s[i]] = 1;
			else freq[s[i]]++;
		}

		if (!first) cout << endl;
		else first = false;

		do {
			found = false;
			selected_freq = 0;

			for (i = 0; i < 256; i++) {
				if (freq[i] < 9999) {
					if (freq[i] < freq[selected_freq]) {
						selected_freq = i;
						found = true;
					} else if (freq[i] == freq[selected_freq]) {
						if (i > selected_freq) {
							selected_freq = i;
							found = true;
						}
					}
				}
			}
			if (found) {
				cout << selected_freq << " " << freq[selected_freq] << endl;
				freq[selected_freq] = 9999;
			}
		} while (found);


		cin.getline(s, 1001);
	}

	return 0;
}
