package comp1721.cwk1;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Game {
  public String word, saveString = "";
  public WordList list;
  public LocalDate initialDate;
  public LocalDate currentDate;
  public Guess guess;

  // TODO: Implement constructor with String parameter
  public Game(String location) throws IOException {
    //Getting today's date and calculating difference from 19th of June 2021, when the first wordle
    //game started in order to get the game of the day.
    initialDate = LocalDate.of(2021, 6, 19);
    currentDate = LocalDate.now();
    long daysBetween = ChronoUnit.DAYS.between(initialDate, currentDate);

    //Reading all words
    list = new WordList(location);
    //Picking the word of the day using index
    word = list.getWord((int) daysBetween);
  }

  // TODO: Implement constructor with int and String parameters
  public Game(int i, String location) throws IOException {
    //Getting certain word for the game
    list = new WordList(location);
    word = list.getWord(i);
  }

  // TODO: Implement play() method
  public void play(){
    for (int i = 1; i < 7; i++) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);
      System.out.println("Enter guess ("+i+"/6): ");
      String wordGuessed = input.nextLine();
      //Creating new guess so that we can compare words
      guess = new Guess(i,wordGuessed);
      //Saving output from comparWith() for the save file
      saveString = saveString + guess.compareWith(word) + "\n";
      //Outputting for user
      System.out.println(guess.compareWith(word));
      //Game end message depending on the number of guesses
      if (guess.matches(word)){
        if (i == 1){
          System.out.println("Superb - Got it in one!");
          break;
        }
        if (2<=i && i<=5){
          System.out.println("Well done!");
          break;
        }
        if (i == 6){
          System.out.println("That was a close call!");
          break;
        }
      }
    }


  }

  // TODO: Implement save() method, with a String parameter
  public void save(String s) throws IOException {
    //Opening file, deleting any old save game with the same name and then saving current game.
    FileWriter fw = new FileWriter(s);
    fw.write(saveString);
    fw.close();
  }
}
