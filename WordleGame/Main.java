
//Description: This will be the main code for the WordleGame, it has methods that will call the methods from the other classes and will create instances of them. 

import java.io.FileNotFoundException;
import java.util.Scanner;

class Main{
    public static WordleGame startGame(Scanner scanner){//this method will be used to obtain a number to determine the word it will use for the game
        int wordleNumber = 0;
        System.out.println("Welcome to the best Wordle Game:P");
        System.out.println("You will have 6 tries. GOOD LUCK");
        System.out.println("Please enter the wordle number (between 0 and 2315): ");
        wordleNumber = scanner.nextInt();
        while(wordleNumber<0 || wordleNumber>2315){//will determine if the number is in the answer list
            System.out.println("Your number is invalid!");
            System.out.println("Please enter the wordle number (between 0 and 2315):");
            wordleNumber = scanner.nextInt();
        }//while
        WordleGame newGame = new WordleGame(wordleNumber);//will asign and return the word that will be used 
        return newGame;
    }//startGame

    public static void playGame(Scanner scanner, WordleGame game){//this method will ask the user for a word and check if it is valid 
        String userWord;

        while(!game.isGameOver()){//will keep the user in a loop while the game is not over
            System.out.println("Please enter a valid 5 world letter that is in the dictionary:");
            userWord = scanner.next();
            while(!WordBank.checkInDictionary(userWord) || userWord.length()!=5){//will check if the word inputed by the user is in the dictionary, in case it is not or the word is not of 5 characters it will keep the user in a loop asking for another word
                System.out.println("Your word is invalid!");
                System.out.println("Please enter a valid 5 world letter that is in the dictionary:");
                userWord = scanner.next();
            }//while
            game.guess(userWord);//will call the userGuess method from the WordleLetter class and assign it the user inputed word
            System.out.println(game.toString());
        }//while

    }//playGame`

    public static void reportGameOutcome(WordleGame game){//will determine if the user has won or lost the game based in the isGameWin method from the WordleGame class
        
        if (game.isGameWin()){
            System.out.println("You won:D !");//in case the user won
        }else{
            System.out.println("You lost:( the answer was: " + game.getAnswer());//in case the user lost, it will include the winner word
        }//else
        
    }//reportGameOutcome

    public static void main(String[] args){//The main method will call the method in the code so the game can be played
        Scanner scanner = new Scanner(System.in);
        WordleGame game = startGame(scanner);
        playGame(scanner, game);
        reportGameOutcome(game);
    }//main
}//class
