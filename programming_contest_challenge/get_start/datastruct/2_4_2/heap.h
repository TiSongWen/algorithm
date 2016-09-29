#ifndef _HEAP_H_
#define _HEAP_H_

#define elementType int
#define CAPACITY    100


typedef struct heapstruct {
	int capacity;
	int size;
	elementType *elements;
} *priorityQueue;

priorityQueue initialize(int maxElements);

void insert(elementType element, priorityQueue heap);

elementType deleteMin(priorityQueue heap);

elementType findmin(priorityQueue heap);

#endif
