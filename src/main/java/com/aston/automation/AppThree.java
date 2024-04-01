package com.aston.automation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AppThree {
    public static void main(String[] args) {
        // 3.
        List<String> arrayList = new ArrayList<>(Arrays.asList("f10", "f15", "f2", "f4", "f4"));
        System.out.println(sortAndAddToArr(arrayList));

    }

    public static String sortAndAddToArr(List<String> arrayList) {
        List<String> sortedList = arrayList.stream().sorted().collect(Collectors.toList());
        return sortedList.toString();
    }
}
