package com.aston.automation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class AppTwo {
    public static void main(String[] args) {

        // 2.
        System.out.println("// 2.");

        List<String> arrayList = new ArrayList<>(Arrays.asList("Highload", "High", "High", "Load", "Highload", "Load"));

        System.out.println(findWordInArrays(arrayList, "High"));
        System.out.println(findFirstWord(arrayList));
        System.out.println(findLastWord(arrayList));

    }

    // 2.1
    public static String findWordInArrays(List<String> arrayList, String str) {
        long count = arrayList.stream().filter(w -> w.equals(str)).count();
        return count != 0 ? "Объект " + str + " встречается " + count + " раз(а)." : "0";
    }

    // 2.2
    public static String findFirstWord(List<String> arrayList) {
        Optional<String> first = arrayList.stream().findFirst();
        return first.map(word -> "Первое слово в списке " + word + ".").orElse("0");
    }

    // 2.3
    public static String findLastWord(List<String> arrayList) {
        Optional<String> last = arrayList.stream().reduce((first, second) -> second);
        return last.map(word -> "Последнее слово в списке " + word + ".").orElse("0");
    }
}
