#include <stdio.h>
#include <math.h>

#define LENGTH 288

static double result[LENGTH];


int find(double a, int start, int end) {
    int pos = (end + start) / 2;
    if (pos == start) {
        // 答案就是end

        return a > result[start] ? end : start;
    }

    if (a - result[pos] < 0) {
        return find(a, start, pos);
    } else {
        return find(a, pos, end);
    }
}

void solve1003() {
    int i = 0;
    double sum = 0.0;
    double num = 0.0;

    for (; i < LENGTH; i++) {
        sum += 1.0 / (i + 2);
        result[i] = sum;
    }

    while (1) {
        scanf("%lf", &num);
        if (num < 0.001) {
            break;
        }

        printf ("%d card(s)\n", find(num, 0, LENGTH-1)+1);
    }
}

int main() {
    solve1003();
}

