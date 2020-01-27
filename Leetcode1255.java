

public class Leetcode1255 {
	public static void main(String[] args) {
		String[] words = {"add","dda","bb","ba","add"};
		char[] letters = {'a','a','a','a','b','b','b','b','c','c','c','c','c','d','d'};
		int[] score = {3,9,8,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		
		/*
		 * 21+18+12
		 * 21+18+12
		 * 18+12+21
		 */
		
		int[] letterCount = new int[26];
		
		for (int i = 0; i < letters.length; i++) {
            letterCount[letters[i] - 'a']++;
        }
		
		int result = maxScoreWords(words, letterCount, score, 0);
		System.out.println(result);
	}

	public static int maxScoreWords(String[] words, int[] letterCount, int[] score, int index) {
        int maxScore = 0;
        
        for (int i = index; i < words.length; i++) {
            boolean wordFormed = true;
            int wordScore = 0;
            for (int j = 0; j < words[i].length(); j++) {
                Character c = words[i].charAt(j);
                if (letterCount[c-'a'] <= 0) {
                    wordFormed = false;
                } else {
                    wordScore += score[c - 'a'];
                }
                letterCount[c-'a']--;
            }
            
            if (wordFormed) {
            	wordScore += maxScoreWords(words, letterCount, score, i+1);
            	maxScore = Math.max(maxScore, wordScore);
            }
            
            wordFormed = true;
            for (Character c : words[i].toCharArray()) { //restore letterCount array
                letterCount[c - 'a']++;
            }
        }
        
        return maxScore;
    }
}
