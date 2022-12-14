package comp1721.cwk1;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;


public class Guess {
  // Use this to get player input in readFromPlayer()
  private static final Scanner INPUT = new Scanner(System.in);
  public String chosenWord, saveString;
  public int guessNumber = 0;

  // TODO: Implement constructor with int parameter
  public Guess(int GuessNumber){
    //Limiting the number of guesses to 6
    if (GuessNumber < 1 || GuessNumber > 6){
      throw new GameException("");
    }
    guessNumber = GuessNumber;
  }

  // TODO: Implement constructor with int and String parameters
  public Guess(int GuessNumber, String Cword){
    //Limiting guesses to 6 and checking if guess is strictly alphabetic and 5 characters long
    if ((GuessNumber < 1 || GuessNumber > 6) || (!Cword.matches("[a-zA-Z]+")) || (Cword.length() != 5)) {
      throw new GameException("");
    }
    guessNumber = GuessNumber;
    chosenWord = Cword.toUpperCase();
  }

  // TODO: Implement getGuessNumber(), returning an int
  public int getGuessNumber(){
    //Returning the current guess number
  return guessNumber;
  }

  // TODO: Implement getChosenWord(), returning a String
  public String getChosenWord(){
    //Returning chosen word
  return chosenWord;
  }

  // TODO: Implement readFromPlayer()
  public void readFromPlayer(){

  }

  // TODO: Implement compareWith(), giving it a String parameter and String return type
  public String compareWith(String s){
    //Splitting the guessed word into separate letters
    //This way I am easily able to compare the guessed word to the chosen word letter by letter
    String[] guess = s.split("");
    String[] word = getChosenWord().split("");
    //Initialising string for return
    String output = "";

    //Appending to the output string depending on the result of the comparison
    for (int i = 0; i < 5; i++) {
      if(Arrays.asList(word).contains(guess[i]) && Arrays.asList(word).indexOf(guess[i]) == i){
        output = output + "\033[30;102m "+ word[i] +" \033[0m";
      }
      if(Arrays.asList(word).contains(guess[i]) && Arrays.asList(word).indexOf(guess[i]) != i){
        output = output + "\033[30;103m "+ word[i] +" \033[0m";
      }
      if(!Arrays.asList(word).contains(guess[i])){
        output = output + "\033[30;107m "+ word[i] +" \033[0m";
      }
    }
    return output;
  }

  // TODO: Implement matches(), giving it a String parameter and boolean return type
  public Boolean matches(String s){
    //Simple comparison of two words
    return Objects.equals(s, getChosenWord());
  }
}
