/*
  BIT/bitree - Binary Indexed Tree
  MaxIdx - maximum index which will have non-zero frequency
  f[i] - frequency at index i, i = 1 … MaxIdx
  c[i] - cumulative frequency at index i (f[1] + f[2] + … + f[i])
  tree[i] - the sum of frequencies stored at index i of BIT (latter we will describe which frequencies correspond to i); 
            we will be using “tree frequency” to refer to “sum of frequencies stored at an index of BIT”
  num¯ - complement of integer num (integer where each binary digit is inverted: 0 -> 1; 1 -> 0 )

NOTE: We set f[0] = 0, c[0] = 0, tree[0] = 0, so sometimes we will ignore index 0.



 */
package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Brad
 */
public class BinaryIndexedTree {

    static int[] tree;
    static int n = 0;
    static int maxIdx;

    static int maxValueOf(int[] arr) {
        int maxValue = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > maxValue) {
                maxValue = i;
            }
        }
        return maxValue;
    }

    static void constructBITreeFrom(int size, int arr[]) {
        maxIdx = maxValueOf(arr) + 1;
        tree = new int[maxIdx];

        // Initialize BITree[] as 0 
        Arrays.fill(tree, 0);

        // Store the actual values in BITree[] 
        // using update() 
        for (int i = 0; i < arr.length; i++) {
            update(arr[i], 1);
        }
    }

    static int readSingle(int idx) {
        int sum = tree[idx];
        if (idx > 0) { // the special case
            int z = idx - (idx & -idx);
            idx--;
            while (idx != z) {
                sum -= tree[idx];
                idx -= (idx & -idx);
            }
        }
        return sum;
    }

    static int read(int idx) {
        int sum = 0;
        while (idx > 0) {
            sum += tree[idx];
            idx -= (idx & -idx);
        }
        return sum;
    }

    static void update(int idx, int val) {
        while (idx <= tree.length) {
            tree[idx] += val;
            idx += (idx & -idx);
        }
    }

    static void scale(int c) {
        for (int i = 1; i < tree.length; i++) {
            tree[i] = tree[i] / c;
        }
    }

//    static int find(int cumFre) {
//        int idx = 0;
//        while(bitMask!=0 ){
//            int tIdx = idx+bitMask;
//            bitMask >>= 1;
//            if (tIdx > maxIdx) {
//                
//            }
//        }
//    }
}
