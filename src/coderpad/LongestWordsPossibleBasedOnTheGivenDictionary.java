package coderpad;

import java.util.*;

/*
 * print longest possible combination of the characters 
    in a given input string, based on the given dictionary
   example : 
   dictionary is : {"to","toe","toes","doe","dog","god","dogs","book","banana"} and 
   input String is "dsetog"
            
   expected output : toes, dogs
 */

class LongestWordsPossibleBasedOnTheGivenDictionary/*LongestPermutationInDictionary*/ {
  private Set<String> longestWords;// = new HashSet<String>();

  public int getLongestLength() {
    return longestLength;
  }

  private int longestLength;

  public String getBaseWord() {
    return baseWord;
  }

  private String baseWord;



  LongestWordsPossibleBasedOnTheGivenDictionary(String input) {
    longestWords = new HashSet<String>();
    longestLength = 0;
    baseWord = input;
  }
  public void printOutputBasedOnDictionary(Dictionary myDictionary) {
    findLongestWordsPresentInDictionary("", baseWord, myDictionary);
    System.out.println("::Words of length " + this.getLongestLength() + " from Input string, based on the given dictionary::");
    for(String word: longestWords)
      System.out.println(word);
  }
  
  
  private void findLongestWordsPresentInDictionary(String inMaking, String rest, Dictionary myDictionary) {
    
    if("".equals(rest)){
      String longWord = longestPossibleFromDictionary(inMaking, myDictionary);
      if (!longWord.isEmpty()){
        if(longWord.length() > longestLength) {
          longestLength = longWord.length();
          longestWords = new HashSet<String>();
          longestWords.add(longWord);
        }else if(longWord.length() == longestLength )
          longestWords.add(longWord);
      }
    }
    
    //get all permutations of a 'rest' string.
    for(int i=0; i< rest.length();i++){
      findLongestWordsPresentInDictionary(inMaking+rest.charAt(i), 
                                           rest.substring(0, i)+rest.substring(i+1, rest.length()), myDictionary);
    }
        
  }
  
  private static String longestPossibleFromDictionary(String str, Dictionary myDictionary) {
    for(int i=str.length();i>0;i--){
      if(myDictionary.contains(str.substring(0, i)))
        return str.substring(0, i);
    }
    return "";
  }
  

  public static void main(String[] args) {
    // String[] words = new String[]{"to","toe","toes","doe","dog","god","dogs","book","banana"};
    String[] words = new String[]{"to","toe","doe","dog","god","book","banana"};
    // String[] words = new String[]{"to","toe"};

    String input = "dsetog";

    LongestWordsPossibleBasedOnTheGivenDictionary longestWordFinder = new LongestWordsPossibleBasedOnTheGivenDictionary(input);

    Dictionary myEnglishDic = longestWordFinder.new Dictionary();
    for(String s: words)
      myEnglishDic.add(s);
    
    //print longest possible combination of the characters in 'input', based on the given dictionary
    System.out.println("Input:: " + longestWordFinder.getBaseWord());
    longestWordFinder.printOutputBasedOnDictionary(myEnglishDic);
  }


  class Dictionary {
    Set<String> words;
    Dictionary(){
      words = new HashSet<String>();
    }
    public void add(String word){
      words.add(word);
    }
    public Boolean contains(String word) {
      return words.contains(word);
    }
  }
}