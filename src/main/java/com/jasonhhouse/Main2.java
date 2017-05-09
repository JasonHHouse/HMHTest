package com.jasonhhouse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Jason on 5/8/2017.
 */
public class Main2 {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("Gimli");
        words.add("Fili");
        words.add("Ilif");
        words.add("Ilmig");
        words.add("Mark");

        //Generate the subsets
        ArrayList<ArrayList<String>> subsets = subsets(words);

        //Generate the permutations of the subsets
        ArrayList<ArrayList<String>> permutations = new ArrayList<>();
        for (ArrayList<String> subset : subsets) {
            permutations.addAll(permute(subset));
        }

        //Convert to string and check if palindrome
        for(ArrayList<String> permutation : permutations) {
            String possiblePalindromes = permutation.stream().collect(Collectors.joining());
            if(isPalindrome(possiblePalindromes)) {
                System.out.println(possiblePalindromes);
            }
        }

    }

    private static <T extends Comparable> ArrayList<ArrayList<T>> subsets(List<T> tList) {
        if (tList == null) {
            return null;
        }

        Collections.sort(tList);
        ArrayList<ArrayList<T>> results = new ArrayList<>();

        for (T aTList : tList) {
            ArrayList<ArrayList<T>> temp = new ArrayList<>();

            for (ArrayList<T> result : results) {
                temp.add(new ArrayList<>(result));
            }

            for (ArrayList<T> a : temp) {
                a.add(aTList);
            }

            ArrayList<T> single = new ArrayList<>();
            single.add(aTList);
            temp.add(single);

            results.addAll(temp);
        }

        return results;
    }


    private static <T extends Comparable> ArrayList<ArrayList<T>> permute(List<T> permuteList) {
        ArrayList<ArrayList<T>> results = new ArrayList<>();

        for (T aPermuteList : permuteList) {
            ArrayList<ArrayList<T>> current = new ArrayList<>();

            for (ArrayList<T> result : results) {
                for (int i = 0; i < result.size() + 1; i++) {
                    result.add(i, aPermuteList);
                    ArrayList<T> temp = new ArrayList<>(result);
                    current.add(temp);
                    result.remove(i);
                }
            }

            results = new ArrayList<>(current);
        }

        return results;
    }

    private static boolean isPalindrome(String value) {
        String reverse = new StringBuilder(value).reverse().toString();
        return value.equalsIgnoreCase(reverse);
    }
}
