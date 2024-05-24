import java.util.*;
class WordCounter {
  private Map<Integer, TreeSet<String>> LenList = new TreeMap<>();
  // Lenlist maps the length of each word to a set of all words at that length
  private Map<String, Integer> freqMap = new TreeMap<>();
  // freqMap maps the frequency of specific words to the words themselves
  private int count = 0;
  public WordCounter() {}
  public void insert(String s){ // puts a string into the lenlist and updates frequency
    if(!s.isBlank()){
    count++;//counts each input
    if(LenList.get(s.length())==null){ //if no treeset is present
      TreeSet<String> i = new TreeSet<String>();//creates new treeset
      LenList.put(s.length(), i); // inserts new treeset into  map
    }
    LenList.get(s.length()).add(s);//adds word to treeset

    if(freqMap.get(s)==null){ // if it is the first time word is being inserted
      freqMap.put(s, 0);//creates it and sets it to zero
    }
    freqMap.put(s, freqMap.get(s)+1);//+1
    }
  }
  public int TotalWordCount(){ // returns total word count
    return count;
  }
  public int getCount(String w){ // returns frequency of word
    String word = w.toLowerCase();
    if (freqMap.get(word) != null){ // if word exists 
      return freqMap.get(word);//returns frequency
    }
    else{return 0;}//word doesnt exist so returns 0
  }

  public void print(){ // prints out word list in order of smallest to largest length alphabetically with frequencies
    for (int i : LenList.keySet()){//goes through all the keys in map
      for (String j : LenList.get(i)){//goes through all words in set
        
          System.out.println(j+ ": "+freqMap.get(j));//prints word and frequncy
       
      }
    }
  }
    
}