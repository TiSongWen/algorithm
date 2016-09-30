#ifndef _BINTREE_H_
#define _BINTREE_H_

#define elementType int

typedef struct bintree {
	elementType element;
	node left;
	node right;
} *node, *tree;

tree initialize(void);
void insert(elementType e, tree t);
node find(elementType e, tree t);
node findMin(tree t);
node findMax(tree t);


#endif