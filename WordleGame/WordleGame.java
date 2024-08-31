import java.io.FileNotFoundException;
//Description: This code will have the methods that will allow to make guesses, to determine if the answer is correct, and to determine if the user won or lost

public class WordleGame{
    private WordleLetter[][] allGuesses = new WordleLetter[6][5];
    private String answer;
    private int tries = 0;

    // Constructor
    public WordleGame(int puzzleNumber){//will obtain the word that the player will seek to answer
        this.answer = WordBank.getAnswerForPuzzleNumber(puzzleNumber);
    }//WordleGame

    public String getAnswer(){//getter method to obtain the word answer
        return answer;
    }//getAnswer

    public void guess(String guessWord){//will check the user's guess
        char[] guessChars = guessWord.toCharArray();
        char[] answerChars = answer.toCharArray();//Will change the word into a charcater array

        for (int i = 0; i < guessChars.length; i++){//will check each letter of the word
            char guessLetter = guessChars[i];
            WordleLetter letter = new WordleLetter(guessLetter);

            if (guessLetter == answerChars[i]){//check if the current letter is in the winner word
                letter.setColor("green");//will set the letter to green in case it is in the correct placement
            }else if (answer.indexOf(guessLetter) != -1){//will set the color to yellow in case the letter is in the word
                letter.setColor("yellow");
            }else{
                letter.setColor("red");//will set the color to red in case the letter is not in the word
            }//else
            // Store the letter in the allGuesses array
            allGuesses[tries][i] = letter;
        }//for
        tries++;//will add to the tries counter
    }//guess

    public int getNumberGuessesSoFar(){//gets the number of times the user had tried to solve the puzzle
        return tries;
    }//getNumberGuessesSoFar

    public WordleLetter[] getGuess(int guessNumber){//will determine how many guesses had been use
        return allGuesses[guessNumber];
    }//getUserGuess

    public boolean isGameOver(){//this method will determine if the game is over
        boolean correctWord = true;

        if(tries == 0){//in case the user has not made any tries
            return false;
        }//if

        for (int i = 0; i < 5; i++) {//in case all of the letters are green
            if (!allGuesses[tries - 1][i].isGreen()){
                correctWord = false;
            }//if
        }//for
        return (tries == 6 || correctWord);//in case the number of tries used by the user are 6 or the letters are not all green
    }//

    public boolean isGameWin(){//this method will determine if the user has won

        if (tries == 0){
            return false;//Checks in case the game has not started yet    
        }//if                       
        WordleLetter[] userLastGuess = allGuesses[tries - 1];//will take one of the guesses opportunities
        String guessWord = "";
        for (int i = 0; i < userLastGuess.length; i++){
            guessWord += userLastGuess[i].getLetter();//will traverse the user guess word and check if it is the same as the correct answer
        }//for
        return guessWord.equals(answer);
    }//isGameWin

    public String toString(){//This method will check each letter
        String checkedWord = "";

        for(int i=0; i<6; i++){//will traverse the word
            if(allGuesses[i][0] == null){////will stop in case there are no more letters
                break;
            }for(int j = 0; j<5; j++){
                if(allGuesses[i][j] == null){//will check in case the word doesn't have any more letters
                    break;
                }//if
                checkedWord += allGuesses[i][j];//will asign the letter to the checkWord
            }//for
            checkedWord += "\n";//will leave a space between the words
        }//for  
        return checkedWord;     
    }//toString
}//WordleGame
