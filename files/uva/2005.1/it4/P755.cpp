#include <stdio.h>
#include <map>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

long int normaliza(char* s) {
	long int resultado = 0;

	char* p;

    for (p = s; *p != '\0'; ++p) {
		if (*p >= '0' && *p <= '9') {
			resultado = resultado * 10 + (*p - '0');
		} else if (*p >= 'A' && *p <= 'Z') {
			if (*p >= 'A' && *p <= 'C') resultado = resultado * 10 + 2;
			else if (*p >= 'D' && *p <= 'F') resultado = resultado * 10 + 3;
			else if (*p >= 'G' && *p <= 'I') resultado = resultado * 10 + 4;
			else if (*p >= 'J' && *p <= 'L') resultado = resultado * 10 + 5;
			else if (*p >= 'M' && *p <= 'O') resultado = resultado * 10 + 6;
			else if (*p >= 'P' && *p <= 'S') resultado = resultado * 10 + 7;
			else if (*p >= 'T' && *p <= 'V') resultado = resultado * 10 + 8;
			else if (*p >= 'W' && *p <= 'Y') resultado = resultado * 10 + 9;
		}
	}

	return resultado;
}

typedef map<long int,int> IntIntMap;

int main() {
	long int nTestes, total;
	long int i, j;
	long int resultado;
	
	IntIntMap mapa;
	vector<long int> resp;
	
	char linha[100];
	
	scanf("%li", &nTestes);
	
	for (i = 0; i < nTestes; i++) {
		scanf("%li", &total);
		
		mapa.clear();
		resp.clear();
		
		for (j = 0; j < total; j++) {
			scanf("%s", &linha);
			
			resultado = normaliza(linha);
			mapa[resultado]++;
			
			if (mapa[resultado] == 2) resp.push_back(resultado);
		}
		
		sort(resp.begin(), resp.end());
		
		if (resp.size() == 0) {
			printf("No duplicates.\n");
		} else {
			for (j = 0; j < resp.size(); j++) {
				printf("%.3li-%.4li %li\n", resp[j] / 10000, resp[j] % 10000, mapa[resp[j]]);
			}
		}
		
		if (i < nTestes - 1) printf("\n");
	}
	
	
	
	
	return 0;
}
