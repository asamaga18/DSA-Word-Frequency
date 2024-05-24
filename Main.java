import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

class Main {
  public static void main(String[] args) {
    try {
      File myObj = new File("TextFile.txt");
      Scanner myReader = new Scanner(myObj);
      WordCounter counter = new WordCounter();
      while (myReader.hasNext()) {
        String data = myReader.next().toLowerCase();
        String data1 = ""; // new variable of 'data' with only letters and apostrophe

      // Loop through each character in line
      for (int j = 0; j<data.length(); j++){//97-122
        // uses ascii values to eliminate characters
        if (((data.charAt(j)>=97)&&(data.charAt(j)<=122))||(data.charAt(j)==39)){ // 39 is ascii for apostrophe
          
            data1+=data.charAt(j); 
        
        }
        else if(((j != 0)&&(j != data.length()-1)&&(data.charAt(j)==45))) {
          if (((data.charAt(j-1)>=97)&&(data.charAt(j-1)<=122))  && ((data.charAt(j+1)>=97)&&(data.charAt(j+1)<=122)) ){
            data1+=data.charAt(j); // if it is a double dash, checks for letters before and after
          }
          else{
            data1 += ' '; // single dash is replaced with a space
          }
          
        }
      }

        if (data1.length() != 0) {
          if (data1.indexOf(" ") == -1) //if length isnt 0 and no spaces, adds to count
            counter.insert(data1);
          else{
            if (data1.indexOf(" ") == 0){//if contains a space in the first value
              data1 = data1.substring(1,data1.length()-1); // removes
            }
            while (data1.indexOf(" ") != -1){//while spaces are still present
              String data3 = data1.substring(0,data1.indexOf(" "));//new string up to the space
              counter.insert(data3);//adds it
              data1 = data1.substring(data1.indexOf(" ")+1,data1.length());//data 1 without added word
            }
            counter.insert(data1);//adds last word
            
          }
        }

      }
      System.out.println("Total Word Count: " + counter.TotalWordCount());//prints total word count
      
      System.out.println("\nAll Words in Length and Alphabetical Order with Frequency");
      counter.print();//prints all words in length order alphabetically with the frequency

      

      
    
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    
  }
}