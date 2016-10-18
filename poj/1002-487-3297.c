#include <stdio.h>
#include <string.h>

#define ROW 8
#define COL 26
#define LENGTH 300
#define MAX 100000

static int map[COL] = {2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6,
                        7, 0, 7, 7, 8, 8 ,8, 9, 9, 9, 0};

static char num[MAX][LENGTH];
static int  n;

static int repeat[MAX];

int main(void) {
    char s[LENGTH];
    int i = 0, j = 0, z = 0;
    int flag = 0;

    scanf("%d", &n);
    getchar();
    for (i = 0; i < n; i++) {
        gets(s);
        for (j = 0, z = 0; s[j] != '\0'; j++) {
            if(z == 3) {
                num[i][z++] = '-';
            }
            if (s[j] == '-') {
                continue;
            } else if (s[j] >= 'A' && s[j] <= 'Z') {
                num[i][z++] = map[s[j]-65] + 48;
            } else if (s[j] >= '0' && s[j] <= '9') {
                num[i][z++] = s[j];
            }
        }
    }

    qsort(num, n, sizeof(char)*LENGTH, strcmp);

    for (i = 0; i < n-1; i++) {
        if (strcmp(num[i], num[i+1]) == 0) {
            j = i++;
            repeat[j]++;
            for (; strcmp(num[i], num[i+1]) == 0 && i < n-1; i++) {
                repeat[j]++;
            }
        }
    }

    for (i = 0; i < n; i++) {
        if (repeat[i] > 0) {
            flag = 1;
            printf("%s %d\n", num[i], repeat[i]+1);
        }
    }

    if (!flag) {
        puts("No duplicates.");
    }

    return 0;
}
