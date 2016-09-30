#include "bintree.h"
#include <stdlib.h>
#include <stdio.h>

tree initialize(void) {
	tree t = (tree) malloc(sizeof(struct bintree));
	if ( t == NULL) {
		return NULL;
	}

	t->left = NULL;
	t->right = NULL;
	t->element = -1;

	return t;
}

node findMin(tree t) {
	node tmp = t;
	while (tmp->left != NULL) {
		tmp = tmp->left;
	}
	return tmp;
}

int insert(elementType e, tree t) {
	if (t == NULL) {
		return -1;
	}

	node node = (node) malloc(sizeof(struct bintree));
	if (node == NULL) {
		return -1;
	}

	node->left = node->right = NULL;
	node->element = e;

	node insertNode = t;
	node beforeNode = t;
	int flag = -1;
	while (insertNode != NULL) {
		beforeNode = insertNode;
		insertNode = e > insertNode->element ? 
							insertNode->right: insertNode->left;
		flag = e > t->element ? 1 : 0;
	}

	flag == 1 ? beforeNode->right = node : beforeNode->left = node;

	return 1;
}

tree delete(elementType e, tree t) {
	if (t->element > e) {
		// 在右侧
		t->right = delete(e, t->right);
	} else if (t->element < e) {
		// 在左侧
		t->left = delete(e, t->left);
	} else if (t->right == NULL) {
		// 左侧树上移
		node tmp = t;
		t = t->left;
		free(tmp);
	} else if (t->left == NULL) {
		//右侧树上移
		node tmp = t;
		t = t->right;
		free(tmp);
	} else {
		// 寻找右侧树最小结点
		node tmp = findMin(t->right);
		t->element = tmp->element;
		t->right = delete(tmp->element, t->right);
	}

	return t;
}

int main(void) {
	tree t = initialize();
	//printf("")
}