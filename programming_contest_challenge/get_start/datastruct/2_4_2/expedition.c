/**
 *
 * 解题思路：经过了一个站，对于选择加油的权利是自由的
 *（可以选择加油，也可以选择不加油）
 */

#include <stdlib.h>

#define MAX_N 10000
int N = 0; // 加油站数量
int L = 0; // 要行驶的长度
int P = 0; // 初始化的汽油数(L)

int heap[MAX_N + 1]; // 最大堆（0 元素并不使用）
int size = 0;

int solve() {

	for (int i = 0; i < N;) {
		if (P >= A[i]) {
			// 入堆
		} else if (P < A[i]) {
			P += ;// 出队
		}
	}
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
int outHeap() {
	int i;
	for (i = 1; i <= size;) {
		if (heap[i*2] > heap[i*2+1]){
			heap[i] = heap[i*2];
			i = i*2;
		} else {
			heap[i] = heap[i*2+1];
			i = i * 2 + 1;
		}
	}
	
	size--;

	return heap[i/2];
}
