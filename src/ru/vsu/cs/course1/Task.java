package ru.vsu.cs.course1;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task {
    public static List<Integer> intToList(int[] matrix) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++){
            result.add(matrix[i]);
        }
        return result;
    }
    public static int[] listToInt(List<Integer> matrix) {
        int[] result = new int[matrix.size()];
        for (int i = 0; i < matrix.size(); i++){
            result[i] = matrix.get(i);
        }
        return result;
    }
    public static int[][] makeTable(List<List<Integer>> arrayList, int lenOrig){

        for (int i = 0; i < arrayList.size();i++){
            if (arrayList.get(i).size() > lenOrig){
                lenOrig = arrayList.get(i).size();
            }
        }
        int[][] result = new int[arrayList.size()][lenOrig];

        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < arrayList.get(i).size(); j++) {
                result[i][j] = arrayList.get(i).get(j);
            }
        }
        return result;
    }

    public static List<Integer> binary(int number, int len) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            result.add(0);
        }
        while (number > 0) {
            result.set(len - 1, number % 2);
            number /= 2;
            len--;
        }
        return result;
    }

    public static List<List<Integer>> solve(List<Integer> weights, int sumWeight) {
        List<List<Integer>> resultList = new ArrayList<>();

        int listLen = weights.size();

        for (int i = 1; i < Math.pow(2, weights.size()); i++) {
            List<Integer> currentList = binary(i, listLen);

            int currentSum = 0;

            List<Integer> inputList = new ArrayList<>();

            for (int j = 0; j < listLen; j++) {
                if (currentList.get(j) == 1) {
                    currentSum += weights.get(j);
                    inputList.add(weights.get(j));
                }else {
                    inputList.add(0);
                }
            }
            if (currentSum == sumWeight) {
                resultList.add(inputList);
            }
        }
        return resultList;
    }
}
