//Description: This code will help to read the word bank that will be used as a base for the woordle game, iterating the file by using a scanner, setting all the words for the game.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordBank{
  public static String getAnswerForPuzzleNumber(int puzzleNumber){
    try{
      /* Create a file scanner to read answers.txt */
      Scanner scanner = new Scanner(new File("answers.txt"));//the scanner will read the answer file
      /* Skip the first puzzleNumber number of words in the file */

      for (int x = 0; x < puzzleNumber; x++){
        scanner.next();
      }//for
      
      /* Return the very next word */ 
      return scanner.next();
    }catch (Exception e){
      /* Handle exception */
      System.out.println("Input/File not found!");
    }//catch
    return null;
  }//getAnswerForPuzzleNumber method

  /* Do not modify the method signature. */
  public static boolean checkInDictionary(String proposed){//
    try{//
      Scanner fileReader = new Scanner(new File("dictionary.txt"));//will read the word dictionary text file with the scanner
        while(fileReader.hasNext()){
          String word = fileReader.next();//will assign the word in the dictionary text to the word variable

          if(word.equals(proposed)){
            return true;//In case the parameter and the text word variable are the same, the nethod will return true
          }//if

        }//while
    }catch (FileNotFoundException e){//will throw an exception in case the file was not found
      System.out.println("The File was not found");
    }//catch 
    return false;
  }//checkInDictionary method
}//class
