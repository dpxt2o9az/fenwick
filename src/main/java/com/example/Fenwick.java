package com.example;

import java.util.Arrays;

public class Fenwick {

    int maxIndex;
    int[] tree;

    public Fenwick(int N) {

        this.maxIndex = N;
        this.tree = new int[N + 1];
        Arrays.fill(this.tree, 0);
        
    }

    void addFreqCounts(int[] freqCnt) {
        for (int i = 1; i <= maxIndex; i++) {
            addValue(i, freqCnt[i - 1]);
        }
    }

    void addInstances(int[] instances) {
        for (int i : instances) {
            addValue(i, 1);
        }
    }

    int getCum(int i) {
        int ix = i;
        int sum = 0;
        while (ix > 0) {
            sum += tree[ix];
            ix -= (ix & -ix);
        }
        return sum;
    }

    void addValue(int i, int v) {
        int ix = i;
        while (ix <= maxIndex) {
            tree[ix] += v;
            ix += (ix & -ix);
        }
    }

    int get(int i) {
        return getCum(i) - getCum(i - 1);
    }
    
    int getCumBetween(int idx1, int idx2) {
        return getCum(idx2) - getCum(idx1);
    }
}
