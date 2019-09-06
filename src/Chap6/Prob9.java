package Chap6;

public class Prob9 {
    public static void main(String[] args) {
        boolean[] open = new boolean[100];
        for (int i = 0; i < 100; i++) {
            open[i] = true;
        }
        countOpen(open);
        for (int i = 0; i < 100; i += 2) {
            open[i] = false;
        }
        countOpen(open);
        int j = 3;
        while (j <= 100) {
            for (int i = 0; i < 100; i += j) {
                open[i] = !open[i];
            }
            j++;
            countOpen(open);
        }
    }

    public static void countOpen(boolean[] open) {
        int openCount = 0;
        for (int i = 0; i < 100; i++) {
            if (open[i]) {
                openCount++;
            }
        }
        System.out.println(openCount);
    }
}
