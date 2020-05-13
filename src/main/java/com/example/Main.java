/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import static com.example.BinaryIndexedTree.maxValueOf;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brad
 */
public class Main {

    public static void main(String[] args) throws Exception {
        List<Integer> list = fetchData();
        int[] arr = integerListToIntArray(list);
        Fenwick f = new Fenwick(maxValueOf(arr));
        f.addInstances(arr);
        dumpFenwick(f);
    }

    private static List<Integer> fetchData() throws NumberFormatException, IOException {
        List<Integer> list = new ArrayList<>();
        try (BufferedReader r = new BufferedReader(new FileReader(new File("Wob_Valid_case2.csv")))) {
            String line;
            while ((line = r.readLine()) != null) {
                list.add((int) (Double.parseDouble(line) * 10));
            }
        }
        return list;
    }

    private static int[] integerListToIntArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private static void dumpFenwick(Fenwick f) {
        boolean foundfirstNonZeroEntry = false;
        for (int idx = 0; idx < f.tree.length; idx++) {
            if (f.get(idx) != 0 || foundfirstNonZeroEntry) {
                System.out.printf("%5.1f %5d %5d %n", (idx / 10.0), f.get(idx), f.getCum(idx));
                foundfirstNonZeroEntry = true;
            }
        }
    }
}
