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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brad
 */
public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedReader r = new BufferedReader(new FileReader(new File("Wob_Valid_case2.csv")))) {
            String line;
            List<Integer> list = new ArrayList<>();
            while ((line = r.readLine()) != null) {
                list.add((int) (Double.parseDouble(line) * 10));
            }
            int[] arr = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                arr[i] = list.get(i);
            }
            Fenwick f = new Fenwick(maxValueOf(arr));
            f.addInstances(arr);
            boolean foundfirstNonZeroEntry = false;
            for (int idx = 0; idx < f.tree.length; idx++) {
                if (f.get(idx) != 0 || foundfirstNonZeroEntry) {
                    System.out.printf("%5.1f %5d %5d %n", (idx / 10.0), f.get(idx), f.getCum(idx));
                    foundfirstNonZeroEntry = true;
                }
            }
        }
    }
}
