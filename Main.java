package com.company;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {



    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        String str = "Object-oriented programming";
        String str2 = "OOP";
        int lat = isLat(text);
        int index = 0;
        int count = 0;
        Set<CharSequence> ans = printAllPalindromes(text);


        while (index != -1) {
            index = text.indexOf(str, index);
            if (index != -1) {
                if (count % 2 != 0) {
                    text = text.substring(0, index) + str2 + text.substring(index + str.length());
                }
                count++;
                index += str.length();
            }
        }
        System.out.println(text);
        System.out.println(findWordOfMinDifferentChars(text));
        System.out.println(lat);
        System.out.println(ans);


            }
    private static String findWordOfMinDifferentChars(String text){
        String[] words = text.split(" ");
        String wordOfMinDiffChars = words[0];
        int  minCountOfDifferentChars = words[0].length();
        for (String word : words) {
            char [] chars = word.toCharArray();
            int currentCount = getCountDifferentChars(chars);
            if(currentCount<minCountOfDifferentChars) {
                minCountOfDifferentChars = currentCount;
                wordOfMinDiffChars = word;
            }
        }
        return wordOfMinDiffChars;
    }

    private static int getCountDifferentChars(char[] chars) {

        int countOfDifferentChars = 0;
        int countOfMatchingChars = 0;
        char charToCompare;
        for (char var1 : chars) {
            int compareCount = 0;
            charToCompare = var1;
            for (char var2 : chars) {
                if (charToCompare == var2) {
                    compareCount++;
                }
            }
            if (compareCount == 1)
                countOfDifferentChars++;
            else
                countOfMatchingChars++;
        }

        return countOfDifferentChars + countOfMatchingChars/2;
    }

    private static int isLat(String text){
        int counter = 0;
        String[] ans = text.split(" ");
        for(int i = 0;i < ans.length;i++){
            if (ans[i].matches("[a-zA-Z]+")){
                counter++;
            }
        }
        return(counter);
    }

    public static Set<CharSequence> printAllPalindromes(String input) {
        Set<CharSequence> out = new HashSet<CharSequence>();
        int length = input.length();
        for (int i = 1; i <= length; i++) {
            for (int j = i - 1, k = i; j >= 0 && k < length; j--, k++) {
                if (input.charAt(j) == input.charAt(k)) {
                    out.add(input.subSequence(j, k + 1));
                } else {
                    break;
                }
            }
        }
        return out;
    }

}




