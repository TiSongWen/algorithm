/**
 * 优先队列和堆
 */
#include "heap.h"
#include <stdlib.h>


priorityQueue initialize(int maxElements) {

	priorityQueue heap = (priorityQueue) malloc(sizeof(struct heapstruct));
	if (heap == NULL) {

	}

	heap->size = 0;
	heap->capacity = CAPACITY;
	heap->elements = (elementType *) malloc(sizeof(elementType) * (heap->capacity + 1));

	return heap;
}

void insert(elementType element, priorityQueue heap) {
	int i;

	for (i = ++heap->size; heap->element[i/2] > element; i /= 2) {
		heap->elements[i] = heap->elements[i/2];
	}

	heap->elements[i] = element;
}