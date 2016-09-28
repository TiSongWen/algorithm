/**
 * 背包问题(增加记忆化搜索)
 */

#include <stdio.h>

#define MAX_N 100
#define MAX_W 10000

int rec(int, int);

int mem[MAX_N][MAX_W] = {0}; // 增加记忆化

int n = 0;
int a[MAX_N][2] = {0};
int W = 0;

int getMaxResult(void) {
	memset(a, -1, sizeof(a));
	return rec(0, W);
}

int max(int a, int b) {
	return (a > b) ? a: b;
}

int rec(int num, int w) {
	if (num == n) {
		return (mem[num][w] = 0);
	}
	if (mem[num][w] >= 0) {
		return mem[num][w];
	}

	int weight = a[num][0];
	int value  = a[num][1];

	if (weight > w) {
		return (mem[num][w] = rec(num + 1, w));
	} else {
		return (mem[num][w] = max (rec(num + 1, w - weight) + value, 
			rec(num + 1, w)));
	} 
}

int main(void) {
	
	printf("请输入物品数: n = ");
	scanf("%d", &n);

	puts("请输入物品的重量和价值");
	for (int i = 0; i < n; i++) {
		scanf("%d %d", &(a[i][0]), &(a[i][1]));
	}

	printf("请输入最大中重量: W =");
	scanf("%d", &W);

	printf("价值总和的最大值为: %d \n", getMaxResult());

	return 0;
}