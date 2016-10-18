#include <stdio.h>
#include <string.h>


#define COL 6

static int a[1000];  // 乘数
static int b[5];     // 被乘数
static int c[1006];  // 中间值
static int n;        // n次方 (0 < n <= 25)
static int pp;       // 小数点位置

static void solve() {
    int x = 0; // 进位
    int i, j;  // 辅助
    for (j = 0; j < 5; j++) {
        for (i = 0; i < 1000; i++) {
            c[i+j] += a[i] * b[j] + x;
            x = c[i+j] / 10;
            c[i+j] %= 10;
        }
    }
}

static void transferInput(char *str) {
    int i = 0, j = 0;

    pp = 0;
    memset(a, 0, sizeof(a));

    for (i = 5; i >= 0; i--) {
        if (str[i] == ' ') {
            continue;
        } else if (str[i] == '.') {
            pp = j;
            continue;
        }
        a[j++] = str[i] - 48;
    }
    memcpy(b, a, sizeof(b));
}

static void transferOutput(int *str) {
    int pos = pp * n; // 小数点的位置
    int i, j;

    /* 跳过最高位的 0 */
    for (i = 999; i >= 0 && str[i] == 0 && i >= pos; i--) {
        continue;
    }
    /* 跳过最低位的 0 */
    for (j = 0; j < i && str[j] == 0 && j < pos; j++) {
        continue;
    }

    for (; i >= j; i--) {
        if (i == pos-1) {
            putchar('.');
        }
        printf("%d", str[i]);
    }

    puts("");
}

void entry() {
    char str[COL];
    int j;

    while(scanf("%s%d",str,&n)==2) {
        transferInput(str);
        for (j = 0; j < n-1; j++) {
            solve();
            memcpy(a, c, sizeof(a));
            memset(c, 0, sizeof(c));
        }
        transferOutput(a);
    }
}
