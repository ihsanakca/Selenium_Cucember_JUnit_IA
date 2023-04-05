package com.krafttech;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       String str="ahmat";
        System.out.println("longestSubWithoutRepeat2(str) = " + longestSubWithoutRepeat2(str));
        System.out.println("longestSubWithoutRepeat(str) = " + longestSubWithoutRepeat(str));

    }
    /**
     * Given a string s, find the length of the longest substring without repeating characters.
     * Example 1:
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * Example 2:
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * Example 3:
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     *
     * atmaca
     */

    public static int longestSubWithoutRepeat(String str){
        int max=0;
        for (int i = 0; i < str.length(); i++) {
            String control=str.substring(i,i+1);
            for (int j = i+1; j < str.length(); j++) {
                if (!control.contains(str.substring(j,j+1))){
                    control+=str.substring(j,j+1);
                }else break;
            }
            max=Math.max(max,control.length());
        }
        return max;
    }

    public static int longestSubWithoutRepeat2(String str){
        if (str.length()==0) return 0;
        List<String> allSubs=new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i+1; j <str.length() ; j++) {
                String newStr=str.substring(i,j);
                allSubs.add(newStr);
            }
        }
        System.out.println("allSubs = " + allSubs);
        List<String> allUniqueSubs=new ArrayList<>();
        for (String sub : allSubs) {
            if (isUnique(sub)){
                allUniqueSubs.add(sub);
            }
        }
        System.out.println("allUniqueSubs = " + allUniqueSubs);

        List<Integer> allUniqueSubsLength=new ArrayList<>();

        for (String allUniqueSub : allUniqueSubs) {
            allUniqueSubsLength.add(allUniqueSub.length());
        }
        return Collections.max(allUniqueSubsLength);
    }
    public static boolean isUnique(String str){
        for (int i = 0; i <str.length() ; i++) {
            if (str.indexOf(str.charAt(i))!=str.lastIndexOf(str.charAt(i))){
                return false;
            }
        }
        return true;
    }


}