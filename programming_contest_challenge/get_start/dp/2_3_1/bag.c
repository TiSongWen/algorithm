/**
 * 01 背包问题
 */
#include <stdio.h>

#define MAX_N 100

int rec(int, int);


int n = 0;
int a[MAX_N][2] = {0};
int W = 0;

int getMaxResult(void) {
	return rec(0, W);
}

int max(int a, int b) {
	return (a > b) ? a: b;
}

int rec(int num, int w) {
	int weight = 0;
	int value  = 0;

	if (num == n) {
		return 0;
	}

	weight = a[num][0];
	value  = a[num][1];

	if (weight > w) {
		return rec(num + 1, w);
	} else {
		return max (rec(num + 1, w - weight) + value, 
			rec(num + 1, w));
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

	printf("价值总和的最大值为: %d", getMaxResult());

	return 0;
}