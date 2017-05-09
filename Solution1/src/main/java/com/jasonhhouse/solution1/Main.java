package com.jasonhhouse.solution1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Jason on 5/8/2017.
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.findPalindromes();
    }

    private Set<String> permutations;

    public Main() {
        this.permutations = new LinkedHashSet<>();
    }

    private static boolean isPalindrome(String value) {
        String reverse = new StringBuilder(value).reverse().toString();
        return value.equalsIgnoreCase(reverse);
    }

    private void findPalindromes() {
        List<String> words = new ArrayList<>();
        words.add("Gimli");
        words.add("Fili");
        words.add("Ilif");
        words.add("Ilmig");
        words.add("Mark");

        getPermutations(words);

        for (String permutation : permutations) {
            if (isPalindrome(permutation)) {
                System.out.println(permutation);
            }
        }
    }

    private void getPermutations(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            permutations.add(words.get(i));

            for (int j = 0; j < words.size(); j++) {
                if (isNotEqual(i, j)) {
                    String combined = words.get(i) + words.get(j);
                    permutations.add(combined);
                }

                for (int k = 0; k < words.size(); k++) {
                    if (isNotEqual(i, j, k)) {
                        String combined = words.get(i) + words.get(j) + words.get(k);
                        permutations.add(combined);
                    }

                    for (int l = 0; l < words.size(); l++) {
                        if (isNotEqual(i, j, k, l)) {
                            String combined = words.get(i) + words.get(j) + words.get(k) + words.get(l);
                            permutations.add(combined);
                        }

                        for (int m = 0; m < words.size(); m++) {
                            if (isNotEqual(i, j, k, l, m)) {
                                String combined = words.get(i) + words.get(j) + words.get(k) + words.get(l) + words.get(m);
                                permutations.add(combined);
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean isNotEqual(Integer... values) {
        Set<Integer> setValues = new HashSet<>(Arrays.asList(values));
        return setValues.size() == values.length;
    }

}
