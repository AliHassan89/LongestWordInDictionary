/*
Problem:

Given a key and list of words in dictionary. The size of dictionary could be very large (billions
of words). Find the longest word in the dictionary that contains all the alphabets which are
present in the key.

e.g:
dictionary = {"act", "acquaintance", "trace"};
key = "cat";

result: acquaintance
 */

/*
Solution:

- Convert each word into a token.
- The token is calculated in a way that each bit in word corresponds to that character. It is checked
if character in word of dictionary exist in key then that bit is turned to 1 otherwise the bit remains
0.
- Perform AND operation between token of key and token of the word of dictionary.
- This AND operation is between two integers, that is why '&' is used instead of '&&' which is used
for performing AND operation on booleans.
- On doing AND operation on integers, if word has all the characters that key has then the AND
operation will produce number equivalent to keyNum.

 */

package main.java;

import java.util.List;

public class LongestWord {

  public String findLongestWordInDictionary(String key, List<String> dictionary) {
    if (dictionary.size() == 0){
      return "";
    }

    int keyNum = convertStringToNumber(key);
    int wordNum = 0;
    String longestWord = "";

    for (String word : dictionary){
      if (longestWord.length() < word.length()){
        wordNum = convertStringToNumber(word);
        if ((keyNum & wordNum) == keyNum){
          longestWord = word;
        }
      }
    }

    return longestWord;
  }

  private int convertStringToNumber(String word){
    int num = 0;
    for (char c : word.toCharArray()){
      if (!Character.isDigit(c)){
        num |= 1 << (c - 'a');
      }
    }
    return num;
  }
}
