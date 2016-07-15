/* DFS 深度优先搜索
 * 
 * 部分和问题
 * 给定整数 a1,a2, ... an, 判断是否可以从中选出若干数, 使得他们的和恰好为k
 * 
 * 限制条件
 *     1 <= n <= 20
 *     -10^8 <= ai <= 10^8
 *     -10^8 <= k  <= 10^8
 *
 * 样例输入
 *     n = 4
 *     a = {1, 2, 4, 7}
 *     k = 13
 * 样例输出
 *     Yes
 * 
 * 样例输入
 *     n = 4
 *     a = {1, 2, 4, 7}
 *     k = 15
 * 样例输出
 *     No
 */
#include <stdio.h>

#define MAX_N 20

int a[MAX_N];
int n = 0;       // 数组的长度
int k = 0;       // 部分和

int dfs (int i, int sum)
{
    if (sum == k && i != 0) // 避免出现 sum = 0, k = 0 没有计算直接返回的情况
    	return 1;

    if (i == n)
    	return 0;
    
    if ( dfs (i+1, sum+a[i]) )
    	return 1;

    if ( dfs (i+1, sum) )
    	return 1;

    return 0;
}

void solve () 
{
	if ( dfs(0, 0) )
		puts ("Yes");
	else
		puts ("No");
}

int main(void)
{

	scanf ("%d", &n);

	if (n > MAX_N)
		puts ("No");

	for (int i = 0; i < n; i++) {
		scanf ("%d", a+i);
	}

	scanf ("%d", &k);

	solve();

	return 0;
}


