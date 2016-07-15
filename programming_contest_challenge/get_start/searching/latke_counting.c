/* Lake Counting
 *
 * Descriptions
 *
 * Due to recent rains, water has pooled in various places in Farmer's field, 
 * which is represented by a rectangle of N * M squares. Each square contains
 * either water('W') or dry land('.'). Farmer would like to figure out how 
 * many ponds have formed in his field. A pond is a connected set of squares 
 * with water in them, where a square is considered ajjacent to all eight of
 * its neighbors
 * 
 * Input
 *
 * Line 1: Tow space-separated integers: N and M
 * Line 2: N+1:M characters per line representing one row of Farmer's field.
 *         Each character is either 'W' or '.'. The characters do not have 
 *         spaces between them.
 *
 * Output
 * 
 * Line 1: The number of ponds in Farmer's field
 *
 * Sample Input
 *
 * 10 12
 * W........WW.
 * .WWW.....WWW
 * ....WW...WW.
 * .........WW.
 * .........W..
 * ..W......W..
 * .W.W.....WW.
 * W.W.W.....W.
 * .W.W......W.
 * ..W.......W.
 * 
 * Sample Output
 * 
 * 3
 *
 */

#include <stdio.h>

#define MAX_M 100
#define MAX_N 100

int m, n;
char a[MAX_M][MAX_N+1];

void dfs(int x, int y)
{
	a[x][y] = '.';

	for (int dx = -1; dx <= 1; dx++) {
		for (int dy = -1; dy <= 1; dy++) {
			if ( (x+dx) > -1 && (x+dx) < m &&
				 (y+dy) > -1 && (y+dy) < n &&
				 a[x+dx][y+dy] == 'W') {
				dfs(x+dx, y+dy);
			}
		}
    }
}

void solve()
{	
	int sum = 0;

	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			if (a[i][j] == 'W') {
				dfs(i, j);
				sum++;
			}
		}
	}

	printf ("%d\n", sum);
}