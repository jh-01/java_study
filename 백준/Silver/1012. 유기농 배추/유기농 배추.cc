#include <iostream>
#include <cstring>
#define MAX 51

using namespace std;

int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, 1, -1};
bool c[MAX][MAX];
int T, M, N, K;
int cabbage[MAX][MAX];

void dfs(int x, int y){
	c[x][y] = true;
	for(int i = 0; i < 4; i++){
		int nx = x + dx[i];
		int ny = y + dy[i];
		if(nx >= 0 && nx < M && ny >= 0 && ny < N){
			if(cabbage[nx][ny] == 1) {
				if(!c[nx][ny]) dfs(nx, ny);
			}
		}
		else continue;
	}
}

int main() {
	scanf("%d", &T);
	while(T--){
		int count = 0;
		scanf("%d %d %d", &M, &N, &K);
		for(int i = 0; i < K; i++){
			int a, b;
			scanf("%d %d", &a, &b);
			cabbage[a][b] = 1;
		}
		for(int i = 0; i < M; i++){
			for(int j = 0; j < N; j++){
				if(cabbage[i][j] == 1 && !c[i][j]){
					count++;
					dfs(i, j);
				}
					
			}
		}
		printf("%d\n", count);
		memset(c, false, sizeof(c));
		memset(cabbage, 0, sizeof(cabbage));
	}
	return 0;
}