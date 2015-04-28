#include <iostream>
using namespace std;

int main() {
  int bets;
  cin >> bets;
  while (bets) {
    long result = -1, acumula = 0;
    for (int i = 0, valor; i < bets; i++) {
      cin >> valor;

      acumula += valor;
      if (acumula < 0) acumula = 0;

      if (result < acumula) {
        result = acumula;
      }
    }
    if (result > 0) {
      cout << "The maximum winning streak is " << result << "." << endl;
    } else {
      cout << "Losing streak." << endl;;
    }
    cin >> bets;
  }
  return 0;
}