/**
 * 解题思路：经过了一个站，对于选择加油的权利是自由的
 *（可以选择加油，也可以选择不加油）
 */

#include <stdlib.h>
#include <stdio.h>

#define MAX_N 10000

void inHeap(int);
int  outHeap(void);


int N = 0; // 加油站数量
int L = 0; // 要行驶的长度
int P = 0; // 初始化的汽油数(L)
int A[MAX_N] = {0};
int B[MAX_N] = {0};

int heap[MAX_N + 1]; // 最大堆（0 元素并不使用）
int size = 0;

int solve() {
	int sum = 0;
	int x   = -1;

	for (int i = 0; i < N;) {
		if (P >= A[i]) {
			inHeap(A[i++]);// 入堆
		} else if (P < A[i]) {
			if ( (x = outHeap()) == -1) {
				return -1;
			}
			P += x;
			sum++;
		}
	}

	return sum;
}

/* 入队 */
void inHeap(int x) {
	int i;

	for (i = ++size; heap[i/2] < x; i /= 2) {
		heap[i] = heap[i/2];
	}

	heap[i] = x;
}

/* 出队(返回最大值) */
int outHeap(void) {
	if (size == 0) {
		return -1;
	}

	int i = 1;
	while (i <= size) {
		int x = heap[i*2] > heap[i*2+1] ? i*2 : i*2+1;
		
		heap[i] = heap[x];

		i = x;
	}
	
	size--;

	return heap[i/2];
}

int main(void) {
	printf("请输入加油站的数量 N =  ");
	scanf("%d", &N);

	printf("请输入行驶的距离 L = ");
	scanf("%d", &L);

	printf("请输入起始时汽油量(L) P = ");
	scanf("%d", &P);

	printf("请输入加油站的距离: ");
	for (int i = 0; i < N; i++) {
		scanf("%d", A + i);
	}
	printf("请输入加油站加油量: ");
	for (int i = 0; i < N; i++) {
		scanf("%d", B + i);
	}

	printf("最少加油次数: %d\n", solve());

	return 0;
}
