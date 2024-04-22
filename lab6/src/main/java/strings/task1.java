package strings;

import java.util.*;


public class task1 {
    public static void main(String[] args) {
        String text = "Сааамый длинный текст шалаш. Средний длинный текст. Короткий текст.";
        sortSentencesByWordCount(text);
        //5
        String modifiedText = swapFirstAndLastWords(text);
        System.out.println("Текст с поменянными местами первыми и последними словами в каждом предложении:");
        System.out.println(modifiedText);
        System.out.println("Найти такое  слово  в  первом  предложении,  которого  нет  ни  в  одном из остальных предложений.");
        uniqueWord(text);
        //16
        String replacedText = replaceWordsOfLength(text, 6, "очень длинный");
        System.out.println("Исходный текст:");
        System.out.println(text);
        System.out.println("\nТекст с заменой слов:");
        System.out.println(replacedText);
        //14
        String longestPalindrome = findLongestPalindrome(text);
        System.out.println("Самый длинный палиндром: " + longestPalindrome);
    }

    public static void sortSentencesByWordCount(String text) {
        String[] sentences = text.split("[.!?]\\s*");

        Arrays.sort(sentences, Comparator.comparingInt(sentence -> sentence.split("\\s+").length));

        System.out.println("Предложения в порядке возрастания количества слов:");
        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }

    private static String swapFirstAndLastWords(String text) {
        StringBuilder modifiedText = new StringBuilder();

        String[] sentences = text.split("[.!?]\\s*");

        for (String sentence : sentences) {
            String[] words = sentence.split("\\s+");

            if (words.length > 1) {
                String firstWord = words[0];
                String lastWord = words[words.length - 1];
                words[0] = lastWord;
                words[words.length - 1] = firstWord;
                String modifiedSentence = String.join(" ", words);
                modifiedText.append(modifiedSentence).append(". ");
            } else {
                modifiedText.append(sentence).append(". ");
            }
        }

        return modifiedText.toString().trim();
    }

    static void uniqueWord(String text) {
        String[] sentences = text.split("\\. ");
        String[] firstSentenceWords = sentences[0].split("\\s+");
        boolean foundUniqueWord = false;

        for (String word : firstSentenceWords) {
            boolean isUnique = true;

            for (int i = 1; i < sentences.length; i++) {
                String[] otherSentenceWords = sentences[i].split("\\s+");
                for (String otherWord : otherSentenceWords) {
                    if (word.toLowerCase().equals(otherWord.toLowerCase())) {
                        isUnique = false;
                        break;
                    }
                }
                if (!isUnique) {
                    break;
                }
            }
            if (isUnique) {
                System.out.println("Уникальное слово в первом предложении: " + word);
                foundUniqueWord = true;
                break;
            }
        }
        if (!foundUniqueWord) {
            System.out.println("В первом предложении нет уникальных слов.");
        }
    }
    public static String replaceWordsOfLength(String text, int length, String replacement) {
        StringBuilder result = new StringBuilder();
        String[] words = text.split("\\s+");

        for (String word : words) {
            if (word.length() == length) {
                result.append(replacement).append(" ");
            } else {
                result.append(word).append(" ");
            }
        }

        return result.toString().trim();
    }
    public static String findLongestPalindrome(String text) {
        if (text == null || text.length() < 2) {
            return text;
        }

        int maxLength = 1;
        int start = 0;
        int len = text.length();
        boolean[][] dp = new boolean[len][len];


        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }


        for (int i = 0; i < len - 1; i++) {
            if (text.charAt(i) == text.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        for (int currLen = 3; currLen <= len; currLen++) {
            for (int i = 0; i < len - currLen + 1; i++) {
                int j = i + currLen - 1;
                if (text.charAt(i) == text.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    maxLength = currLen;
                }
            }
        }
        return text.substring(start, start + maxLength);
    }
}


