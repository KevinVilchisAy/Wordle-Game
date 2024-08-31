//Description: This code will help to read each letter from the word the user uses so that it can detect if the letter is in the correct placement, setting a color to each letter based if they are correct or not.
public class WordleLetter{
    private char letter; //for the word letters
    private String color; //the letters' color

    // Constructor
    public WordleLetter(char letterIn){//assign a letter from the word
        this.letter = letterIn;
    }//constructor 

    public void setColor(String colorIn){//sets the letters' color
        this.color = colorIn;
    }//setColor

    public boolean isColored(){//Check if the letter has an assigned color  
        return color != null;
    }//isColored

    public boolean isGreen(){//checks if the letters' color is green
        return "green".equals(color);
    }//isGreen

    public char getLetter(){//gets the letter from the word
        return letter;
    }//getLetter

    // toString method (provided)
    public String toString(){// Will determine the color code and will apply it based on the letter and its attribute
        String colorCode;

        if (color.equals("green")) {
            colorCode = "\u001B[32m";
        }else if (color.equals("yellow")) {
            colorCode = "\u001B[33m";
        }else {
            colorCode = "\u001B[31m";
        }//else
        
        // Reset color code
        String resetCode = "\u001B[0m";
        // Surround the letter with color codes
        return String.format("%s %s %s", colorCode, letter, resetCode);
    }//toString
}//class 
