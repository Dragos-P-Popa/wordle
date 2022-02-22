package comp1721.cwk1;

import java.util.Arrays;
import java.util.Scanner;


public class Guess {
  // Use this to get player input in readFromPlayer()
  private static final Scanner INPUT = new Scanner(System.in);

  // TODO: Implement constructor with int parameter
  public Guess(int GuessNumber){
    if (GuessNumber < 1 || GuessNumber > 6){
      throw new GameException("ERROR");
    }
  }

  // TODO: Implement constructor with int and String parameters
  public Guess(int GuessNumber, String chosenWord){
    /**if ((GuessNumber < 1 || GuessNumber > 6) || (!chosenWord.toUpperCase().matches("[A-Z]")) || (chosenWord.length() != 5)) {
      throw new GameException("ERROR");
    }**/
  }

  // TODO: Implement getGuessNumber(), returning an int
  public int getGuessNumber(){

  return 0;
  }

  // TODO: Implement getChosenWord(), returning a String
  public String getChosenWord(){

  return "";
  }

  // TODO: Implement readFromPlayer()
  public void readFromPlayer(){

  }

  // TODO: Implement compareWith(), giving it a String parameter and String return type
  public String compareWith(String s){
    String[] guess = s.split("");
    String[] word = getChosenWord().split("");
    String output = "";

    for (int i = 0; i < 5; i++) {
      if(Arrays.asList(word).contains(guess[i]) && Arrays.asList(word).indexOf(guess[i]) == i){
        output = output + "\033[30;102m "+ guess[i] +" \033[0m";
      }
      if(Arrays.asList(word).contains(guess[i]) && Arrays.asList(word).indexOf(guess[i]) != i){
        output = output + "\033[30;103m "+ guess[i] +" \033[0m";
      }
      if(!Arrays.asList(word).contains(guess[i])){
        output = output + "\033[30;107m "+ guess[i] +" \033[0m";
      }
    }
  return output;
  }

  // TODO: Implement matches(), giving it a String parameter and boolean return type
  public Boolean matches(String s){

  return true;
  }
}
